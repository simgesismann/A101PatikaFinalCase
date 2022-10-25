package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class Driver {
    public static WebDriver driver;
    public static WebDriver getDriver(){
        if(driver==null){
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--disable-site-isolation-trials");
            chromeOptions.addArguments("--disable-notifications");
            chromeOptions.addArguments("--disable-blink-features");
            chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
            chromeOptions.addArguments("--disable-extensions");
            driver=new ChromeDriver(chromeOptions);
        }
        return driver;
    }
    public static void closeDriver(){
        if(driver!=null){
            driver.close();
            driver=null;
        }
    }
    public static void closeAllTabs(){
        for(String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            driver.close();
        }
    }
    public static void quitDriver(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }
}
