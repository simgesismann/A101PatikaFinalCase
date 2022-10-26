package PageObjectModel.Pages;

import Utilities.PageConstants.HomePageConstants;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class HomePage extends HomePageConstants {
    SearchBarPage searchBarPage;
    public HomePage(WebDriver driver) {
        super(driver);
        searchBarPage = new SearchBarPage(driver);
    }
    /**
     * @method "acceptCookies" is to click accept button for cookie.
     */
    public void acceptCookies(){
        click(AcceptCookiesLocator);
    }
    public void moveAndClickCreateUserButton(){
        moveToElement(LogInGenelButtonLocator);
        click(LogInButtonLocator);
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
    public void clickToMyCartButton(){
        scrollToTopOfPage();
        click(MyCartButtonLocator);
    }
    /**
     * @method "assertUserLoggedIn" is to confirm that user is logged in by getting
     * text inside of my account name. If that string is not empty than user is logged in.
     */
    public void assertUserLoggedIn(){
        String myAccount = getText(MyAccountButtonTitleLocator);
        Assertions.assertFalse((myAccount==""));
    }
}
