package com.swagger.runner;

import com.swagger.utils.ExtentReportManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.swagger.stepDefinition",
        plugin = {
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {
        @Override
        @DataProvider(parallel = true) // 👈 Important: Enables parallel execution
        public Object[][] scenarios() {
                return super.scenarios();
        }
}
