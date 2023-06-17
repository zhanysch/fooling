package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

public class DriverHelper {

    private static WebDriver driver;

    private DriverHelper(){};

    //i make my constructor private because i do not want anyone to create an objet
    // and mnaipulate my driver from this class.


    public  static  WebDriver getDriver(){
        if (driver==null||((RemoteWebDriver)driver).getSessionId()==null){
          //  String browser= "chrome";
            switch (ConfigReader.readProperty("browser")){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--remote-allow-origins=*");
                    driver=new ChromeDriver(chromeOptions);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;

                case "edge":
                WebDriverManager.edgedriver().setup();
                driver=new EdgeDriver();
                break;
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }
}
