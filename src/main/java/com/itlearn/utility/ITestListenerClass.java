package com.itlearn.utility;

import java.io.File;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ITestListenerClass implements ITestListener {

    private ExtentSparkReporter htmlReporter;
    private ExtentReports reports;
    private ExtentTest test;

    // Configuring the Extent Report
    private void configureReport() {
        htmlReporter = new ExtentSparkReporter("test-output/ExtentListenerReportDemo.html"); // Save report in test-output folder
        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);

        // Add system/environment info to reports
        reports.setSystemInfo("Machine", "RaviPc");
        reports.setSystemInfo("OS", "Windows 11");
        reports.setSystemInfo("User", "Ravi");

        // Configure the appearance of the report
        htmlReporter.config().setDocumentTitle("Extent Listener Report Demo");
        htmlReporter.config().setReportName("Test Execution Report");
        htmlReporter.config().setTheme(Theme.DARK);
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed: " + result.getName());
        test = reports.createTest(result.getName());
        test.log(Status.PASS, MarkupHelper.createLabel("Test Passed: " + result.getName(), ExtentColor.GREEN));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed: " + result.getName());
        test = reports.createTest(result.getName());
        test.log(Status.FAIL, MarkupHelper.createLabel("Test Failed: " + result.getName(), ExtentColor.RED));
        test.log(Status.FAIL, "Error: " + result.getThrowable());

        // Capture and attach screenshot (assuming screenshots are saved in /Screenshots)
        String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + result.getName() + ".png";
        File screenshotFile = new File(screenshotPath);

        if (screenshotFile.exists()) {
            try {
                test.fail("Screenshot below:");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped: " + result.getName());
        test = reports.createTest(result.getName());
        test.log(Status.SKIP, MarkupHelper.createLabel("Test Skipped: " + result.getName(), ExtentColor.YELLOW));
        test.log(Status.SKIP, "Skip Reason: " + result.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test failed but within success percentage: " + result.getName());
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result);
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test suite started...");
        configureReport();
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test suite finished...");
        if (reports != null) {
            reports.flush(); // Write all test information to the report
        }
    }
}
