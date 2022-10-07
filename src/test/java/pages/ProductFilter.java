package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ProductFilter {
    WebDriver driver;
    WebDriverWait wait;
    String[] productName = {"Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)"};
    String[] productPrice = {"29.99", "9.99", "15.99", "49.99", "7.99", "15.99"};

    public ProductFilter(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "product_sort_container")
    WebElement iconFilter;
    @FindBy(className = "active_option")
    WebElement defaultOption;
    @FindBy(className = "inventory_item_name")
    List<WebElement> names;
    @FindBy(className = "inventory_item_price")
    List<WebElement> price;


    public void filterAtoZ() {
        String[] assertProduct = new String[6];
        System.out.println(names.get(1));
        for (int i = 0; i < names.size(); i++) {
            assertProduct[i] = names.get(i).getText();
            System.out.println(assertProduct[i]);
        }
        if (Arrays.equals(productName, assertProduct)) System.out.println("Filter is OK");
    }

    public void filterZtoA() {
        Select filter = new Select(iconFilter);
        filter.selectByValue("za");
        Arrays.sort(productName);
        Collections.reverse(Arrays.asList(productName));

        String[] assertProduct = new String[6];
        for (int i = 0; i < names.size(); i++) {
            assertProduct[i] = names.get(i).getText();
            System.out.println(assertProduct[i]);
        }
        if (Arrays.equals(productName, assertProduct)) System.out.println("Filter is OK");
    }

    public void filterLowToHigh() {
        Select filter = new Select(iconFilter);
        filter.selectByValue("lohi");
        Arrays.sort(productPrice);

        String[] assertPrice = new String[6];
        for (int i = 0; i < price.size(); i++) {
            assertPrice[i] = price.get(i).getText();
            System.out.println(assertPrice[i]);
        }
        if (Arrays.equals(productPrice, assertPrice)) System.out.println("Filter is OK");
    }

    public void filterHighToLow() {
        Select filter = new Select(iconFilter);
        filter.selectByValue("hilo");
        Arrays.sort(productPrice);
        Collections.reverse(Arrays.asList(productPrice));

        String[] assertPrice = new String[6];
        for (int i = 0; i < price.size(); i++) {
            assertPrice[i] = price.get(i).getText();
            System.out.println(assertPrice[i]);
        }
        if (Arrays.equals(productPrice, assertPrice)) System.out.println("Filter is OK");
    }
}
