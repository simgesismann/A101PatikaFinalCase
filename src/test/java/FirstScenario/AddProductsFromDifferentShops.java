package FirstScenario;
import PageObjectModel.Pages.CartPage;
import PageObjectModel.Pages.HomePage;
import PageObjectModel.Pages.ProductDetailPage;
import PageObjectModel.Pages.ProductsPage;
import org.testng.annotations.Test;

public class AddProductsFromDifferentShops extends BaseTest {
    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;
    /**
     * Directed to Home Page
     * @param "Text" is used to type in search bar.
     */
    @Test(priority = 1)
    public void typeProductName() {
        homePage = new HomePage(driver);
        homePage.acceptCookies();
        homePage.searchBarPage().typeProductNameInSearchBarText("şemsiye");
    }
    /**
     * Search button in searchbar is clicked.
     */
    @Test(priority = 2)
    public void searchProduct() {
        homePage = new HomePage(driver);
        homePage.searchBarPage().clickSearchButton();
    }
    /**
     * After search , in product page there are products.
     * First one of that product list is chosen.
     */
    @Test(priority = 3)
    public void chooseProduct() throws InterruptedException {
        productsPage = new ProductsPage(driver);
        productsPage.assertProductPageIsDirected();
        productsPage.chooseOneProduct();
    }
    /**
     * When product is chosen new tab is opened and navigated to it.
     * Assert that detail page is directed or not.
     * @method "rollAndClickAddToCartButton()" is to scroll down until find ADD TO CART BUTTON.
     * Assert that cart button is clicked.
     * When ADD TO CART button is clicked, there is pop-up.
     * @method "clickCloseButton()" is to close Pop-up.
     */
    @Test(priority = 4)
    public void addProductToCart() throws InterruptedException {
        productDetailPage = new ProductDetailPage(driver);
        productDetailPage.windowHandle();
        productDetailPage.assertProductDetailPageIsDirected();
        productDetailPage.rollAndClickAddToCartButton();
        productDetailPage.assertAddCartButtonIsClicked();
        productDetailPage.clickCloseButton();
    }
    /**
     * @method "assertOtherBuyOptionsTitleIsDisplayed()" is to confirm that product has other option firms.
     * Click first ADD TO CART Button in other options
     * @method "clickCloseButton()" is to close Pop-up.
     */
    @Test(priority = 5)
    public void addSameProductFromAnotherStoreToCart() throws InterruptedException {
        productDetailPage = new ProductDetailPage(driver);
        productDetailPage.assertOtherBuyOptionsTitleIsDisplayed();
        productDetailPage.getTextTitleOfOtherOptionsList();
        productDetailPage.clickOtherOptionAddToCartButton();
        productDetailPage.clickCloseButton();
        System.out.println("add another");
    }
    /**
     * @method "clickToMyCard" is to navigate cart page.
     */
    @Test(priority = 6)
    public void navigateToCartPage() {
        homePage = new HomePage(driver);
        homePage.clickToMyCart();
    }
    /**
     * Confirm that page is directed
     *
     */
    @Test(priority = 7)
    public void confirmChosenProductsAreOnCartPage() {
        cartPage = new CartPage(driver);
        cartPage.assertCartPageIsDirected();
        cartPage.getTextOfOtherFirmTitleInCartPage();
        //cartPage.assertAddedProductFirmIsCorrectInCart();
    }
}
