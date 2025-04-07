package com.swagger.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


@SuppressWarnings("unused")
@Log4j2
public class OverviewPage extends BasePage {
    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[normalize-space()='FINISH']")
    private WebElement finishButton;

    public void clickOnFinishButton() {
            wait.until(ExpectedConditions.elementToBeClickable(finishButton));
            log.info("Clicked on Finish button");
            finishButton.click();
    }
}
