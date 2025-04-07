package com.swagger.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


@SuppressWarnings("unused")
public class CheckOutPage extends BasePage {

    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private WebElement inventoryItem;
    @FindBy(xpath = "//a[normalize-space()='CHECKOUT']")
    private WebElement checkoutButton;

    public String getItemName() {
        wait.until(ExpectedConditions.visibilityOf(inventoryItem));
        System.out.println(inventoryItem.getText());
        return inventoryItem.getText();
    }

    public void clickOnCheckoutButton() {
            wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
            checkoutButton.click();
    }
}

