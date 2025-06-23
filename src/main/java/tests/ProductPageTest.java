package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.ProductPage;
import base.BaseTest; // Assuming BaseTest provides WebDriver setup and teardown

public class ProductPageTest extends BaseTest {

    @Test
    @Parameters({"username", "password"})
    public void verifyAddAndRemoveFromCartFunctionality(String username, String password) {
        suiteTest.info("Starting test: Verify Add and Remove From Cart Functionality");

        // Initialize LoginPage and ProductPage objects
        LoginPage loginPage = new LoginPage(driver, suiteTest);
        ProductPage productPage = new ProductPage(driver, suiteTest);

        // Perform login
        loginPage.enterUsername(username);
        test.info("Username entered: " + username);

        loginPage.enterPassword(password);
        test.info("Password entered.");

        loginPage.clickLoginButton();
        test.info("Login button clicked.");

        // Add first item to the cart
        productPage.addItemToCart(0);
        test.info("First item added to cart.");
        Assert.assertTrue(productPage.verifyItemsInCart(1), "Failed to add the first item to the cart.");

        // Add second item to the cart
        productPage.addItemToCart(1);
        test.info("Second item added to cart.");
        Assert.assertTrue(productPage.verifyItemsInCart(2), "Failed to add the second item to the cart.");

        // Remove the first item from the cart
        productPage.removeItemFromCart(0);
        test.info("First item removed from cart.");
        Assert.assertTrue(productPage.verifyItemsInCart(1), "Failed to remove the first item from the cart.");

        suiteTest.pass("Add and Remove From Cart functionality verified successfully.");
    }

    @Test
    @Parameters({"username", "password"})
    public void verifyProductFilters(String username, String password) {
        suiteTest.info("Starting test: Verify Product Filters");

        // Initialize LoginPage and ProductPage objects
        LoginPage loginPage = new LoginPage(driver, suiteTest);
        ProductPage productPage = new ProductPage(driver, suiteTest);

        // Perform login
        loginPage.enterUsername(username);
        test.info("Username entered: " + username);

        loginPage.enterPassword(password);
        test.info("Password entered.");

        loginPage.clickLoginButton();
        test.info("Login button clicked.");

        // Apply filter: Price (low to high)
        productPage.selectFilterOption("Price (low to high)");
        test.info("Filter applied: Price (low to high)");
        Assert.assertTrue(productPage.verifyProductsSortedByPriceLowToHigh(), "Products are not sorted by price low to high.");

        // Apply filter: Price (high to low)
        productPage.selectFilterOption("Price (high to low)");
        test.info("Filter applied: Price (high to low)");
        Assert.assertTrue(productPage.verifyProductsSortedByPriceHighToLow(), "Products are not sorted by price high to low.");

        // Apply filter: Name (A to Z)
        productPage.selectFilterOption("Name (A to Z)");
        test.info("Filter applied: Name (A to Z)");
        Assert.assertTrue(productPage.verifyProductsSortedByNameAtoZ(), "Products are not sorted by name A to Z.");

        // Apply filter: Name (Z to A)
        productPage.selectFilterOption("Name (Z to A)");
        test.info("Filter applied: Name (Z to A)");
        Assert.assertTrue(productPage.verifyProductsSortedByNameZtoA(), "Products are not sorted by name Z to A.");

        suiteTest.pass("Product filters functionality verified successfully.");
    }
}
