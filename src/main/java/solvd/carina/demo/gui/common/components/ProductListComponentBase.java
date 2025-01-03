package solvd.carina.demo.gui.common.components;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class ProductListComponentBase extends AbstractUIObject {

    public ProductListComponentBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract String getProductName();

    public abstract void clickAddToCartButton();

    public abstract Float getProductPrice();

}
