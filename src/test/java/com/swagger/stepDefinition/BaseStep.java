package com.swagger.stepDefinition;

import com.swagger.pages.*;
import com.swagger.utils.SingletonWebDriverFactory;
import lombok.SneakyThrows;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

@SuppressWarnings({"unused","ResultOfMethodCallIgnored"})
public class BaseStep {
    protected  static WebDriver driver;
    protected static SingletonWebDriverFactory factory;
    protected Properties properties;


    protected LoginPage loginPage;
    protected InventoryPage inventoryPage;
    protected CheckOutPage checkOutPage;
    protected CheckoutInfoFillFormPage checkoutInfoFillFormPage;
    protected OverviewPage overviewPage;
    protected FinalPage finalPage;

    BaseStep(){
        setup();
    }
    public void setup() {
        String browserName = System.getProperty("browser", "chrome");
        loadProperties();
        factory=SingletonWebDriverFactory.getInstance(browserName);
        driver= factory.getDriver();
        System.out.println("I'm running "+ browserName);
    }
    public void openPage(String URL) {
        driver.get(URL);
    }
    @SneakyThrows
    public void loadProperties() {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/test/resources/config.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  static String captureScreenshot(String name) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
        String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + name + "_" + timeStamp + ".png";
        File targetFile = new File(targetFilePath);
        sourceFile.renameTo(targetFile);
        return targetFilePath;
    }
    public static void tearDown(){
        if(driver != null){
            factory.quitDriver();
        }
    }
}
