package Pages;

import Utilities.PageConstants.HomePageConstants;
import org.openqa.selenium.WebDriver;

public class HomePage extends HomePageConstants {
    SearchBarPage searchBarPage;
    public HomePage(WebDriver driver) {
        super(driver);
        searchBarPage = new SearchBarPage(driver);
    }
    public SearchBarPage searchBarPage(){
        return this.searchBarPage;
    }

}
