package pageObjects;

import Locators.LoginPageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;
import utils.ElementFetch;

public class LoginPage {

    private WebDriver driver;
    private ElementFetch elementFetch;
    private ExtentTest test;

    public LoginPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
        elementFetch = new ElementFetch(driver);
    }

    // Actions
    private WebElement getElement(String locator, String locatorType) {
        return elementFetch.getWebElement(locatorType, locator);
    }
    
    public void enterUsername(String username) {
        WebElement usernameField = getElement(LoginPageLocators.USERNAME_FIELD, "ID");
        usernameField.sendKeys(username);
        test.info("Entered username: " + username);
    }

    public void enterPassword(String password) {
        WebElement passwordField = getElement(LoginPageLocators.PASSWORD_FIELD, "ID");
        passwordField.sendKeys(password);
        test.info("Entered password.");
    }

    public void clickLoginButton() {
        WebElement loginButton = getElement(LoginPageLocators.LOGIN_BUTTON, "ID");
        loginButton.click();
        test.info("Login button clicked.");
    }

    public void verifyLoginPage() {
        WebElement logo = getElement(LoginPageLocators.APP_LOGO, "XPATH");
        Assert.assertTrue(logo.isDisplayed(), "Logo is not displayed on the login page");
        
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Swag Labs", "Page title is incorrect");
        test.info("Home page header verified.");
    }

    public void verifyErrorMessage(String expectedMessage, String locator, String locatorType) {
        // Fetch the WebElement for the error message
        WebElement errorMessageElement = elementFetch.getWebElement(locatorType, locator);
        
        // Retrieve the actual error message text
        String actualErrorMessage = errorMessageElement.getText();
        
        // Assert that the actual error message matches the expected message
        Assert.assertEquals(actualErrorMessage, expectedMessage, "Error message is incorrect.");
    }

    public void verifyErrorForBlankFields() {
        verifyErrorMessage("Epic sadface: Username is required", LoginPageLocators.Error_Message, "XPATH");
        test.info("Error message verified for bank fields");
    }

    public void verifyErrorForBlankUsername() {
        verifyErrorMessage("Epic sadface: Username is required", LoginPageLocators.Error_Message, "XPATH");
        test.info("Error message verified for bank username");
    }

    public void verifyErrorForBlankPassword() {
        verifyErrorMessage("Epic sadface: Password is required", LoginPageLocators.Error_Message, "XPATH");
        test.info("Error message verified for bank Password");
    }

    public void verifyErrorForInvalidCredentials() {
        verifyErrorMessage("Epic sadface: Username and password do not match any user in this service", LoginPageLocators.Error_Message, "XPATH");
        test.info("Error message verified for invalid credentials");
    }

   
}
