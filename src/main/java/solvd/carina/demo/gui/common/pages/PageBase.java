package solvd.carina.demo.gui.common.pages;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import solvd.carina.demo.gui.common.components.HeaderComponentBase;

public abstract class PageBase extends AbstractPage {
    public PageBase(WebDriver driver) {
        super(driver);
    }

    public abstract HeaderComponentBase getHeader();

}
