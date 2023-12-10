Feature: Login Feature
  Verify if user is able to Login in to the site

Background: This is a functionality in cucumber to run the common step first
	Given user navigates to Login Page

  Scenario: Login as an authenticated user
    When user enters username "admin"
    And user enters password "admin"
    And user clicks on submit button
    Then success message is displayed
    
  Scenario Outline: Verify user is able to test login functionality for multiple use
    When user enters username "<username>"
    And user enters password "<password>"
    And user clicks on submit button
    Then success message is displayed
    Examples:
			| username  | password | 
      | admin		  |  admin   | 
      | test      |  test    | 
      | user1     |  pass123 |
      
    
