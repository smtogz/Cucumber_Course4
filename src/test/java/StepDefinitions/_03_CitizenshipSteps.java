package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import Pages.Parent;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class _03_CitizenshipSteps extends Parent {
    LeftNav ln=new LeftNav();
    DialogContent dc=new DialogContent();
    @And("Navigate to citizenship page")
    public void navigateToCitizenshipPage() {
        ln.findAndClick("setupOne");
        ln.findAndClick("parameters");
        ln.findAndClick("citizenships");
    }

    @When("Create a citizenship name as {string} shortName as {string}")
    public void createACitizenshipNameAsShortNameAs(String name, String shortName) {
        dc.findAndContainsText("pageHead","Citizenships");
        dc.findAndClick("addButton");
        dc.findAndSend("nameInput",name);
        dc.findAndSend("shortNameInput",shortName);
        dc.findAndClick("saveButton");
    }

    @Then("Already exits message should be displayed")
    public void alreadyExitsMessageShouldBeDisplayed() {
        dc.findAndContainsText("alreadyMessage","already");
    }

    @When("User should delete a citizenship name as {string} shortName as {string}")
    public void userShouldDeleteACitizenshipNameAsShortNameAs(String name, String shortName) {
        dc.findAndContainsText("pageHead","Citizenships");
        dc.findAndSend("searchName",name);
        dc.findAndSend("searchShortName",shortName);
        dc.findAndClick("searchButton");
        dc.findAndContainsText("searchResultCell",name);
        dc.findAndClick("deleteButton");
        dc.findAndClick("deleteApprove");
    }
}
