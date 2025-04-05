package com.swagger.stepDefinition;

import com.swagger.pages.InventoryPage;
import com.swagger.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ValidLoginStep extends BaseStep{

    @Given("I open the url to test login functionality with valid credentials")
    public void i_open_the_url_to_test_login_functionality_with_valid_credentials() {
        openPage(properties.getProperty("SWAGGER_LOGIN_URL"));
    }

    @When("I Enter Valid Credentials and click log in button int the Login Page")
    public void i_enter_valid_credentials_and_click_log_in_button_int_the_login_page() {
        loginPage = new LoginPage(driver);
        loginPage.inputUserName(properties.getProperty("VALID_USER_NAME"));
        loginPage.inputPassword(properties.getProperty("VALID_PASSWORD"));
        loginPage.clickEnter();
    }

    @Then("I should see the Inventory Page")
    public void i_should_see_the_inventory_page() {
        inventoryPage = new InventoryPage(driver);
        assert inventoryPage.getLabel().equals("Products"):"ERROR IN LOGIN PAGE";
        tearDown();
    }

}
