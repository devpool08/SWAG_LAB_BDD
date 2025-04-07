package com.swagger.pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@SuppressWarnings("unused")
public class CheckoutInfoFillFormPage extends BasePage {

    public CheckoutInfoFillFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='subheader']")
    private WebElement subHeader;
    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstNameInput;
    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastNameInput;
    @FindBy(xpath = "//input[@id='postal-code']")
    private WebElement postalCodeInput;
    @FindBy(xpath = "//input[@value='CONTINUE']")
    private WebElement continueButton;



    public String isCheckoutInfoPresent() {
            wait.until(ExpectedConditions.visibilityOf(subHeader));
            return subHeader.getText();
    }

    public void inputFirstName(String name) {
            wait.until(ExpectedConditions.visibilityOf(firstNameInput));
            firstNameInput.sendKeys(name);
    }

    public void inputLastName(String name) {
            wait.until(ExpectedConditions.visibilityOf(lastNameInput));
            lastNameInput.sendKeys(name);
    }

    public void inputPostalCode(String code) {
            wait.until(ExpectedConditions.visibilityOf(postalCodeInput));
            postalCodeInput.sendKeys(code);
            postalCodeInput.sendKeys(Keys.ENTER);
    }
    public boolean clickContinueButton() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(continueButton));
            continueButton.click();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
