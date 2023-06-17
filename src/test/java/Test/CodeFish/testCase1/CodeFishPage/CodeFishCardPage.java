package Test.CodeFish.testCase1.CodeFishPage;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CodeFishCardPage {

    public CodeFishCardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='card-body']//button")
    WebElement buttons;

    @FindBy(xpath = "//h5[@class='card-title']")
    List<WebElement> title;

    @FindBy(xpath = "//li[@class='nav-item fs-5']//a[.='Cart']")
    WebElement buttonCart;


    public void titleCart(String pfizerTitle, String sputnikVacine) throws InterruptedException {
        Thread.sleep(1000);
        for (int i = 0; i < title.size(); i++) {
            if (BrowserUtils.getText(title.get(i)).contains(pfizerTitle)
                    && BrowserUtils.getText(title.get(i)).contains(sputnikVacine)){
                Thread.sleep(3000);
                buttons.click();
            }
        }
    }

    public void clickCard(){
        buttonCart.click();
    }
}
