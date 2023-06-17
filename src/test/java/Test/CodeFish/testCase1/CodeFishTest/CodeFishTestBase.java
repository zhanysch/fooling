package Test.CodeFish.testCase1.CodeFishTest;

import Utils.ConfigReader;
import Utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;

public class CodeFishTestBase {

    public WebDriver driver;

    @BeforeMethod
    public void setup(ITestResult iTestResult){
        driver= DriverHelper.getDriver();
        driver.navigate().to(ConfigReader.readProperty("QA_url_CodeFish"));

    }

  /*  @AfterMethod
    public void tearDown(ITestResult iTestResult){
        if (!iTestResult.isSuccess()){
            BrowserUtils.getScreenshotMethod(driver,"codeFish");
        }
        driver.quit();
    }*/


}
