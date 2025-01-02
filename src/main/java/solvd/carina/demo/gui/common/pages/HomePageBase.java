package solvd.carina.demo.gui.common.pages;


import org.openqa.selenium.WebDriver;
import solvd.carina.demo.gui.common.components.ProductListComponentBase;

import java.util.List;

public abstract class HomePageBase extends PageBase {
    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ProductListComponentBase addProductToCart();

    public abstract void clickFilterMenu();

    public abstract void selectOptionByIndex(Integer index);

    public abstract List<? extends  ProductListComponentBase> getProductList();
}
