package Test.CodeFish.testcase2.CodeFishNinjaPage;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CodeFishNinLogin {

    public CodeFishNinLogin(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "#password")
    WebElement password;
    @FindBy(xpath = "//input[@id='username']")
    WebElement login;

    @FindBy(xpath = "//input[@id='loginButton']")
    WebElement button;

    @FindBy(xpath = "//li[@id='Isolation Ward']")
    WebElement location;

    @FindBy(xpath = "//a[@class='button app big']")
    List<WebElement> registPatientButton;


    public void loginFunctionality(String login, String password) throws InterruptedException {
        this.login.sendKeys(login);
        this.password.sendKeys(password);
        location.click();
        Thread.sleep(1000);
        button.click();
    }

    public void registrPatientButton(String regsitr) throws InterruptedException {
        Thread.sleep(1000);
        for (int i = 0; i < registPatientButton.size(); i++) {
            if (BrowserUtils.getText(registPatientButton.get(i)).contains(regsitr)){
                registPatientButton.get(i).click();
            }
        }
    }
}
