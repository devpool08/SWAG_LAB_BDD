package com.swagger.stepDefinition;

import com.swagger.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class InvalidLoginSteps extends BaseStep{
    @Given("I open the url of Swag Lab to test login functionality with invalid credentials")
    public void i_open_the_url_of_swag_lab_to_test_login_functionality_with_invalid_credentials() {
        openPage(properties.getProperty("SWAGGER_LOGIN_URL"));
    }

    @When("I enter {string} and {string} and click the login button in the Login Page")
    public void i_enter_and_and_click_the_login_button_in_the_login_page(String username, String password) {
        loginPage = new LoginPage(driver);
        loginPage.inputUserName(username);
        loginPage.inputPassword(password);
        loginPage.clickEnter();
    }

    @Then("I should see the error message")
    public void i_should_see_the_error_message() {
        String errorMessage = loginPage.getErrorMessege();
        assertTrue("Epic sadface: Username and password do not match any user in this service", errorMessage.contains("Epic sadface: Username and password do not match any user in this service"));
        tearDown();
    }
}
