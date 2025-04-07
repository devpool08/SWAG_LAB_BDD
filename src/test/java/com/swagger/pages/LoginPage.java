package com.swagger.pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;



@SuppressWarnings("unused")
public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement usernameInput;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement error;

    public void inputUserName(String name) {
            wait.until(ExpectedConditions.visibilityOf(usernameInput));
            usernameInput.sendKeys(name);
    }

    public void inputPassword(String password) {
            wait.until(ExpectedConditions.visibilityOf(passwordInput));
            passwordInput.sendKeys(password);
    }

    public void clickEnter() {
            wait.until(ExpectedConditions.visibilityOf(passwordInput));
            passwordInput.sendKeys(Keys.RETURN);
    }
    public String getErrorMessege() {
            wait.until(ExpectedConditions.visibilityOf(error));
            return error.getText();
    }
}
