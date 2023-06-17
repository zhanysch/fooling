package Test.CodeFish.testcase2.CodeFishNinjaPage;

import Utils.BrowserUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.logging.XMLFormatter;

public class CodeFishPatientPage {

    public CodeFishPatientPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='givenName']")
    WebElement loginInput;

    @FindBy(xpath = "//input[@name='middleName']")
    WebElement middleName;
    @FindBy(xpath = "//input[@name='familyName']")
     WebElement inputlastName;

    @FindBy(xpath = "//select[@id='gender-field']")
    WebElement gender;

    @FindBy(xpath = "//span[@id='birthdateLabel']")
    WebElement birthdayClick;

    @FindBy(xpath = "//input[@id='birthdateDay-field']")
    WebElement fiellDay;

    @FindBy(xpath = "//select[@id='birthdateMonth-field']")
    WebElement months;

    @FindBy(xpath = "//input[@id='birthdateYear-field']")
    WebElement years;

    @FindBy(xpath = "//span[.='Address']")
    WebElement addressType;

    @FindBy(xpath = "//input[@class='focused']")
    WebElement adressStreet;

    @FindBy(xpath = "//input[@name='cityVillage']")
    WebElement village;

    @FindBy(xpath = "//input[@name='stateProvince']")
    WebElement state ;

    @FindBy(xpath = "//input[@name='country']")
    WebElement county;

    @FindBy(xpath = "//input[@name='postalCode']")
    WebElement zip;

    @FindBy(xpath = "//span[.='Phone Number']")
    WebElement phoneNumber;

    @FindBy(xpath = "//input[@name='phoneNumber']")
    WebElement phoneInput;

    @FindBy(xpath = "//input[@type='submit']")
     WebElement buttonSubmit;

    @FindBy(xpath = "//span[.='101NVD']")
    WebElement patientId;

    @FindBy(xpath = "//a[@id='org.openmrs.module.coreapps.deletePatient']")
    WebElement deletePatient;

    @FindBy(xpath = "//button[@class='confirm right']")
    List<WebElement> confirm;

    @FindBy(xpath = "//h6[@id='delete-reason-empty']")
    WebElement reasonT;

    @FindBy(xpath = "//input[@id='delete-reason']")
    WebElement inputReason;

    public void registerPatient(WebDriver driver,String login,String lastName,String genderType,String value) throws InterruptedException {
        loginInput.sendKeys(login, Keys.ENTER);
        middleName.sendKeys(Keys.ENTER);
        inputlastName.sendKeys(lastName, Keys.ENTER);
        BrowserUtils.selectByMethod(gender,genderType,value);
    }
    public void  setBirthdayClick(WebDriver driver ,String day, String month,String value, String year) throws InterruptedException {
        birthdayClick.click();
        fiellDay.sendKeys(day);
        BrowserUtils.selectByMethod(months,month,value);
        years.sendKeys(year);

    }

    public void setAddress(String adressStreet, String village, String state, String  county,String zip,String phone ) throws InterruptedException {
        addressType.click();
        this.adressStreet.sendKeys(adressStreet);
        this.village.sendKeys(village);
        this.state.sendKeys(state);
        this.county.sendKeys(county);
        this.zip.sendKeys(zip);
        phoneNumber.click();
        Thread.sleep(3000);
        phoneInput.sendKeys(phone,Keys.ENTER);
        Thread.sleep(100);
        buttonSubmit.submit();

    }

    public void validatePatientData(WebDriver driver,String buttonText,String reason, String explain) throws InterruptedException {
        //Assert.assertEquals(BrowserUtils.getText(patientId),expected);
        Thread.sleep(3000);

        deletePatient.click();

        for (int i = 0; i<confirm.size(); i++){
            if (BrowserUtils.getText(confirm.get(i)).contains(buttonText)){
                confirm.get(i).click();
            }
        }

        Assert.assertEquals(BrowserUtils.getText(reasonT),reason);
        inputReason.sendKeys(explain);
        for (int i = 0; i<confirm.size(); i++){
            if (BrowserUtils.getText(confirm.get(i)).contains(buttonText)){
                confirm.get(i).click();
            }
        }


    }
}
