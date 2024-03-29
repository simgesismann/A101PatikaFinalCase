package PageObjectModel.Pages;

import Log.Log;
import Utilities.PageConstants.HomePageConstants;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends HomePageConstants {
    SearchBarPage searchBarPage;
    Log log= new Log();
    public HomePage(WebDriver driver) {
        super(driver);
        searchBarPage = new SearchBarPage(driver);
    }
    /**
     * @method "acceptCookies" is to click accept button for cookie.
     */
    public void acceptCookies(){
        Boolean display = true;
        while (display){
            if (isDisplayed(AcceptCookiesLocator)){
                click(AcceptCookiesLocator);
                display = false;
            }else{
                break;
            }
        }
    }
    public void moveAndClickLoginUserButton(){
        moveToElement(LogInGenelButtonLocator);
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(60));
        w.until(ExpectedConditions.elementToBeClickable(LogInButtonLocator));
        click(LogInButtonLocator);
        log.info("Mouse is moved and click to User LogIn Button.");
    }
    /**
     * @method "searchBarPage" is to call search bar section to reach methods in search bar.
     */
    public SearchBarPage searchBarPage(){
        return this.searchBarPage;
    }
    /**
     * @method "clickToMyCartButton" is to scroll to top of page and click MyCart Button.
     */
    public CartPage clickToMyCartButton(){
        scrollToTopOfPage();
        click(MyCartButtonLocator);
        return new CartPage(driver);
    }
    /**
     * @method "assertUserLoggedIn" is to confirm that user is logged in by getting
     * text inside of my account name. If that string is not empty than user is logged in.
     */
    public void assertUserLoggedIn(){
        String myAccount = getText(MyAccountButtonTitleLocator);
        Assertions.assertFalse((myAccount==""));
        log.info("User is logged in.");
    }
}
