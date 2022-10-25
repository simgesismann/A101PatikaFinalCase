package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    public WebDriver driver;
    public String otherFirmTitle;
    public String otherFirmTitleInCartPage;
    public String productNameInDetailPage;
    public String productNameInCartPage;
    public BasePage(WebDriver driver){
        this.driver = driver;
    }
    public WebElement find(By locator){
        WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(60));
        w.until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.findElement(locator);
    }
    public List<WebElement> findAll(By locator){
        return driver.findElements(locator);
    }
    public void click(By locator){
        find(locator).click();
    }
    public void moveToElement(By locator){
        Actions a = new Actions(driver);
        WebElement element = find(locator);
        a.moveToElement(element).perform();
    }
    public void type(By locator,String text){
        find(locator).sendKeys(text);
    }
    public String getText(By locator){
        return find(locator).getText();
    }
    public boolean isDisplayed(By locator){
        return (find(locator).isDisplayed());
    }
    public void scrollToTopOfPage(){
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
    }
    public void rollUntilFindElementAndClick(By locator){
        Boolean elemFound = false;
        JavascriptExecutor js = (JavascriptExecutor) driver;
        while (!elemFound){
            js.executeScript("window.scrollBy(0,350)", "");
            if (isDisplayed(locator)){
                elemFound = true;
                click(locator);
            }
        }
    }
    public void rollUntilFindElement(By locator){
        Boolean elemFound = false;
        JavascriptExecutor js = (JavascriptExecutor) driver;
        while (!elemFound){
            js.executeScript("window.scrollBy(0,350)", "");
            if (isDisplayed(locator)){
                elemFound = true;
            }
        }
    }
    public void wait(int sec) throws InterruptedException{
        Thread.sleep((sec*1000));
    }



}
