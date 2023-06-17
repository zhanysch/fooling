package Test.CodeFish.testCase1.CodeFishTest;

import Test.CodeFish.testCase1.CodeFishPage.CodeFishCardPage;
import Test.CodeFish.testCase1.CodeFishPage.CodeFishLoginPage;
import Test.CodeFish.testCase1.CodeFishPage.CodeFishRegistPage;
import org.testng.annotations.Test;

public class CodeFishRegistTest  extends  CodeFishTestBase{


    @Test
    public  void checlLoginFunction() throws InterruptedException {
        CodeFishRegistPage codeFishRegistPage = new CodeFishRegistPage(driver);
        codeFishRegistPage.loginFunctionPage();
        codeFishRegistPage.registFunction("walter9","walter9");
        CodeFishLoginPage codeFishLoginPage= new CodeFishLoginPage(driver);
        codeFishLoginPage.login("walter9","walter9");
        Thread.sleep(4000);
        CodeFishCardPage codeFishCardPage = new CodeFishCardPage(driver);
        codeFishCardPage.titleCart("Pfizer Vaccine","Sputnik Vaccine");
        codeFishCardPage.clickCard();
    }
}

