package com.swagger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


@SuppressWarnings("unused")
public class OverviewPage extends BasePage {
    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[normalize-space()='FINISH']")
    private WebElement finishButton;

    public void clickOnFinishButton() {
            wait.until(ExpectedConditions.elementToBeClickable(finishButton));
            finishButton.click();
    }
}
