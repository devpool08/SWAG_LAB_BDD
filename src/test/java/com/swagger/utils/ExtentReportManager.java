package com.swagger.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.swagger.stepDefinition.*;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.swagger.stepDefinition.BaseStep.tearDown;


@SuppressWarnings("all")
public class ExtentReportManager implements ITestListener {
    /// Responsible for UI of The report like how it should look like , like theme light or dark
    private ExtentSparkReporter sparkReporter;
    /// Populating some common info of the report like who is performing , what is the environment , what is the browser etc
    private ExtentReports reporter;
    /// Creating test for each test case entry like test status whether pass or fail or skip
    private ExtentTest test;

    String reportName;

    @Override
    public void onTestStart(ITestResult result) {
        test = reporter.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.INFO, "Test started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test = reporter.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.PASS, "Test  " + result.getName() + " successfully executed");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        test = reporter.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.FAIL, "Test  " + result.getName() + " failed due to: " + result.getThrowable());
        try {
            String imgPath = BaseStep.captureScreenshot(result.getName());
            System.out.println("---------------" + result.getInstance().toString());
            test.addScreenCaptureFromPath(imgPath);
            tearDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test = reporter.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.SKIP, "Test  " + result.getName() + " skipped");
    }


    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result);
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("ok");
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        reportName = "SwagLab-Report-" + timeStamp + ".html";
        sparkReporter = new ExtentSparkReporter(".\\reports\\" + reportName);
        sparkReporter.config().setDocumentTitle("SwagLab Test Automation Report");
        sparkReporter.config().setReportName("SwagLab Functional Testing");
        sparkReporter.config().setTheme(Theme.DARK);

        reporter = new ExtentReports();
        reporter.attachReporter(sparkReporter);
        reporter.setSystemInfo("Applications", "SwagLab");
        reporter.setSystemInfo("Module", "Admin");
        reporter.setSystemInfo("Environment", "QA");
        reporter.setSystemInfo("Tester", "Debadatta");
        String os = context.getCurrentXmlTest().getParameter("os");
        reporter.setSystemInfo("Operating System", "Windows");
        String browser = context.getCurrentXmlTest().getParameter("browser");
        reporter.setSystemInfo("Browser", browser);
    }

    @Override
    public void onFinish(ITestContext context) {
        reporter.flush();

        String pathOfExtentReport = System.getProperty("user.dir") + "\\reports\\" + reportName;
        File extentReport = new File(pathOfExtentReport);

        try {
            Desktop.getDesktop().browse(extentReport.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

