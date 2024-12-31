package solvd.carina.demo.gui.ios.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class IOSNativeAlertComponent extends AbstractUIObject {

    @ExtendedFindBy(iosPredicate = "name == \"Not Now\"")
    private ExtendedWebElement notNowButton;

    public IOSNativeAlertComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickNotNowButton() {
        notNowButton.click();
    }
}
