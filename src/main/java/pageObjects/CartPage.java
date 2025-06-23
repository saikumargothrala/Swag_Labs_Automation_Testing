package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;

import java.util.List;

public class CartPage {
    private WebDriver driver;
    private ExtentTest suiteTest;
    private ExtentTest test;

    // Constructor with ExtentTest parameters
    public CartPage(WebDriver driver, ExtentTest suiteTest, ExtentTest test) {
        this.driver = driver;
        this.suiteTest = suiteTest;
        this.test = test;
        PageFactory.initElements(driver, this);
    }

    // Method to verify an item is in the cart
    public boolean verifyItemInCart(String itemName) {
        suiteTest.info("Verifying if item is in the cart: " + itemName);
        List<WebElement> items = driver.findElements(By.className("cart_item"));
        for (WebElement item : items) {
            if (item.getText().contains(itemName)) {
                test.info("Item found in the cart: " + itemName);
                return true;
            }
        }
        test.warning("Item not found in the cart: " + itemName);
        return false;
    }

    // Method to remove an item from the cart
    public void removeItemFromCart(String itemName) {
        suiteTest.info("Removing item from the cart: " + itemName);
        List<WebElement> items = driver.findElements(By.className("cart_item"));
        for (WebElement item : items) {
            if (item.getText().contains(itemName)) {
                WebElement removeButton = item.findElement(By.className("remove"));
                removeButton.click();
                test.info("Item removed from the cart: " + itemName);
                return;
            }
        }
        test.warning("Failed to remove item from the cart (item not found): " + itemName);
    }

    // Method to proceed to checkout
    public void proceedToCheckout() {
        suiteTest.info("Proceeding to checkout.");
        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();
        test.info("Checkout button clicked.");
    }

    // Method to get the number of items in the cart
    public int getCartItemCount() {
        suiteTest.info("Getting cart item count.");
        WebElement itemCountBadge = driver.findElement(By.className("shopping_cart_badge"));
        String countText = itemCountBadge.getText();
        int count = Integer.parseInt(countText);
        test.info("Cart item count: " + count);
        return count;
    }
}
