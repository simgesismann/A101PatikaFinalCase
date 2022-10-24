package Utilities.PageConstants;

import PageObjectModel.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchBarConstants extends BasePage {
    public SearchBarConstants(WebDriver driver) {
        super(driver);
    }
    public final By SearchBarTextLocator = By.className("desktopOldAutosuggestTheme-UyU36RyhCTcuRs_sXL9b");
    public final By SearchButtonLocator = By.className("SearchBoxOld-cHxjyU99nxdIaAbGyX7F");
}
