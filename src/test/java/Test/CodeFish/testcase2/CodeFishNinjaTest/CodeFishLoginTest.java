package Test.CodeFish.testcase2.CodeFishNinjaTest;

import Test.CodeFish.testCase1.CodeFishTest.CodeFishRegistTest;
import Test.CodeFish.testcase2.CodeFishNinjaPage.CodeFishNinLogin;
import Test.CodeFish.testcase2.CodeFishNinjaPage.CodeFishPatientPage;
import org.testng.annotations.Test;

public class CodeFishLoginTest extends CodeFishNinjaTestBase{


    @Test
    public void loginFunction() throws InterruptedException {
        CodeFishNinLogin codeFishRegistTest = new CodeFishNinLogin(driver);
        codeFishRegistTest.loginFunctionality("admin","Admin123");
        codeFishRegistTest.registrPatientButton("Register a patient");
        CodeFishPatientPage codeFishPatientPage = new CodeFishPatientPage(driver);
        codeFishPatientPage.registerPatient(driver,"walter","baish","M","value");
        codeFishPatientPage.setBirthdayClick(driver,"28","8","value","1997");
        codeFishPatientPage.setAddress("2200 E Devon ave ","Des Plains","IL",
                "cook","60018 ","996 52 18 0592");
        codeFishPatientPage.validatePatientData(driver,"Confirm","Reason cannot be empty","moved");

    }
}
