package Pages;

import Utilities.PageConstants.SearchBarConstants;
import org.openqa.selenium.WebDriver;

public class SearchBarPage extends SearchBarConstants {

    public SearchBarPage(WebDriver driver) {
        super(driver);
    }
    public void typeProductNameInSearchBarText(){
        click(SearchBarTextLocator);
        type(SearchBarTextLocator,"şemsiye");
    }
    public void clickSearchButton(){
        click(SearchButtonLocator);
    }
}
