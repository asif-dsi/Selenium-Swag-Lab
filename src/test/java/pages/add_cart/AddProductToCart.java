package pages.add_cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AddProductToCart {
    WebDriver driver;
    WebDriverWait wait;

    public AddProductToCart(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "btn_inventory")
    List<WebElement> btnCart;
    @FindBy(className = "shopping_cart_badge")
    WebElement cartBadge;

    public void addProduct(){
        int countAddCartClick,countCartBadge;
        countAddCartClick = countCartBadge = 0;

        for(int i=0;i<=5;i++){
            btnCart.get(i).click();
            countCartBadge = Integer.parseInt(cartBadge.getText());
            countAddCartClick +=1;
        }
        if(countAddCartClick == countCartBadge){
            System.out.println("All items are added to cart.");
        }
    }
}
