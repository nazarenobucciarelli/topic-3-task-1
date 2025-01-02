package solvd.carina.demo.gui.common.pages;

import org.openqa.selenium.WebDriver;
import solvd.carina.demo.gui.common.components.ProductCartComponentBase;

import java.util.List;

public abstract class ShoppingCartPageBase extends PageBase {
    public ShoppingCartPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract List<? extends ProductCartComponentBase> getProductsCart();

    public abstract CheckoutPageBase clickCheckoutButton();
}
