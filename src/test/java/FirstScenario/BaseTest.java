package FirstScenario;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    WebDriver driver;
    String driverType = "chrome";
    @BeforeTest
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
        driver.manage().window().maximize();
        driver.get("https://www.hepsiburada.com");
    }
    @AfterTest
    public void tearDown(){
        for(String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            driver.close();
        }
    }
}
