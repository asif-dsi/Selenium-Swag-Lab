package testrunner;

import environment.Setup;
import org.testng.annotations.Test;
import pages.Login;

public class Run extends Setup {
    @Test
    public void userLogin() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        Login login = new Login(driver);
        login.doLogin();
    }
}
