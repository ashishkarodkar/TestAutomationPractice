Feature: Account Page Feature

  Background: 
    Given user is already logged in to application
      | username                  | password  |
      | ashish.karodkar@gmail.com | Test@1234 |

  Scenario: Accounts page title
    Given user is on Accounts page
    When user get title of the page
    Then page title should be "My account - My Store"

  Scenario: Accounts section count
    Given user is on Accounts page
    Then user gets Accounts section
      | ORDER HISTORY AND DETAILS |
      | MY CREDIT SLIPS           |
      | MY ADDRESSES              |
      | MY PERSONAL INFORMATION   |
      | MY WISHLISTS              |
    And accounts section count should be 5
