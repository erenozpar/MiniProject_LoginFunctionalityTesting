package com.practicetestautomation.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager {
    private static ExtentReports extent;


    public static ExtentReports getExtentReports() {


        if (extent == null) {
            extent = new ExtentReports();
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            ExtentSparkReporter spark = new ExtentSparkReporter("test-output/reports/ExtentReport" + "_" + timeStamp + ".html");
           spark.loadXMLConfig("extent-config.xml");

            extent.setSystemInfo("OS", "Windows11");
            extent.setSystemInfo("Tester", "EO");
            extent.setSystemInfo("Environment", "Functionality Testing");

            extent.attachReporter(spark);

        }
        return extent;
    }

}
