package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.HotelsHomePage;


/**
 * Created by Mo Tazrian on 3/14/18.
 */
public class HotelSearchSD {

    HotelsHomePage hotelsHomePage = new HotelsHomePage();

    @Given("^I am on hotels.com$")
    public void iAmOnHomePage() {

        hotelsHomePage.iAmOnHomePage();
    }

    @And("^I type in Minnesota$")
    public void typeDestination() {

        hotelsHomePage.typeDestination();
    }

    @And("^I click Minnesota City from auto suggest box$")
    public void clickFromAutoComplete() {

        hotelsHomePage.selectFromAutoComplete();
    }

    @And("^I check in for 6 days starting tomorrow$")
    public void selectCalendarDates() {

        hotelsHomePage.selectCalendarDates();
    }

    @And("^I select 2 adults and 2 children$")
    public void selectTravelers() {

        hotelsHomePage.selectTravelersFromDropdown();
    }

    @And("^I select ages 2 and 4 for the children$")
    public void selectAgesOfChildren() {

        hotelsHomePage.selectAgeOfChildren();
    }

    @Then("^I am able to search for hotels$")
    public void clickSearch() {

        hotelsHomePage.clickSearch();
    }


}
