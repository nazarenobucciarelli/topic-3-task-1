package solvd.carina.demo.gui;

import com.zebrunner.carina.core.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import solvd.carina.demo.gui.common.components.ProductCartComponentBase;
import solvd.carina.demo.gui.common.components.ProductListComponentBase;
import solvd.carina.demo.gui.common.pages.CheckoutPageBase;
import solvd.carina.demo.gui.common.pages.HomePageBase;
import solvd.carina.demo.gui.common.pages.ShoppingCartPageBase;
import solvd.carina.demo.gui.common.pages.SignInPageBase;

import java.util.List;
import java.util.stream.Collectors;


public class GUITests extends AbstractTest {

    @Test(enabled = true)
    public void successfulLoginTest() {
        SignInPageBase signInPage = introduceLoginCredentials("standard_user", "secret_sauce");
        HomePageBase homePage = signInPage.clickSignInButton();
        homePage.assertPageOpened();
    }

    @Test(enabled = true)
    public void invalidCredentialsLoginTest() {
        SignInPageBase signInPage = introduceLoginCredentials("invalid_user", "wrong_password");
        HomePageBase homePage = signInPage.clickSignInButton();
        Assert.assertTrue(signInPage.isFailedLoginAlertDisplayed());
    }

    @Test(enabled = true)
    public void emptyCredentialsLoginTest() {
        SignInPageBase signInPage = introduceLoginCredentials("", "");
        signInPage.clickSignInButton();
        Assert.assertTrue(signInPage.isRequiredLoginAlertDisplayed());
    }

    @Test(enabled = true)
    public void verifyProductSortingTest() {
        SignInPageBase signInPage = introduceLoginCredentials("standard_user", "secret_sauce");
        HomePageBase homePage = signInPage.clickSignInButton();
        homePage.clickFilterMenu();
        homePage.selectOptionByIndex(2);
        var products = homePage.getProductList();
        for (int i = 0; i < products.size() - 2; i++) {
            Assert.assertTrue(products.get(i).getProductPrice() > products.get(i + 1).getProductPrice());
        }
    }

    @Test(enabled = true)
    public void addProductToCartTest() {
        SignInPageBase signInPage = introduceLoginCredentials("standard_user", "secret_sauce");
        HomePageBase homePage = signInPage.clickSignInButton();
        ProductListComponentBase product = homePage.addProductToCart();
        String productName = product.getProductName();
        ShoppingCartPageBase shoppingCartPage = homePage.getHeader().clickShoppingCart();
        var shoppingCartProducts= shoppingCartPage.getProductsCart();
        List<String> cartProductNames = shoppingCartProducts.stream()
                .map(ProductCartComponentBase::getProductName).collect(Collectors.toList());
        shoppingCartProducts.forEach(ProductCartComponentBase::clickOnRemoveButton);
        Assert.assertTrue(cartProductNames.contains(productName));
    }

    @Test(enabled = true)
    public void removeProductFromCartTest() {
        SignInPageBase signInPage = introduceLoginCredentials("standard_user", "secret_sauce");
        HomePageBase homePage = signInPage.clickSignInButton();
        ProductListComponentBase product = homePage.addProductToCart();
        String productName = product.getProductName();
        ShoppingCartPageBase shoppingCartPage = homePage.getHeader().clickShoppingCart();
        var shoppingCartProducts= shoppingCartPage.getProductsCart();
        shoppingCartProducts.forEach(ProductCartComponentBase::clickOnRemoveButton);
        List<String> cartProductNames = shoppingCartProducts.stream()
                .map(ProductCartComponentBase::getProductName).collect(Collectors.toList());
        Assert.assertFalse(cartProductNames.contains(productName));
    }

    @Test(enabled = true)
    public void verifyCheckoutProcessTest() {
        SignInPageBase signInPage = introduceLoginCredentials("standard_user", "secret_sauce");
        HomePageBase homePage = signInPage.clickSignInButton();
        homePage.addProductToCart();
        ShoppingCartPageBase shoppingCartPage = homePage.getHeader().clickShoppingCart();
        pause(4);
        CheckoutPageBase checkoutPageBase = shoppingCartPage.clickCheckoutButton();
        checkoutPageBase.enterFirstName("john");
        checkoutPageBase.enterLastName("doe");
        checkoutPageBase.enterZipCode("12345");
        checkoutPageBase.clickContinueButton();
        checkoutPageBase.clickFinishButton();
        Assert.assertTrue(checkoutPageBase.isThankYouTextPresent());
    }

    // Helper methods

    public SignInPageBase introduceLoginCredentials(String username, String password) {
        SignInPageBase signInPage = initPage(SignInPageBase.class);
        signInPage.open();
        signInPage.typeUsername(username);
        signInPage.typePassword(password);
        return signInPage;
    }

}
