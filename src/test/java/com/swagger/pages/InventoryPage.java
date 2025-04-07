package com.swagger.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


@SuppressWarnings("unused")
@Log4j2
public class InventoryPage extends BasePage {
    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='product_label']")
    private WebElement pageLabel;
    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement dropdown;
    @FindBy(xpath = "//div[@class='inventory_list']//div[1]//div[3]//button[1]")
    private WebElement addProduct;
    @FindBy(xpath = "//span[@class='fa-layers-counter shopping_cart_badge']")
    private WebElement cartBadge;
    @FindBy(xpath = "//a[@class='shopping_cart_link fa-layers fa-fw']")
    private WebElement checkoutCart;

    public String getLabel() {
        wait.until(ExpectedConditions.visibilityOf(pageLabel));
        log.info("got page label");
        return pageLabel.getText();
    }

    public void sortByPriceLowToHigh() {
        wait.until(ExpectedConditions.visibilityOf(dropdown));
        dropdown.click();
        Select selectDropDown = new Select(dropdown);
        selectDropDown.selectByContainsVisibleText("Price (low to high)");
        log.info("selected sort by price low to high");
    }

    public void addProductToCart() {
        wait.until(ExpectedConditions.visibilityOf(addProduct));
        log.info("product added to cart");
        addProduct.click();
    }

    public boolean verifyProductCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartBadge));
        log.info("cart badge is displayed");
        return cartBadge.isDisplayed();
    }

    public void checkoutCart() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutCart));
        log.info("clicked checkout cart");
        checkoutCart.click();
    }
}