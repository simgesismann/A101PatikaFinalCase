import PageObjectModel.Pages.HomePage;
import PageObjectModel.Pages.ProductsPage;
import org.testng.annotations.Test;

public class AddProductsFromDifferentShops extends BaseTest{
    HomePage homePage;
    ProductsPage productsPage;
    @Test(priority = 1)
    public void typeProductName() {
        homePage = new HomePage(driver);
        homePage.acceptCookies();
        homePage.searchBarPage().typeProductNameInSearchBarText();
        System.out.println("typed");
    }
    @Test(priority = 2)
    public void searchProduct() {
        homePage = new HomePage(driver);
        homePage.searchBarPage().clickSearchButton();
        System.out.println("searched");
    }
    @Test(priority = 3)
    public void chooseProduct() throws InterruptedException {
        productsPage = new ProductsPage(driver);
        productsPage.assertProductPageIsDirected();
        productsPage.chooseOneProduct();
        System.out.println("choosed");
    }
}
