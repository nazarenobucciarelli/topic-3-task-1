package solvd.carina.demo.gui.common.pages;

import org.openqa.selenium.WebDriver;

public abstract class CheckoutPageBase extends PageBase {

    public CheckoutPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickOnCheckoutButton();

    public abstract void enterFirstName(String firstName);

    public abstract void enterLastName(String lastName);

    public abstract void enterZipCode(String zipCode);

    public abstract void clickFinishButton();

    public abstract void clickContinueButton();

    public abstract boolean isThankYouTextPresent();
}
