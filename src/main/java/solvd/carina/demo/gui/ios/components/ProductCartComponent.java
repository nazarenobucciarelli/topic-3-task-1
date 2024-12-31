package solvd.carina.demo.gui.ios.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import solvd.carina.demo.gui.common.components.ProductCartComponentBase;

public class ProductCartComponent extends ProductCartComponentBase {

    @FindBy(css = "a div.inventory_item_name")
    private ExtendedWebElement productName;

    public ProductCartComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public String getProductName() {
        return productName.getText();
    }
}
