Feature: User should be able to buy roundtrip tickets
  @roundtrip
  Scenario: Searching for roundtrip flight
    Given user is on the main page
    Then user clicks on more travel dropdown and clicks Flights
    And user clicks on Leaving from button and User enters "San Francisco"
    And user clicks on Going to button and User enters "New York"
    And user click on Departing button and User chooses Departing and Returning date
    And user clicks on Search button and User sees search results contain "San Francisco" and "New York"
    And User click on nonstop for departure flights
    And User sorts for most expensive departure ticket and selects that ticket
    And User click on nonstop for returning flights
    And User sorts for most expensive returning ticket and continue to review page
    And User sees the flight information is correct
