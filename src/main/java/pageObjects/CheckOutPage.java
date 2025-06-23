package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentTest;

import Locators.CheckOutPageLocators;
import utils.ElementFetch;
import org.testng.Assert;

public class CheckOutPage {

    private WebDriver driver;
    private ElementFetch elementFetch;
    private ExtentTest test;

    
    // Constructor
    public CheckOutPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
        elementFetch = new ElementFetch(driver);
    }

    // Actions
    private WebElement getElement(String locator, String locatorType) {
        return elementFetch.getWebElement(locatorType, locator);
    }

    // Method to click Finish button
    public void clickFinishButton() {
        WebElement finishBtn = getElement(CheckOutPageLocators.FINISH_BUTTON, "ID");
        finishBtn.click();
        test.info("Finish button clicked.");
    }

    // Method to click Cancel button
    public void clickCancelButton() {
        WebElement cancelBtn = getElement(CheckOutPageLocators.CANCEL_BUTTON, "ID");
        cancelBtn.click();
        test.info("Cancel button clicked.");
    }

    // Method to verify the URL
    public void verifyCartPageUrl() {
        Assert.assertEquals(driver.getCurrentUrl(), CheckOutPageLocators.CART_PAGE_URL, "Cart page URL is incorrect.");
        test.info("Cart page URL verified.");
    }
}
