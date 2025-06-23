package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ExtentReportManager;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public static ExtentTest suiteTest;
    public ExtentTest test;

    @BeforeSuite
    public void setupSuite() {
        // Initialize ExtentReports once before the entire suite
        ExtentReportManager.setup();
        // Create a suite-level test instance
        suiteTest = ExtentReportManager.createTest("Test Suite")
                                       .assignAuthor("Sanjana Varma")
                                       .assignCategory("Functional Test");
    }

    @AfterSuite
    public void teardownSuite() {
        // Finalize ExtentReports once after the entire suite
        ExtentReportManager.flush();
    }

    @BeforeMethod
    @Parameters("browser")
    public void setup(Method method, String browser) {
        // Set up WebDriver based on the browser
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/"); // Update with the URL of your login page

        // Create a new test instance in ExtentReports
        test = ExtentReportManager.createTest(method.getName() + " on " + browser + " Browser")
                                  .assignAuthor("Sanjana Varma")
                                  .assignCategory("Functional Test");
        test.info("Starting test: " + method.getName() + " on " + browser + " Browser.");
        
    }

    @AfterMethod
    public void teardown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            // Capture screenshot on failure
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                String screenshotPath = "target/screenshots/" + result.getName() + ".png";
                FileHandler.copy(screenshot, new File(screenshotPath));
                test.fail("Test Failed: " + result.getName(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            } catch (IOException e) {
                test.fail("Failed to capture screenshot: " + e.getMessage());
                e.printStackTrace();
            }
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test Passed: " + result.getName());
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.skip("Test Skipped: " + result.getName());
        }

        if (driver != null) {
            driver.quit();
            test.info("Browser closed.");
        }
    }
}
