package com.swagger.pages;


import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


@Log4j2
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
        log.info("item is present in checkout");
        return inventoryItem.getText();
    }

    public void clickOnCheckoutButton() {
            wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
            log.info("Checkout button clicked");
            checkoutButton.click();
    }
}

