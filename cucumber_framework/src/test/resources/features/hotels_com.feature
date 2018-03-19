@regression @Hotels_com

  Feature: Hotel Search on Hotels.com

    @hotel_search
    Scenario: Verify user is able to search for hotels
      Given I am on hotels.com
      And I type in Minnesota
      And I click Minnesota City from auto suggest box
      And I check in for 6 days starting tomorrow
      And I select 2 adults and 2 children
      And I select ages 2 and 4 for the children
      Then I am able to search for hotels
