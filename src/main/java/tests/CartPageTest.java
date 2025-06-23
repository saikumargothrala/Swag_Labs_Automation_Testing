package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.LoginPage;
import pageObjects.ProductPage; // Ensure ProductPage is imported
import base.BaseTest;

public class CartPageTest extends BaseTest {

  

    @Test
    @Parameters({"username", "password"})
    public void verifyProceedToCheckout(String username, String password) {
        suiteTest.info("Starting test: Verify Proceed To Checkout");

        // Initialize LoginPage and CartPage objects
        LoginPage loginPage = new LoginPage(driver, suiteTest);
        CartPage cartPage = new CartPage(driver, suiteTest, test);
        ProductPage productPage = new ProductPage(driver, suiteTest); // Initialize ProductPage for adding items

        // Perform login
        loginPage.enterUsername(username);
        test.info("Username entered: " + username);

        loginPage.enterPassword(password);
        test.info("Password entered.");

        loginPage.clickLoginButton();
        test.info("Login button clicked.");

        // Add an item to the cart
        productPage.addItemToCart(0); // Assuming item index 0
        test.info("Item added to cart.");
        Assert.assertTrue(productPage.verifyItemsInCart(1), "Failed to add the item to the cart.");

        // Navigate to Cart Page
        driver.get("https://www.saucedemo.com/cart.html"); // URL for Cart Page

        // Proceed to checkout
        cartPage.proceedToCheckout();
        test.info("Proceeded to checkout.");

        // Verify checkout page is displayed (assuming checkout page URL or title)
        String expectedUrl = "https://www.saucedemo.com/checkout-step-one.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Failed to proceed to the checkout page.");

        suiteTest.pass("Proceed to Checkout functionality verified successfully.");
    }

    @Test
    @Parameters({"username", "password"})
    public void verifyCartItemCount(String username, String password) {
        suiteTest.info("Starting test: Verify Cart Item Count");

        // Initialize LoginPage and CartPage objects
        LoginPage loginPage = new LoginPage(driver, suiteTest);
        CartPage cartPage = new CartPage(driver, suiteTest, test);
        ProductPage productPage = new ProductPage(driver, suiteTest); // Initialize ProductPage for adding items

        // Perform login
        loginPage.enterUsername(username);
        test.info("Username entered: " + username);

        loginPage.enterPassword(password);
        test.info("Password entered.");

        loginPage.clickLoginButton();
        test.info("Login button clicked.");

        // Add an item to the cart
        productPage.addItemToCart(0); // Assuming item index 0
        test.info("Item added to cart.");
        Assert.assertTrue(productPage.verifyItemsInCart(1), "Failed to add the item to the cart.");

        // Navigate to Cart Page
        driver.get("https://www.saucedemo.com/cart.html"); // URL for Cart Page

        // Verify cart item count
        int expectedItemCount = 1; // Set expected count based on your scenario
        Assert.assertEquals(cartPage.getCartItemCount(), expectedItemCount, "Cart item count is not as expected.");

        suiteTest.pass("Cart Item Count functionality verified successfully.");
    }
}
