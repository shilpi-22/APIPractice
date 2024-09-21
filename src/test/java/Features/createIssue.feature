Feature: Validate Issue functionality in Jira
 
  Scenario: Validate user is able to create issue in Jira
    Given User Create Issue Payload
    When User calls "CreateIssue" API with "Post" http request
    Then the API call should get success message with Status Code 201
    
  Scenario Outline: Validate user is able to create multiple issue in Jira
    Given User Create Issue Payload with "<Description>" and "<Summary>"
    When User calls "CreateIssue" API with "Post" http request
    Then the API call should get success message with Status Code 201
    Examples:
    | Description | Summary |
    | Popup not working | On clicking the buttons present in the pop up it is not working |
    | Arrow keys not working | On pressing the arrow keys for navigation to values it is not working |
    
  # Scenario: Validate user is able to get list of all projects in Jira
  #  Given User Create Issue Payload
   # And User calls "CreateIssue API" with "Post" http request
   # Then the API call should get success message with Status Code 201