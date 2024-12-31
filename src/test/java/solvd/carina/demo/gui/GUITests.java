package solvd.carina.demo.gui;

import com.zebrunner.carina.core.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import solvd.carina.demo.gui.common.components.ProductCartComponentBase;
import solvd.carina.demo.gui.common.pages.HomePageBase;
import solvd.carina.demo.gui.common.pages.ShoppingCartPageBase;
import solvd.carina.demo.gui.common.pages.SignInPageBase;

import java.util.List;
import java.util.stream.Collectors;


public class GUITests extends AbstractTest {

    @Test(enabled = false)
    public void successfulLoginTest() {
        SignInPageBase signInPage = introduceLoginCredentials("standard_user", "secret_sauce");
        HomePageBase homePage = signInPage.clickSignInButton();
        homePage.assertPageOpened();
    }

    @Test(enabled = false)
    public void invalidCredentialsLoginTest() {
        SignInPageBase signInPage = introduceLoginCredentials("invalid_user", "wrong_password");
        HomePageBase homePage = signInPage.clickSignInButton();
        Assert.assertFalse(homePage.isPageOpened());
        Assert.assertTrue(signInPage.isFailedLoginAlertDisplayed());
    }

    @Test(enabled = false)
    public void emptyCredentialsLoginTest() {
        SignInPageBase signInPage = introduceLoginCredentials("", "");
        HomePageBase homePage = signInPage.clickSignInButton();
        Assert.assertFalse(homePage.isPageOpened());
        Assert.assertTrue(signInPage.isRequiredLoginAlertDisplayed());
    }

    @Test(enabled = true)
    public void addProductToCartTest() {
        SignInPageBase signInPage = introduceLoginCredentials("standard_user", "secret_sauce");
        HomePageBase homePage = signInPage.clickSignInButton();
        String productName = homePage.addRandomProductToCart();
        System.out.println(productName);
        ShoppingCartPageBase shoppingCartPage = homePage.getHeader().clickShoppingCart();
        List<String> shoppingCartProductNames= shoppingCartPage.getProductsCart().stream()
                .map(ProductCartComponentBase::getProductName).collect(Collectors.toList());
        System.out.println(shoppingCartProductNames);
        Assert.assertTrue(shoppingCartProductNames.contains(productName));
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
