package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Login {
    WebDriver driver;
    WebDriverWait wait;

    public Login(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "user-name")
    WebElement userName;
    @FindBy(id = "password")
    WebElement pass;
    @FindBy(id = "login-button")
    WebElement btnLogin;
    @FindBy(className = "title")
    WebElement pageTitle;


    public void doLogin() throws InterruptedException {
        userName.sendKeys("standard_user");
        pass.sendKeys("secret_sauce");
        btnLogin.click();
        Thread.sleep(3000);
        String title = pageTitle.getText();
        Assert.assertTrue(title.contains("PRODUCTS"));
        System.out.println("Asserted");
    }


}
