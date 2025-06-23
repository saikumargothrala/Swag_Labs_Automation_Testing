package tests;

import base.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.CheckOutInformationPage;
import pageObjects.LoginPage;
import pageObjects.ProductPage;

public class CheckOutInformationPageTest extends BaseTest {

    @Test
    @Parameters({"username", "password", "firstName"})
    public void verifyEnterFirstName(String username, String password, String firstName) {
        test.info("Starting test: Verify Enter First Name");

        // Initialize page objects
        LoginPage loginPage = new LoginPage(driver, suiteTest);
        CartPage cartPage = new CartPage(driver, suiteTest, test);
        ProductPage productPage = new ProductPage(driver, suiteTest);
        CheckOutInformationPage checkOutInformationPage = new CheckOutInformationPage(driver, suiteTest);

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

        // Verify checkout page is displayed
        String expectedUrl = "https://www.saucedemo.com/checkout-step-one.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Failed to proceed to the checkout page.");

        checkOutInformationPage.enterFirstName(firstName);
        test.info("First name entered: " + firstName);

        // Add assertions to verify first name entry
        test.pass("Entered first name successfully.");
    }

    @Test
    @Parameters({"username", "password", "lastName"})
    public void verifyEnterLastName(String username, String password, String lastName) {
        test.info("Starting test: Verify Enter Last Name");

        // Initialize page objects
        LoginPage loginPage = new LoginPage(driver, suiteTest);
        CartPage cartPage = new CartPage(driver, suiteTest, test);
        ProductPage productPage = new ProductPage(driver, suiteTest);
        CheckOutInformationPage checkOutInformationPage = new CheckOutInformationPage(driver, suiteTest);

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

        // Verify checkout page is displayed
        String expectedUrl = "https://www.saucedemo.com/checkout-step-one.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Failed to proceed to the checkout page.");

        checkOutInformationPage.enterLastName(lastName);
        test.info("Last name entered: " + lastName);

        // Add assertions here to verify last name entry
        test.pass("Entered last name successfully.");
    }

    @Test
    @Parameters({"username", "password", "postalCode"})
    public void verifyEnterPostalCode(String username, String password, String postalCode) {
        test.info("Starting test: Verify Enter Postal Code");

        // Initialize page objects
        LoginPage loginPage = new LoginPage(driver, suiteTest);
        CartPage cartPage = new CartPage(driver, suiteTest, test);
        ProductPage productPage = new ProductPage(driver, suiteTest);
        CheckOutInformationPage checkOutInformationPage = new CheckOutInformationPage(driver, suiteTest);

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

        // Verify checkout page is displayed
        String expectedUrl = "https://www.saucedemo.com/checkout-step-one.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Failed to proceed to the checkout page.");

        checkOutInformationPage.enterPostalCode(postalCode);
        test.info("Postal code entered: " + postalCode);

        // Add assertions here to verify postal code entry
        test.pass("Entered postal code successfully.");
    }

    @Test
    @Parameters({"username", "password", "firstName", "lastName", "postalCode"})
    public void verifyClickContinueButton(String username, String password, String firstName, String lastName, String postalCode) {
        test.info("Starting test: Verify Click Continue Button");

        // Initialize page objects
        LoginPage loginPage = new LoginPage(driver, suiteTest);
        CartPage cartPage = new CartPage(driver, suiteTest, test);
        ProductPage productPage = new ProductPage(driver, suiteTest);
        CheckOutInformationPage checkOutInformationPage = new CheckOutInformationPage(driver, suiteTest);

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

        // Verify checkout page is displayed
        String expectedUrl = "https://www.saucedemo.com/checkout-step-one.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Failed to proceed to the checkout page.");

        checkOutInformationPage.enterFirstName(firstName);
        test.info("First name entered: " + firstName);
        checkOutInformationPage.enterLastName(lastName);
        test.info("Last name entered: " + lastName);
        checkOutInformationPage.enterPostalCode(postalCode);
        test.info("Postal code entered: " + postalCode);

        checkOutInformationPage.clickContinueButton();
        test.info("Continue button clicked.");

        expectedUrl = "https://www.saucedemo.com/checkout-step-two.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Failed to navigate to the next step.");
        test.pass("Continue button clicked and navigation verified.");
    }

    @Test
    @Parameters({"username", "password", "firstName", "lastName", "postalCode"})
    public void verifyClickFinishButton(String username, String password, String firstName, String lastName, String postalCode) {
        test.info("Starting test: Verify Click Finish Button");

        // Initialize page objects
        LoginPage loginPage = new LoginPage(driver, suiteTest);
        CartPage cartPage = new CartPage(driver, suiteTest, test);
        ProductPage productPage = new ProductPage(driver, suiteTest);
        CheckOutInformationPage checkOutInformationPage = new CheckOutInformationPage(driver, suiteTest);

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

        // Verify checkout page is displayed
        String expectedUrl = "https://www.saucedemo.com/checkout-step-one.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Failed to proceed to the checkout page.");

        checkOutInformationPage.enterFirstName(firstName);
        test.info("First name entered: " + firstName);
        checkOutInformationPage.enterLastName(lastName);
        test.info("Last name entered: " + lastName);
        checkOutInformationPage.enterPostalCode(postalCode);
        test.info("Postal code entered: " + postalCode);

        checkOutInformationPage.clickContinueButton();
        test.info("Continue button clicked.");

        checkOutInformationPage.clickFinishButton();
        test.info("Finish button clicked.");

        expectedUrl = "https://www.saucedemo.com/checkout-complete.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Failed to navigate to the completion page.");
        test.pass("Finish button clicked and navigation verified.");
    }

    @Test
    @Parameters({"username", "password"})
    public void verifyClickCancelButton(String username, String password) {
        test.info("Starting test: Verify Click Cancel Button");

        // Initialize page objects
        LoginPage loginPage = new LoginPage(driver, suiteTest);
        CartPage cartPage = new CartPage(driver, suiteTest, test);
        ProductPage productPage = new ProductPage(driver, suiteTest);
        CheckOutInformationPage checkOutInformationPage = new CheckOutInformationPage(driver, suiteTest);

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

        // Verify checkout page is displayed
        String expectedUrl = "https://www.saucedemo.com/checkout-step-one.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Failed to proceed to the checkout page.");

        checkOutInformationPage.clickCancelButton();
        test.info("Cancel button clicked.");

        expectedUrl = "https://www.saucedemo.com/cart.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Failed to navigate to the cart page.");
        test.pass("Cancel button clicked and navigation verified.");
    }

    @Test
    @Parameters({"username", "password"})
    public void verifyErrorMessage(String username, String password) {
        test.info("Starting test: Verify Error Message");

        // Initialize page objects
        LoginPage loginPage = new LoginPage(driver, suiteTest);
        CartPage cartPage = new CartPage(driver, suiteTest, test);
        ProductPage productPage = new ProductPage(driver, suiteTest);
        CheckOutInformationPage checkOutInformationPage = new CheckOutInformationPage(driver, suiteTest);

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

        // Verify checkout page is displayed
        String expectedUrl = "https://www.saucedemo.com/checkout-step-one.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Failed to proceed to the checkout page.");

        checkOutInformationPage.clickContinueButton();
        test.info("Continue button clicked without entering required fields.");

        // Add assertions here to verify the error message
        String expectedErrorMessage = "Error: First Name is required";
        // Replace with actual method to get error message from UI
        String actualErrorMessage = checkOutInformationPage.getErrorMessage();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message not as expected.");
        test.pass("Error message verified.");
    }
}
