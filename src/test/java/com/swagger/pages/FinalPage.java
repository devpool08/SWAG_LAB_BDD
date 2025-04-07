package com.swagger.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


@SuppressWarnings({"unused"})
@Log4j2
public class FinalPage extends BasePage {
    public FinalPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//h2[normalize-space()='THANK YOU FOR YOUR ORDER']")
    private WebElement thankYouMessage;

    public String getThankYouMessage() {
            wait.until(ExpectedConditions.visibilityOf(thankYouMessage));
            log.info("thankYouMessage is displayed");
            return thankYouMessage.getText();
    }
}
