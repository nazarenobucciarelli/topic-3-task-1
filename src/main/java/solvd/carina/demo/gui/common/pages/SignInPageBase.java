package solvd.carina.demo.gui.common.pages;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SignInPageBase extends AbstractPage {

    public SignInPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void typeUsername(String username);

    public abstract void typePassword(String password);

    public abstract HomePageBase clickSignInButton();

    public abstract boolean isFailedLoginAlertDisplayed();

    public abstract boolean isRequiredLoginAlertDisplayed();

}
