package solvd.carina.demo.gui.ios.components;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import solvd.carina.demo.gui.common.components.ProductListComponentBase;

public class ProductListComponent extends ProductListComponentBase implements IMobileUtils {

    @FindBy(xpath = "//button[contains(@id,'add-to-cart')]")
    private ExtendedWebElement addToCartButton;

    @FindBy(css = ".inventory_item_name")
    private ExtendedWebElement productName;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == \"$\"`]")
    private ExtendedWebElement productPrice;

    public ProductListComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public String getProductName() {
        return productName.getText();
    }

    public Float getProductPrice() {
        return Float.valueOf(productPrice.getText());
    }
}
