package solvd.carina.demo.gui.ios.pages;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import solvd.carina.demo.gui.common.pages.SignInPageBase;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = SignInPageBase.class)
public class SignInPage extends SignInPageBase {

    @ExtendedFindBy(iosPredicate = "value == \"Username\"")
    private ExtendedWebElement usernameInput;

    @ExtendedFindBy(iosPredicate = "value == \"Password\"")
    private ExtendedWebElement passwordInput;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Login\"`]")
    private ExtendedWebElement loginButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == \"Epic sadface: Username and password do " +
            "not match any user in this service\"`]")
    private ExtendedWebElement failedLoginAlert;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"Epic sadface: Username is required\"`]")
    private ExtendedWebElement requiredLoginAlert;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void typeUsername(String username) {
        usernameInput.type(username);
    }

    @Override
    public void typePassword(String password) {
        passwordInput.type(password);
    }

    @Override
    public HomePage clickSignInButton() {
        loginButton.click();
        if (!loginButton.isVisible()) {
            return new HomePage(driver);
        }
        return null;
    }

    @Override
    public boolean isFailedLoginAlertDisplayed() {
        return failedLoginAlert.isVisible();
    }

    @Override
    public boolean isRequiredLoginAlertDisplayed() {
        return requiredLoginAlert.isVisible();
    }
}
