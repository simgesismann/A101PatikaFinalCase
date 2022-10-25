package PageObjectModel.Pages;

import Utilities.PageConstants.SearchBarConstants;
import org.openqa.selenium.WebDriver;

public class SearchBarPage extends SearchBarConstants {

    public SearchBarPage(WebDriver driver) {
        super(driver);
    }
    public void typeProductNameInSearchBarText(String Text){
        click(SearchBarTextLocator);
        type(SearchBarTextLocator,Text);
    }
    public void clickSearchButton(){
        click(SearchButtonLocator);
    }
}
