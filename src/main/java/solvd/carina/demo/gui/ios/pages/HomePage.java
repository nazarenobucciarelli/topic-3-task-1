package solvd.carina.demo.gui.ios.pages;

import com.zebrunner.carina.utils.factory.DeviceType;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import solvd.carina.demo.gui.common.pages.HomePageBase;
import solvd.carina.demo.gui.ios.components.HeaderComponent;
import solvd.carina.demo.gui.ios.components.IOSNativeAlertComponent;
import solvd.carina.demo.gui.ios.components.ProductListComponent;
import solvd.carina.demo.utils.MobileContextUtils;

import java.util.List;

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

    @ExtendedFindBy(iosPredicate = "value == \"Name (A to Z)\"")
    private ExtendedWebElement filterMenuButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/" +
            "XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/" +
            "XCUIElementTypeCollectionView/XCUIElementTypeCell")
    private List<ExtendedWebElement> options;

    MobileContextUtils mobileContextUtils = new MobileContextUtils();

    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(inventoryContainer);
        mobileContextUtils.switchMobileContext(MobileContextUtils.View.NATIVE);
        try {
            if (savePasswordAlert.isUIObjectPresent()) {
                savePasswordAlert.clickNotNowButton();
            }
        } catch (NoSuchElementException e) {
            System.out.println("Save Password alert not found: " + e.getMessage());
        }
        mobileContextUtils.switchMobileContext(MobileContextUtils.View.WEB_BROWSER);
    }

    public ProductListComponent addProductToCart() {
        waitUntil(webDriver -> !productList.isEmpty(), 5);
        ProductListComponent product = productList.get(0);
        product.clickAddToCartButton();
        return product;
    }

    public HeaderComponent getHeader() {
        return header;
    }

    public void clickFilterMenu() {
        mobileContextUtils.switchMobileContext(MobileContextUtils.View.NATIVE);
        filterMenuButton.click();
    }

    public void selectOptionByIndex(Integer index) {
        options.get(index).click();
    }

    public List<ProductListComponent> getProductList() {
        return productList;
    }
}
