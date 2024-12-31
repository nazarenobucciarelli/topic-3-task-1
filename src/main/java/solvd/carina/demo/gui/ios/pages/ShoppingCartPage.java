package solvd.carina.demo.gui.ios.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import solvd.carina.demo.gui.common.components.HeaderComponentBase;
import solvd.carina.demo.gui.common.components.ProductCartComponentBase;
import solvd.carina.demo.gui.common.pages.ShoppingCartPageBase;
import solvd.carina.demo.gui.ios.components.ProductCartComponent;

import java.util.List;

public class ShoppingCartPage extends ShoppingCartPageBase {

    @FindBy(css = ".cart_item")
    private List<ProductCartComponent> cartItems;

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
}
