package com.swagger.stepDefinition;

import com.swagger.pages.CheckOutPage;
import com.swagger.pages.InventoryPage;
import com.swagger.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckoutStep extends BaseStep{
    @Given("I am in the Inventory Page")
    public void i_am_in_the_inventory_page() {
        openPage(properties.getProperty("SWAGGER_LOGIN_URL"));
        loginPage = new LoginPage(driver);
        loginPage.inputUserName(properties.getProperty("VALID_USER_NAME"));
        loginPage.inputPassword(properties.getProperty("VALID_PASSWORD"));
        loginPage.clickEnter();
        inventoryPage = new InventoryPage(driver);
        assert inventoryPage.getLabel().equals("Products"):"ERROR IN LOGIN PAGE";
    }

    @And("I am sorting the items by their price")
    public void i_am_sorting_the_items_by_their_price() {
        inventoryPage.sortByPriceLowToHigh();
    }

    @When("I add a product in to the cart")
    public void i_add_a_product_in_to_the_cart() {
        inventoryPage.addProductToCart();
    }

    @Then("I should see the Cart Page")
    public void i_should_see_the_cart_page() {
        assertTrue(inventoryPage.verifyProductCart(), "Product is not in cart");
        checkOutPage = new CheckOutPage(driver);
        assertEquals(checkOutPage.isItemPresent(), "Sauce Labs Onesie");
        tearDown();
    }

}
