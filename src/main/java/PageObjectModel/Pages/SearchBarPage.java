package PageObjectModel.Pages;

import Log.Log;
import Utilities.PageConstants.SearchBarConstants;
import org.openqa.selenium.WebDriver;

public class SearchBarPage extends SearchBarConstants {
    Log log;

    public SearchBarPage(WebDriver driver) {
        super(driver);
    }

    /**
     * @method "typeProductNameInSearchBarText" is to type a word into search bar.
     * @param Text is a string type of product name.
     */

    public void typeProductNameInSearchBarText(String Text){
        log = new Log();
        click(SearchBarTextLocator);
        type(SearchBarTextLocator,Text);
        log.info("Product name is typed in search bar.");
    }

    /**
     * @method "clickSearchButton" is to click search button.
     */
    public void clickSearchButton(){
        log = new Log();
        click(SearchButtonLocator);
        log.info("Product name is searched.");
    }
}
