package com.swagger.pages;


import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;



@SuppressWarnings("unused")
@Log4j2
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
            log.info("username entered with name: " + name);
            usernameInput.sendKeys(name);
    }

    public void inputPassword(String password) {
            wait.until(ExpectedConditions.visibilityOf(passwordInput));
            log.info("password entered with password: " + password);
            passwordInput.sendKeys(password);
    }

    public void clickEnter() {
            wait.until(ExpectedConditions.visibilityOf(passwordInput));
            log.info("Enter button clicked");
            passwordInput.sendKeys(Keys.RETURN);
    }
    public String getErrorMessege() {
            wait.until(ExpectedConditions.visibilityOf(error));
            log.info("Error message fetched: " + error.getText());
            return error.getText();
    }
}
