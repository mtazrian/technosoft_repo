package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import framework.DarkSkyHomePage;

/**
 * Created by Mo Tazrian on 3/9/18.
 */
public class DarkSky1SD {

    DarkSkyHomePage darkSkyHomePage = new DarkSkyHomePage();

    @Given("^I am on home page of DarkSky$")
    public void pageTitleVerification() {
        darkSkyHomePage.pageTitleVerification();
    }


    @Then("^I verify days of the week is displayed in correct order$")
    public void dayVerification() {

//        Creating array from actual elements pulled from website
        darkSkyHomePage.createActualArray();

//        Creating expected array of elements
        darkSkyHomePage.createExpectedArray();

//        Verify if actual and expected values are equal
        darkSkyHomePage.arrayVerification();

        }
    }
