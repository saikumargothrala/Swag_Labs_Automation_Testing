package pageObjects;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

import Locators.ProductPageLocators;

public class ProductPage {

    private WebDriver driver;
    private ExtentTest test;

    public ProductPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
    }

    // Convert String locator to By object
    private By by(String locator) {
        if (locator.startsWith(".")) {
            return By.cssSelector(locator);
        } else if (locator.contains(":")) {
            return By.xpath(locator);
        } else {
            return By.className(locator);
        }
    }

    // Method to select a filter option
    public void selectFilterOption(String filterOption) {
        Select filterDropdown = new Select(driver.findElement(by(ProductPageLocators.filterDropdown)));
        filterDropdown.selectByVisibleText(filterOption);
        test.info("Selected filter option: " + filterOption);
    }

    // Method to verify products are sorted by price low to high
    public boolean verifyProductsSortedByPriceLowToHigh() {
        List<WebElement> priceElements = driver.findElements(by(ProductPageLocators.productPrices));
        List<Double> prices = priceElements.stream()
            .map(e -> Double.parseDouble(e.getText().replace("$", "")))
            .collect(Collectors.toList());

        for (int i = 0; i < prices.size() - 1; i++) {
            if (prices.get(i) > prices.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    // Method to verify products are sorted by price high to low
    public boolean verifyProductsSortedByPriceHighToLow() {
        List<WebElement> priceElements = driver.findElements(by(ProductPageLocators.productPrices));
        List<Double> prices = priceElements.stream()
            .map(e -> Double.parseDouble(e.getText().replace("$", "")))
            .collect(Collectors.toList());

        for (int i = 0; i < prices.size() - 1; i++) {
            if (prices.get(i) < prices.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    // Method to verify products are sorted by name A to Z
    public boolean verifyProductsSortedByNameAtoZ() {
        List<WebElement> nameElements = driver.findElements(by(ProductPageLocators.productNames));
        List<String> names = nameElements.stream()
            .map(WebElement::getText)
            .collect(Collectors.toList());

        for (int i = 0; i < names.size() - 1; i++) {
            if (names.get(i).compareTo(names.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

    // Method to verify products are sorted by name Z to A
    public boolean verifyProductsSortedByNameZtoA() {
        List<WebElement> nameElements = driver.findElements(by(ProductPageLocators.productNames));
        List<String> names = nameElements.stream()
            .map(WebElement::getText)
            .collect(Collectors.toList());

        for (int i = 0; i < names.size() - 1; i++) {
            if (names.get(i).compareTo(names.get(i + 1)) < 0) {
                return false;
            }
        }
        return true;
    }

    // Method to add a specific item to the cart by index
    public void addItemToCart(int itemIndex) {
        List<WebElement> addToCartButtons = driver.findElements(by(ProductPageLocators.addToCartButtons));
        if (itemIndex < addToCartButtons.size()) {
            addToCartButtons.get(itemIndex).click();
            test.info("Item added to cart at index: " + itemIndex);
        } else {
            test.fail("Item index out of bounds: " + itemIndex);
        }
    }

    // Method to remove a specific item from the cart by index
    public void removeItemFromCart(int itemIndex) {
        List<WebElement> removeFromCartButtons = driver.findElements(by(ProductPageLocators.removeFromCartButtons));
        if (itemIndex < removeFromCartButtons.size()) {
            removeFromCartButtons.get(itemIndex).click();
            test.info("Item removed from cart at index: " + itemIndex);
        } else {
            test.fail("Item index out of bounds: " + itemIndex);
        }
    }

    // Method to verify the number of items in the cart
    public boolean verifyItemsInCart(int expectedItemCount) {
        WebElement cartBadge = driver.findElement(by(ProductPageLocators.cartBadge));
        int itemCount = Integer.parseInt(cartBadge.getText());
        test.info("Verifying items in cart. Expected: " + expectedItemCount + ", Found: " + itemCount);
        return itemCount == expectedItemCount;
    }
}
