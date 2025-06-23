
package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static ExtentReports extent;
    private static ExtentTest test;

    // Setup method to configure ExtentReports
    public static void setup() {
        if (extent == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/SparkReport.html");
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
        }
    }

    // Method to create a new test in the report
    public static ExtentTest createTest(String testName) {
        test = extent.createTest(testName);
        return test;
    }

    // Method to flush the report
    public static void flush() {
        if (extent != null) {
            extent.flush();
        }
    }

    // Method to get the current test
    public static ExtentTest getTest() {
        return test;
    }
}
