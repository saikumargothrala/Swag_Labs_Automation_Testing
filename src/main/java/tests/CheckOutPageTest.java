package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.CheckOutPage;
import pageObjects.CheckOutInformationPage; // Added import for CheckOutInformationPage
import pageObjects.CartPage;
import pageObjects.LoginPage;
import pageObjects.ProductPage;

public class CheckOutPageTest extends BaseTest {

    @Test
    @Parameters({"username", "password", "firstName", "lastName", "postalCode"})
    public void verifyClickFinishButton(String username, String password, String firstName, String lastName, String postalCode) {
        test.info("Starting test: Verify Click Finish Button");
        
        // Initialize page objects
        LoginPage loginPage = new LoginPage(driver, suiteTest);
        ProductPage productPage = new ProductPage(driver, suiteTest);
        CartPage cartPage = new CartPage(driver, suiteTest, test);
        CheckOutInformationPage checkOutInformationPage = new CheckOutInformationPage(driver, test); // Added initialization
        CheckOutPage checkOutPage = new CheckOutPage(driver, suiteTest);
        
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
        driver.get("https://www.saucedemo.com/cart.html");

        // Proceed to checkout
        cartPage.proceedToCheckout();
        test.info("Proceeded to checkout.");
        
        // Fill out checkout information
        checkOutInformationPage.enterFirstName(firstName);
        test.info("First name entered: " + firstName);
        checkOutInformationPage.enterLastName(lastName);
        test.info("Last name entered: " + lastName);
        checkOutInformationPage.enterPostalCode(postalCode);
        test.info("Postal code entered: " + postalCode);

        checkOutInformationPage.clickContinueButton();
        test.info("Continue button clicked.");

        // Click Finish button
        checkOutInformationPage.clickFinishButton();
        test.info("Finish button clicked.");

        // Verify checkout completion
        String expectedUrl = "https://www.saucedemo.com/checkout-complete.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Failed to navigate to the checkout completion page.");
        test.pass("Finish button clicked and navigation verified.");
    }

    @Test
    @Parameters({"username", "password", "firstName", "lastName", "postalCode"})
    public void verifyClickCancelButton(String username, String password, String firstName, String lastName, String postalCode) {
        test.info("Starting test: Verify Click Cancel Button");
        
        // Initialize page objects
        LoginPage loginPage = new LoginPage(driver, suiteTest);
        ProductPage productPage = new ProductPage(driver, suiteTest);
        CartPage cartPage = new CartPage(driver, suiteTest, test);
        CheckOutInformationPage checkOutInformationPage = new CheckOutInformationPage(driver, test); // Added initialization
        CheckOutPage checkOutPage = new CheckOutPage(driver, suiteTest);
        
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
        driver.get("https://www.saucedemo.com/cart.html");

        // Proceed to checkout
        cartPage.proceedToCheckout();
        checkOutInformationPage.enterFirstName(firstName);
        test.info("First name entered: " + firstName);
        checkOutInformationPage.enterLastName(lastName);
        test.info("Last name entered: " + lastName);
        checkOutInformationPage.enterPostalCode(postalCode);
        test.info("Postal code entered: " + postalCode);

        checkOutInformationPage.clickContinueButton();
        test.info("Continue button clicked.");

        // Click Cancel button
        checkOutPage.clickCancelButton();

        // Verify navigation back to Cart Page
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Failed to navigate back to the cart page.");
        test.pass("Cancel button clicked and navigation verified.");
    }
}
