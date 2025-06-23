package pageObjects;

import Locators.LogoutPageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;
import utils.ElementFetch;

public class LogOutPage {

    private WebDriver driver;
    private ElementFetch elementFetch;
    private ExtentTest test;
    
    public LogOutPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
        this.elementFetch = new ElementFetch(driver);
    }

    // Actions
    private WebElement getElement(String locator, String locatorType) {
        return elementFetch.getWebElement(locatorType, locator);
    }
    
    public void verifyLogOut() {
        // Click on menu button
        WebElement menuButton = getElement(LogoutPageLocators.menuButton, "ID");
        menuButton.click();
        test.info("Menu button clicked");

        // Click on logout button
        WebElement logoutButton = getElement(LogoutPageLocators.logoutButton, "ID");
        logoutButton.click();
        test.info("Logout button clicked");

        // Verify that login button is displayed after logout
        WebElement loginButtonAfterLogout = getElement(LogoutPageLocators.loginButtonAfterLogout, "ID");
        Assert.assertTrue(loginButtonAfterLogout.isDisplayed(), "Login button is not displayed after logout");
        test.info("Logged out from account and login button is displayed");
    }
}
