package com.swagger.runner;

import com.swagger.utils.ExtentReportManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.swagger.stepDefinition",
        plugin = {
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)
@Listeners(ExtentReportManager.class)
public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @Test(threadPoolSize = 6, timeOut = 80000)
    public void runTests() {
        scenarios();
    }

}
