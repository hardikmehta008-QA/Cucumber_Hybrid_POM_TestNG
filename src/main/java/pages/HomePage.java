package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

// Page Object for Home page. Exposes read-only methods that return page state for assertions.
public class HomePage {
    private WebDriver driver;

    // 1. By Locators: OR
    private By userName = By.xpath("//div[@class='shop-menu pull-right']/*[last()]/*[last()]//b");
    private By category_name = By.xpath("//div[@class='left-sidebar']//h2");
    private By category_products = By.xpath("//div[@id='accordian']//h4//a");

    //2. Constructor of the page class:
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //3. Page Actions: features(behavior) of the page the form of methods:
    public String verifyUserName() {
        return driver.findElement(userName).getText();
    }

    public String verifyCategoryName() {
        return driver.findElement(category_name).getText();
    }
    public int getProductsCategoryCount() {
        return driver.findElements(category_products).size()-1;
    }

    public List<String> getProductsCategoryList() {
        List<String> categoryProductNames = new ArrayList<>();
        List<WebElement> categoryProductList = driver.findElements(category_products);
        for(WebElement we : categoryProductList) {
            String productName = we.getText();
            System.out.println("Product Category Name: " + productName);
            categoryProductNames.add(productName);
        }
        return categoryProductNames;

    }


}
