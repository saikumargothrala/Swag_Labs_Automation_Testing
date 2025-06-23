package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ElementFetch {

    private WebDriver driver;

    public ElementFetch(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getWebElement(String identifierType, String identifierValue) {
        switch (identifierType.toUpperCase()) {
            case "XPATH":
                return driver.findElement(By.xpath(identifierValue));
            case "ID":
                return driver.findElement(By.id(identifierValue));
            case "NAME":
                return driver.findElement(By.name(identifierValue));
            case "CLASS_NAME":
                return driver.findElement(By.className(identifierValue));
            case "CSS_SELECTOR":
                return driver.findElement(By.cssSelector(identifierValue));
            case "LINK_TEXT":
                return driver.findElement(By.linkText(identifierValue));
            case "PARTIAL_LINK_TEXT":
                return driver.findElement(By.partialLinkText(identifierValue));
            case "TAG_NAME":
                return driver.findElement(By.tagName(identifierValue));
            default:
                throw new IllegalArgumentException("Invalid identifier type: " + identifierType);
        }
    }

    public List<WebElement> getWebElements(String identifierType, String identifierValue) {
        switch (identifierType.toUpperCase()) {
            case "XPATH":
                return driver.findElements(By.xpath(identifierValue));
            case "ID":
                return driver.findElements(By.id(identifierValue));
            case "NAME":
                return driver.findElements(By.name(identifierValue));
            case "CLASS_NAME":
                return driver.findElements(By.className(identifierValue));
            case "CSS_SELECTOR":
                return driver.findElements(By.cssSelector(identifierValue));
            case "LINK_TEXT":
                return driver.findElements(By.linkText(identifierValue));
            case "PARTIAL_LINK_TEXT":
                return driver.findElements(By.partialLinkText(identifierValue));
            case "TAG_NAME":
                return driver.findElements(By.tagName(identifierValue));
            default:
                throw new IllegalArgumentException("Invalid identifier type: " + identifierType);
        }
    }
}
