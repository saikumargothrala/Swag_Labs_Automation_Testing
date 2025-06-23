package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentTest;
import utils.ElementFetch;

public class CheckOutInformationPage {

    private WebDriver driver;
    private ElementFetch elementFetch;
    private ExtentTest test;

    // Constructor
    public CheckOutInformationPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
        elementFetch = new ElementFetch(driver);
    }

    // Actions
    private WebElement getElement(String locator, String locatorType) {
        return elementFetch.getWebElement(locatorType, locator);
    }

    public void enterFirstName(String firstName) {
        WebElement firstNameField = getElement("first-name", "ID");
        firstNameField.sendKeys(firstName);
        test.info("Entered first name: " + firstName);
    }

    public void enterLastName(String lastName) {
        WebElement lastNameField = getElement("last-name", "ID");
        lastNameField.sendKeys(lastName);
        test.info("Entered last name: " + lastName);
    }

    public void enterPostalCode(String postalCode) {
        WebElement postalCodeField = getElement("postal-code", "ID");
        postalCodeField.sendKeys(postalCode);
        test.info("Entered postal code: " + postalCode);
    }

    public void clickContinueButton() {
        WebElement continueButton = getElement("continue", "ID");
        continueButton.click();
        test.info("Continue button clicked.");
    }

    public void clickFinishButton() {
        WebElement finishButton = getElement("finish", "ID");
        finishButton.click();
        test.info("Finish button clicked.");
    }

    public void clickCancelButton() {
        WebElement cancelButton = getElement("cancel", "ID");
        cancelButton.click();
        test.info("Cancel button clicked.");
    }

    public String getCheckoutOverviewTitle() {
        WebElement titleElement = getElement("title", "CLASS_NAME");
        String title = titleElement.getText();
        test.info("Checkout overview title retrieved: " + title);
        return title;
    }

    public String getErrorMessage() {
        WebElement errorMessageElement = getElement("error-message-container", "CLASS_NAME");
        String errorMessage = errorMessageElement.getText();
        test.info("Error message retrieved: " + errorMessage);
        return errorMessage;
    }
}
