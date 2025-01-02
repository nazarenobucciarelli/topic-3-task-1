package solvd.carina.demo.gui.ios.pages;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import solvd.carina.demo.gui.common.components.HeaderComponentBase;
import solvd.carina.demo.gui.common.pages.CheckoutPageBase;

public class CheckoutPage extends CheckoutPageBase implements IMobileUtils {

    @ExtendedFindBy(iosPredicate = "name == \"Checkout\"")
    private ExtendedWebElement checkoutButton;

    @ExtendedFindBy(iosPredicate = "value == \"First Name\"")
    private ExtendedWebElement firstNameField;

    @ExtendedFindBy(iosPredicate = "value == \"Last Name\"")
    private ExtendedWebElement lastNameField;

    @ExtendedFindBy(iosPredicate = "value == \"Zip/Postal Code\"")
    private ExtendedWebElement zipCodeField;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Continue\"`]")
    private ExtendedWebElement continueButton;

    @ExtendedFindBy(iosPredicate = "name == \"Finish\"")
    private ExtendedWebElement finishButton;

    @ExtendedFindBy(iosPredicate = "name == \"Thank you for your order!\" AND label == " +
            "\"Thank you for your order!\" AND value == \"Thank you for your order!\"")
    private ExtendedWebElement thankYouText;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HeaderComponentBase getHeader() {
        return null;
    }

    public void clickOnCheckoutButton() {
        checkoutButton.click();
    }

    public void enterFirstName(String firstName) {
        firstNameField.type(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameField.type(lastName);
    }

    public void enterZipCode(String zipCode) {
        zipCodeField.type(zipCode);
    }

    public void clickContinueButton() {
        tap(continueButton);
    }

    public void clickFinishButton() {
        finishButton.click();
    }

    public boolean isThankYouTextPresent() {
        return thankYouText.isVisible();
    }
}
