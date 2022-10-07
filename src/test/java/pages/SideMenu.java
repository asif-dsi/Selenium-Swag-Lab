package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SideMenu {
    WebDriver driver;
    WebDriverWait wait;

    public SideMenu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "react-burger-menu-btn")
    WebElement iconSideMenu;
    @FindBy(className = "menu-item")
    List<WebElement> items;

    public void itemExists() {
        iconSideMenu.click();
        for (int i = 0; i < items.size(); i++) {
            items.get(i).isDisplayed();
            System.out.println("Item is present");
        }
    }
}
