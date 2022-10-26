package PageObjectModel.Pages;

import Utilities.PageConstants.SearchBarConstants;
import org.openqa.selenium.WebDriver;

public class SearchBarPage extends SearchBarConstants {

    public SearchBarPage(WebDriver driver) {
        super(driver);
    }

    /**
     * @method "typeProductNameInSearchBarText" is to type a word into search bar.
     * @param Text is a string type of product name.
     */

    public void typeProductNameInSearchBarText(String Text){
        click(SearchBarTextLocator);
        type(SearchBarTextLocator,Text);
    }

    /**
     * @method "clickSearchButton" is to click search button.
     */
    public void clickSearchButton(){
        click(SearchButtonLocator);
    }
}
