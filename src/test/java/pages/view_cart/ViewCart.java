package pages.view_cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ViewCart {
    WebDriver driver;

    public ViewCart(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "shopping_cart_link")
    WebElement btnViewCart;
    @FindBy(className = "inventory_item_name")
    List<WebElement> addedProducts;

    public void viewCart(){

    }
}
