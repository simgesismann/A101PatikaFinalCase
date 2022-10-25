package PageObjectModel.Pages;

import Utilities.PageConstants.HomePageConstants;
import org.openqa.selenium.WebDriver;

public class HomePage extends HomePageConstants {
    SearchBarPage searchBarPage;
    public HomePage(WebDriver driver) {
        super(driver);
        searchBarPage = new SearchBarPage(driver);
    }
    public void acceptCookies(){
        click(AcceptCookiesLocator);
    }
    public void moveAndClickCreateUserButton(){
        moveToElement(LogInGenelButtonLocator);
        click(CreateUserButtonLocator);
    }
    public SearchBarPage searchBarPage(){
        return this.searchBarPage;
    }
    public void clickToMyCartButton(){
        scrollToTopOfPage();
        click(MyCartButtonLocator);
    }

}
