package Test.CodeFish.testCase1.CodeFishPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CodeFishRegistPage {

    public CodeFishRegistPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='username']")
    WebElement loginText;


    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordText;

    @FindBy(xpath = "//button[@name='regbtn']")
    WebElement regButton;

    @FindBy(xpath = "//button[@name='loginbtn']")
    WebElement registrBtn;



    public void loginFunctionPage() throws InterruptedException {
        loginText.clear();
        Thread.sleep(3000);
        passwordText.clear();
        Thread.sleep(3000);
        regButton.click();
    }

    public void registFunction(String login, String password) {
        loginText.sendKeys(login);
        passwordText.sendKeys(password);
        registrBtn.click();
    }


}
