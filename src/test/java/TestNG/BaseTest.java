package TestNG;

import Log.Log;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    WebDriver driver;
    String driverType = "chrome";
    Log log ;
    @BeforeClass
    public void setUp(){
        switch (driverType){
            case("chrome"):
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-site-isolation-trials");
                chromeOptions.addArguments("--disable-notifications");
                chromeOptions.addArguments("--disable-blink-features");
                chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
                chromeOptions.addArguments("--disable-extensions");
                //chromeOptions.setHeadless(true);
                driver=new ChromeDriver(chromeOptions);
                break;
            case("firefox"):
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case("edge"):
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
        }
        log = new Log();
        log.info("---TestNG Test Method initialized---");
        driver.manage().window().maximize();
        driver.get("https://www.hepsiburada.com");
        log.info("Home page is directed.");
    }
    @AfterClass
    public void tearDown(){
        log = new Log();
        log.info("---TestNG Test tearing down all tabs---");
        for(String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            driver.close();
        }
    }
}
