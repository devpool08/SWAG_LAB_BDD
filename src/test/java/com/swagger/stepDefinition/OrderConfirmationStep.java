package com.swagger.stepDefinition;

import com.swagger.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.SneakyThrows;
import org.apache.commons.lang3.RandomStringUtils;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class OrderConfirmationStep extends BaseStep{
    @SneakyThrows
    @Given("I am in the Checkout form page")
    public void i_am_in_the_checkout_form_page() {
        openPage(properties.getProperty("SWAGGER_LOGIN_URL"));
        loginPage = new LoginPage(driver);
        loginPage.inputUserName(properties.getProperty("VALID_USER_NAME"));
        loginPage.inputPassword(properties.getProperty("VALID_PASSWORD"));
        loginPage.clickEnter();
        inventoryPage = new InventoryPage(driver);
        assert inventoryPage.getLabel().equals("Products"):"ERROR IN LOGIN PAGE";
        inventoryPage.sortByPriceLowToHigh();
        inventoryPage.addProductToCart();
        assertTrue(inventoryPage.verifyProductCart(), "Product is not in cart");
        inventoryPage.checkoutCart();
        checkOutPage = new CheckOutPage(driver);
        assertEquals(checkOutPage.isItemPresent(), "Sauce Labs Onesie");
        assertTrue(checkOutPage.clickOnCheckoutButton(), "Error while clicking check out button");
        checkoutInfoFillFormPage = new CheckoutInfoFillFormPage(driver);
        assertEquals(checkoutInfoFillFormPage.isCheckoutInfoPresent(), "Checkout: Your Information");
    }

    @When("I am filling the Checkout form and proceed")
    public void i_am_filling_the_checkout_form_and_proceed() {
        assertEquals(checkoutInfoFillFormPage.isCheckoutInfoPresent(), "Checkout: Your Information");
        assertTrue(checkoutInfoFillFormPage.
                inputFirstName(RandomStringUtils.randomAlphabetic(6)), "Error in Filling first name");
        assertTrue(checkoutInfoFillFormPage.
                inputLastName(RandomStringUtils.randomAlphabetic(6)), "Error in Filling last name");
        assertTrue(checkoutInfoFillFormPage.
                inputPostalCode(RandomStringUtils.randomNumeric(5)), "Error in Filling postal code");
    }

    @Then("I should see theOverview page")
    public void i_should_see_the_overview_page() {
        overviewPage = new OverviewPage(driver);
        overviewPage.clickOnFinishButton();
    }

    @And("I should see the message")
    public void i_should_see_the_message() {
        finalPage = new FinalPage(driver);
        String orderConfirmationMessage = finalPage.getThankYouMessage();
        assertEquals(orderConfirmationMessage, "THANK YOU FOR YOUR ORDER");
        tearDown();
    }

}
