package testrunner;

import environment.Setup;
import org.testng.annotations.Test;
import pages.add_cart.AddProductToCart;
import pages.login.Login;
import pages.filter.ProductFilter;
import pages.side_menu.SideMenu;

public class Run extends Setup {
    Login login;

    @Test(priority = 1)
    public void userLogin() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        login = new Login(driver);
        login.doLogin();
    }

    @Test(priority = 2)
    public void checkSideItems() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        login = new Login(driver);
        login.doLogin();
        SideMenu sideMenu = new SideMenu(driver);
        sideMenu.itemExists();
    }

    @Test(priority = 3)
    public void checkFilter() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        login = new Login(driver);
        login.doLogin();
        ProductFilter productFilter = new ProductFilter(driver);
        productFilter.filterAtoZ();
        productFilter.filterZtoA();
        productFilter.filterLowToHigh();
        productFilter.filterHighToLow();
    }

    @Test(priority = 4)
    public void addToCart() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        login = new Login(driver);
        login.doLogin();
        AddProductToCart addProductToCart = new AddProductToCart(driver);
        addProductToCart.addProduct();
    }
}
