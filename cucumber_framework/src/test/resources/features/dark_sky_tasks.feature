@regression @TA_1

Feature: Dark Sky Week Day Verification
  Background:
    Given I am on home page of DarkSky

  @Task-1
  Scenario: Verify weekly forecast days are displayed correctly
    Then I verify days of the week is displayed in correct order


  @Task-2
  Scenario: Verify low to high value is displayed correctly in weekly forecast section
    When I click on today's bar
    Then I verify low and high temps displayed correctly on parent bar

  @Task-3
  Scenario: Select tomorrow's date from Time Machine
    When I click on Time Machine
    And I select tomorrow date
    And I verify selected date is not clickable
    Then I verify date is displayed in correct format