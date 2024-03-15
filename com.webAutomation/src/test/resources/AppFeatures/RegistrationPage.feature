Feature: User Registration

  Scenario: Enter User Registration details
    Given User is on Registration page
    When User verify the Registration page title
    When User click on Register link
    And User enter the following registration details
      | FirstName | LastName | Email                   | PhoneNo    | Password     | ConfirmPassword |
      | Rajul93   | Gupta93 | rajulgupta93@gmail.com | 7498393048 | Welcome@1234 | Welcome@1234    |
    And User selects the TimeZone from drop-down
    And User click on Register button
    Then User registration should be successfull
