package solvd.carina.demo.gui.ios.components;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import solvd.carina.demo.gui.common.components.ProductListComponentBase;

public class ProductListComponent extends ProductListComponentBase implements IMobileUtils {

    @FindBy(xpath = "//button[contains(@id,'add-to-cart')]")
    private ExtendedWebElement addToCartButton;

    @FindBy(css = ".inventory_item_name")
    private ExtendedWebElement productName;

    public ProductListComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickAddToCartButton() {
        swipe(addToCartButton);
        pause(8);
        addToCartButton.click();
    }

    public ExtendedWebElement getProductName() {
        return productName;
    }
}
