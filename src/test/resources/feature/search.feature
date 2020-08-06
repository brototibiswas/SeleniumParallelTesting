Feature: Search in Google

  Scenario Outline: Search in Google and open in new tab
    Given User navigates to <url>
    And Searches for a <term>
    Then User clicks on the third result
    And User should be able to open in a new tab
    Examples:
      | url                       | term   |
      | "https://www.google.com/" | "cat" |
      | "https://www.youtube.com/" | "cat" |