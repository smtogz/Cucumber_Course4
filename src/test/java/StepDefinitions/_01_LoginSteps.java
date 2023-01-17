package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class _01_LoginSteps {
    DialogContent dc=new DialogContent();
    @Given("Navigate to campus")
    public void navigateToCampus() {
        GWD.getDriver().get("https://test.mersys.io/");
        dc.findAndClick("acceptAllCookies");
    }

    @When("Enter username and password and click login button")
    public void enterUsernameAndPasswordAndClickLoginButton() {

//        dc.findAndSend("username","richfield.edu");
//        dc.findAndSend("password","Richfield2020!");
        dc.findAndSend("username","turkeyts");
        dc.findAndSend("password","TechnoStudy123");
        dc.findAndClick("loginButton");
    }

    @Then("User should login successfully")
    public void userShouldLoginSuccessfully() {
        dc.findAndContainsText("dashboard","Dashboard");
    }
}
