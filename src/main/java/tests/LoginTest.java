package tests;

import base.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    @Parameters({"username", "password"})
    public void LoginTestWithValidCredentials(String username, String password) {
        suiteTest.info("Starting test: Login Test With Valid Credentials");
        LoginPage loginPage = new LoginPage(driver, suiteTest);
      
        loginPage.enterUsername(username);
        test.info("Username entered: " + username);

        loginPage.enterPassword(password);
        test.info("Password entered.");

        loginPage.clickLoginButton();
        test.info("Login button clicked.");

        loginPage.verifyLoginPage();
        test.info("Login page verification complete.");
        // Add assertions here to verify login
    }

    @Test
    public void LoginTestWithBlankCredentials() {
        suiteTest.info("Starting test: Login Test With Blank Credentials");
        LoginPage loginPage = new LoginPage(driver, suiteTest);
        test.info("Login button clicked without entering credentials.");
        loginPage.clickLoginButton();
        test.info("Login button clicked.");

        loginPage.verifyErrorForBlankFields();
        test.info("Error message for blank credentials verified.");
        // Add assertions here to verify error message for blank username and password
    }

    @Test
    @Parameters({"password"})
    public void LoginTestWithBlankUserName(String password) {
        suiteTest.info("Starting test: Login Test With Blank UserName");
        LoginPage loginPage = new LoginPage(driver, suiteTest);
        loginPage.enterPassword(password);
        test.info("Password entered.");
        
        loginPage.clickLoginButton();
        test.info("Login button clicked.");
        
        loginPage.verifyErrorForBlankFields();
        test.info("Error message for blank username verified.");
        // Add assertions here to verify error message for blank username
    }

    @Test
    @Parameters({"username"})
    public void LoginTestWithBlankPassword(String username) {
        suiteTest.info("Starting test: Login Test With Blank Password");
        LoginPage loginPage = new LoginPage(driver, suiteTest);
        loginPage.enterUsername(username);
        test.info("Username entered: " + username);
        
        loginPage.clickLoginButton();
        test.info("Login button clicked.");
        
        loginPage.verifyErrorForBlankPassword();
        test.info("Error message for blank password verified.");
        // Add assertions here to verify error message for blank password
    }

    @Test
    @Parameters({"invalidusername"})
    public void LoginTestWithInvalidPassword(String invalidUsername) {
        suiteTest.info("Starting test: Login Test With Invalid Password");
        LoginPage loginPage = new LoginPage(driver, suiteTest);
        loginPage.enterUsername(invalidUsername);
        test.info("Invalid Username entered: " + invalidUsername);
        
        loginPage.clickLoginButton();
        test.info("Login button clicked.");
        
        loginPage.verifyErrorForBlankPassword();
        test.info("Error message for invalid password credential verified.");
        // Add assertions here to verify error message for invalid password
    }

    @Test
    @Parameters({"invalidpassword"})
    public void LoginTestWithInvalidUserName(String invalidPassword) {
        suiteTest.info("Starting test: Login Test With Invalid UserName");
        LoginPage loginPage = new LoginPage(driver, suiteTest);
        loginPage.enterPassword(invalidPassword);
        test.info("Invalid Password entered: " + invalidPassword);
        
        loginPage.clickLoginButton();
        test.info("Login button clicked.");
        
        loginPage.verifyErrorForBlankFields();
        test.info("Error message for invalid username credential verified.");
        // Add assertions here to verify error message for invalid username
    }

    @Test
    @Parameters({"invalidusername", "invalidpassword"})
    public void LoginTestWithInvalidCredentials(String invalidUsername, String invalidPassword) {
        suiteTest.info("Starting test: Login Test With Invalid Credentials");
        LoginPage loginPage = new LoginPage(driver, suiteTest);
        loginPage.enterUsername(invalidUsername);
        test.info("Invalid Username entered: " + invalidUsername);

        loginPage.enterPassword(invalidPassword);
        test.info("Invalid Password entered: " + invalidPassword);

        loginPage.clickLoginButton();
        test.info("Login button clicked with invalid credentials.");

        loginPage.verifyErrorForInvalidCredentials();
        test.info("Error message for invalid credentials verified.");
        // Add assertions here to verify login with invalid credentials
    }
}
