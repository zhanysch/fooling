package Test;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCase1 {
    @Test
    public void HeadersOfTheCar() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        String actualTitle = driver.getTitle();
        String exceptedTitle = "Web Orders Login";
        Assert.assertEquals(actualTitle,exceptedTitle);

        WebElement login = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        login.sendKeys("Tester");
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");

        WebElement btn = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        btn.click();

        String actualTitleOfSecondPage = driver.getTitle();
        String exceptedTitleOfSecondPage = "Web Orders";
        Assert.assertEquals(actualTitleOfSecondPage,exceptedTitleOfSecondPage);

        WebElement header = driver.findElement(By.tagName("h2"));
        String w = header.getText().trim();
        String b= "List of All Orders";
        Assert.assertEquals(w,b);

        WebElement btnViewAllProducts = driver.findElement(By.xpath("//a[.='View all products']"));
        btnViewAllProducts.click();

        WebElement headerListOfProduct = driver.findElement(By.tagName("h2"));
        String wLP = BrowserUtils.getText(headerListOfProduct);
        String bLP= "List of Products";
        Assert.assertEquals(wLP,bLP);
       Assert.assertFalse(!driver.getCurrentUrl().contains("Products"));
        System.out.println();

        WebElement viewAllOrders = driver.findElement(By.xpath("//a[@href='Default.aspx']"));
        String actualViewOrder = viewAllOrders.getAttribute("href");
        System.out.println(actualViewOrder);
        Assert.assertTrue(actualViewOrder.contains("Default.aspx"));

        WebElement Orders = driver.findElement(By.xpath("//a[@href='Process.aspx']"));
        String actualOrder = Orders.getAttribute("href");
        System.out.println(actualViewOrder);
        Assert.assertTrue(actualOrder.contains("Process.aspx"));

        WebElement orderButton = driver.findElement(By.xpath("//a[.='Order']"));
        orderButton.click();
        WebElement scren = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_ddlProduct"));
        Select choseType = new Select(scren);
        choseType.selectByValue("ScreenSaver");
        WebElement inputQuantity = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtQuantity"));
        inputQuantity.sendKeys("5");

        Thread.sleep(3000);
        WebElement customerName = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtName"));
        customerName.sendKeys("CodeFish IT School");

        WebElement street = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox2"));
        street.sendKeys("2200 E devon");

        WebElement city = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox3"));
        city.sendKeys("Des Plaines");

        WebElement state = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox4"));
        state.sendKeys("Illinos");
        WebElement zip = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox5"));
        zip.sendKeys("60018");

        WebElement masterCard = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_cardList_1"));
        masterCard.click();
        WebElement card = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox6"));
        card.sendKeys("444993876233");

        WebElement cardMonth = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox1"));
        cardMonth.sendKeys("03/24");

        WebElement proccesButton = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_InsertButton"));
        proccesButton.click();

        WebElement validSucces = driver.findElement(By.xpath("//div[@class='buttons_process']//strong"));
        String wD = BrowserUtils.getText(validSucces);
        String expect = "New order has been successfully added.";
        Assert.assertEquals(wD,expect);
    }
     @Test
    public void TestCase2() throws InterruptedException {

         WebDriverManager.chromedriver().setup();
         ChromeOptions options = new ChromeOptions();
         options.addArguments("--remote-allow-origins=*");
         WebDriver driver = new ChromeDriver(options);
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

         String actualTitle = driver.getTitle();
         String exceptedTitle = "Web Orders Login";
         Assert.assertEquals(actualTitle,exceptedTitle);

         WebElement login = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
         login.sendKeys("Tester");
         WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
         password.sendKeys("test");

         WebElement btn = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
         btn.click();
         WebElement btnViewAllProducts = driver.findElement(By.xpath("//a[.='View all products']"));
         btnViewAllProducts.click();

         WebElement headerListOfProduct = driver.findElement(By.tagName("h2"));
         String wLP = BrowserUtils.getText(headerListOfProduct);
         String bLP= "List of Products";
         Assert.assertEquals(wLP,bLP);
         Assert.assertFalse(!driver.getCurrentUrl().contains("Products"));
         System.out.println();
    }

    @Test
    public void TestCase3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        String actualTitle = driver.getTitle();
        String exceptedTitle = "Web Orders Login";
        Assert.assertEquals(actualTitle,exceptedTitle);

        WebElement login = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        login.sendKeys("Tester");
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");

        WebElement btn = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        btn.click();

        WebElement btnViewAllProducts = driver.findElement(By.xpath("//a[.='View all products']"));
        btnViewAllProducts.click();

        WebElement headerListOfProduct = driver.findElement(By.tagName("h2"));
        String wLP = BrowserUtils.getText(headerListOfProduct);
        String bLP= "List of Products";
        Assert.assertEquals(wLP,bLP);
        Assert.assertFalse(!driver.getCurrentUrl().contains("Products"));
        System.out.println();

        WebElement viewAllOrders = driver.findElement(By.xpath("//a[@href='Default.aspx']"));
        String actualViewOrder = viewAllOrders.getAttribute("href");
        System.out.println(actualViewOrder);
        Assert.assertTrue(actualViewOrder.contains("Default.aspx"));

        WebElement Orders = driver.findElement(By.xpath("//a[@href='Process.aspx']"));
        String actualOrder = Orders.getAttribute("href");
        System.out.println(actualViewOrder);
        Assert.assertTrue(actualOrder.contains("Process.aspx"));
    }

    @Test
    public void TestCase4() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        String actualTitle = driver.getTitle();
        String exceptedTitle = "Web Orders Login";
        Assert.assertEquals(actualTitle,exceptedTitle);

        WebElement login = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        login.sendKeys("Tester");
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");

        WebElement btn = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        btn.click();
        WebElement orderButton = driver.findElement(By.xpath("//a[.='Order']"));
        orderButton.click();
        WebElement scren = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_ddlProduct"));
        Select choseType = new Select(scren);
        choseType.selectByValue("ScreenSaver");
        WebElement inputQuantity = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtQuantity"));
        inputQuantity.sendKeys("5");

        Thread.sleep(3000);
        WebElement customerName = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtName"));
        customerName.sendKeys("CodeFish IT School");

        WebElement street = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox2"));
        street.sendKeys("2200 E devon");

        WebElement city = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox3"));
        city.sendKeys("Des Plaines");

        WebElement state = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox4"));
        state.sendKeys("Illinos");
        WebElement zip = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox5"));
        zip.sendKeys("60018");

        WebElement masterCard = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_cardList_1"));
        masterCard.click();
        WebElement card = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox6"));
        card.sendKeys("444993876233");

        WebElement cardMonth = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox1"));
        cardMonth.sendKeys("03/24");

        WebElement proccesButton = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_InsertButton"));
        proccesButton.click();
        WebElement validSucces = driver.findElement(By.xpath("//div[@class='buttons_process']//strong"));
        String wD = BrowserUtils.getText(validSucces);
        String expect = "New order has been successfully added.";
        Assert.assertEquals(wD,expect);
    }
}
