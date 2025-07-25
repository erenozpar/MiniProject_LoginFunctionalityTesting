package com.practicetestautomation.listeners;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.model.ScreenCapture;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.practicetestautomation.tests.LoginTest;
import com.practicetestautomation.utilities.Driver;
import com.practicetestautomation.utilities.ExelUtils;
import com.practicetestautomation.utilities.ExtentReportManager;
import com.practicetestautomation.utilities.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentListener implements ITestListener {
    ExtentReports extent = ExtentReportManager.getExtentReports();
    ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();



    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        testThread.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        testThread.get().log(Status.PASS, "Test Passed");


    }

    @Override
    public void onTestFailure(ITestResult result) {

        testThread.get().log(Status.FAIL, "Test Failed");

       String path = ScreenshotUtil.takeScreenshot(Driver.getDriver(),result.getName());

        try {
            testThread.get().addScreenCaptureFromPath(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        testThread.get().log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
