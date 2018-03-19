package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.DarkSkyHomePage;

/**
 * Created by Mo Tazrian on 3/14/18.
 */
public class DarkSky3SD {

    DarkSkyHomePage darkSkyHomePage = new DarkSkyHomePage();

    @When("^I click on Time Machine$")
    public void clickTimeMachine() {

        darkSkyHomePage.clickTimeMachine();
    }

    @And("^I select tomorrow date$")
    public void selectDateFromCalendar() {

        darkSkyHomePage.selectDateFromCalendar();
    }

    @And("^I verify selected date is not clickable$")
    public void verifyDateNotClickcable() {

        darkSkyHomePage.verifyDateNotClickable();
    }

    @Then("^I verify date is displayed in correct format$")
    public void verifyCorrectFormat() {

        darkSkyHomePage.verifyCorrectFormat();
    }





}
