package solvd.carina.demo.gui.ios.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import solvd.carina.demo.gui.common.components.HeaderComponentBase;
import solvd.carina.demo.gui.common.pages.ShoppingCartPageBase;
import solvd.carina.demo.gui.ios.components.ProductCartComponent;
import solvd.carina.demo.utils.MobileContextUtils;

import java.util.List;

public class ShoppingCartPage extends ShoppingCartPageBase {

    @FindBy(css = ".cart_item")
    private List<ProductCartComponent> cartItems;

    @ExtendedFindBy(iosPredicate = "name == \"Checkout\"")
    private ExtendedWebElement checkoutButton;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<ProductCartComponent> getProductsCart() {
        return cartItems;
    }

    @Override
    public HeaderComponentBase getHeader() {
        return null;
    }

    public CheckoutPage clickCheckoutButton() {
        MobileContextUtils contextUtils = new MobileContextUtils();
        contextUtils.switchMobileContext(MobileContextUtils.View.NATIVE);
        checkoutButton.click();
        return new CheckoutPage(driver);
    }
}
