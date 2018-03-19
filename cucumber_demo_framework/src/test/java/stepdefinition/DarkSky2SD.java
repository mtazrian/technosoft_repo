package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.DarkSkyHomePage;

/**
 * Created by Mo Tazrian on 3/14/18.
 */
public class DarkSky2SD {

    DarkSkyHomePage darkSkyHomePage = new DarkSkyHomePage();

    @When("^I click on today's bar$")
    public void clickParentBars() {

//        Click on all days of the week
        darkSkyHomePage.clickOnParentBars();
    }

    @Then("^I verify low and high temps displayed correctly on parent bar$")
    public void tempVerifications() {


//        Get all minimum and maximum temperatures from outside parent bar
        darkSkyHomePage.getMinMaxTemps();


//        Get all low and high temperature from inside each bar
        darkSkyHomePage.getLowHighTemps();


//        Verify all low and high temperatures are equal
        darkSkyHomePage.assertVerification();
    }

}
