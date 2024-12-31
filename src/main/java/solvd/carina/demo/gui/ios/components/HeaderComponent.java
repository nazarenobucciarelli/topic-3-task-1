package solvd.carina.demo.gui.ios.components;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import solvd.carina.demo.gui.common.components.HeaderComponentBase;
import solvd.carina.demo.gui.ios.pages.ShoppingCartPage;

public class HeaderComponent extends HeaderComponentBase implements IMobileUtils {

    @FindBy(xpath = "//select")
    private ExtendedWebElement filterMenu;

    @FindBy(xpath = "//div[@id=\"shopping_cart_container\"]/a")
    private ExtendedWebElement shoppingCartButton;

    public HeaderComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public void clickFilterMenu() {
        swipe(filterMenu);
        filterMenu.click();
    }

    @Override
    public ShoppingCartPage clickShoppingCart() {
        swipe(shoppingCartButton);
        shoppingCartButton.click();
        return new ShoppingCartPage(driver);
    }
}
