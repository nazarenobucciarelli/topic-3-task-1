package solvd.carina.demo.gui.ios.pages;

import com.zebrunner.carina.utils.factory.DeviceType;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import solvd.carina.demo.gui.common.pages.HomePageBase;
import solvd.carina.demo.gui.ios.components.HeaderComponent;
import solvd.carina.demo.gui.ios.components.IOSNativeAlertComponent;
import solvd.carina.demo.gui.ios.components.ProductListComponent;
import solvd.carina.demo.utils.MobileContextUtils;

import java.util.List;
import java.util.Random;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase implements IMobileUtils {

    @ExtendedFindBy(iosPredicate = "name == \"Save Password?\" AND label == \"Save Password?\" AND" +
            " type == \"XCUIElementTypeAlert\"")
    private IOSNativeAlertComponent savePasswordAlert;

    @FindBy(xpath = "(//div[@id=\"inventory_container\"])[2]")
    private ExtendedWebElement inventoryContainer;

    @FindBy(xpath = "(//div[@id=\"inventory_container\"])[2]/div/div")
    private List<ProductListComponent> productList;

    @FindBy(id = "header_container")
    private HeaderComponent header;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(inventoryContainer);
        if (savePasswordAlert.isUIObjectPresent()) {
            savePasswordAlert.clickNotNowButton();
        }
        MobileContextUtils mobileContextUtils = new MobileContextUtils();
        mobileContextUtils.switchMobileContext(MobileContextUtils.View.WEB_BROWSER);
    }

    public IOSNativeAlertComponent getSavePasswordAlert() {
        return savePasswordAlert;
    }

    public String addRandomProductToCart(){
        waitUntil(webDriver -> !productList.isEmpty(), 5);
        System.out.println(productList);
        ProductListComponent product = productList.get(5);
        swipe(product.getRootExtendedElement());
        pause(8);

        product.clickAddToCartButton();
        pause(8);
        return product.getProductName().getText();
    }

    public HeaderComponent getHeader() {
        return header;
    }

}
