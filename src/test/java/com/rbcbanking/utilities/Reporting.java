package com.rbcbanking.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.io.IOException;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import java.text.SimpleDateFormat;

public class Reporting extends TestListenerAdapter {
    public ExtentReports extent;
    public ExtentTest test;
    public ExtentSparkReporter sparkReporter;

    @Override
    public void onStart(ITestContext context) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String reportName = "ExtentReport_" + timestamp + ".html";
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/"+reportName);
        try {
            sparkReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Host Name", "Virk");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", "Lovepreet");

        sparkReporter.config().setDocumentTitle("Automation Test Report");
        sparkReporter.config().setReportName("Functional Test Report");
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        test.log(Status.INFO, "Test started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test failed: " + result.getMethod().getMethodName());
        test.log(Status.FAIL, result.getThrowable());
        String screenshotpath = System.getProperty("user.dir")+"\\Screenshots\\"+result.getName()+".png";
        test.addScreenCaptureFromPath(screenshotpath);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
