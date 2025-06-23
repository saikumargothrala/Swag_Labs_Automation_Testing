package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.LogOutPage;
import pageObjects.LoginPage;
import base.BaseTest; // Assuming BaseTest provides WebDriver setup and teardown

public class LogOutTest extends BaseTest {

    @Test
    @Parameters({"username", "password"})
    public void verifyLogOutFunctionality(String username, String password) {
    	suiteTest.info("Starting test: Verify LogOut Functionality");
        // Initialize LoginPage and LogOutPage objects
        LoginPage loginPage = new LoginPage(driver, suiteTest);
        LogOutPage logOutPage = new LogOutPage(driver, suiteTest);

        // Perform login
        loginPage.enterUsername(username);
        test.info("Username entered: " + username);

        loginPage.enterPassword(password);
        test.info("Password entered.");

        loginPage.clickLoginButton();
       test.info("Login button clicked.");

        // Add assertions here to verify login (optional, based on your application)

      
        
        // Verify logout
        logOutPage.verifyLogOut();
        test.info("Logout functionality verified.");

        // Add assertions here to verify logout success (optional)
    }
}
