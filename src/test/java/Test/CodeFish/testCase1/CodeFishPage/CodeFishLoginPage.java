package Test.CodeFish.testCase1.CodeFishPage;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CodeFishLoginPage {

    public CodeFishLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='username']")
    WebElement loginText;


    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordText;

    @FindBy(xpath = "//button[@name='loginbtn']")
    WebElement registrBtn;




    public void login(String login, String passwrod) throws InterruptedException {
        Thread.sleep(3000);
        loginText.clear();
        loginText.sendKeys(login);
        passwordText.clear();
        Thread.sleep(3000);
        passwordText.sendKeys(passwrod);
        registrBtn.click();
    }


}
