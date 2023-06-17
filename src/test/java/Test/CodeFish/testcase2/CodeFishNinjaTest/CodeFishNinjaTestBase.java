package Test.CodeFish.testcase2.CodeFishNinjaTest;

import Utils.ConfigReader;
import Utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;

public class CodeFishNinjaTestBase {

    public WebDriver driver;

    @BeforeMethod
    public void setup(ITestResult iTestResult){
        driver= DriverHelper.getDriver();
        driver.navigate().to(ConfigReader.readProperty("QA_url_CodeFish_Ninja"));

    }

  /*  @AfterMethod
    public void tearDown(ITestResult iTestResult){
        if (!iTestResult.isSuccess()){
            BrowserUtils.getScreenshotMethod(driver,"codeFish");
        }
        driver.quit();
    }*/


}
