Feature: Consuming Services
  I who the automation user
  want to use the RestAssured
  For the consumingServices


  @GetAllUsers
  Scenario: Consuming service rest Get to get all user
    When the user consuming service get
    Then he should see the code response 200

  @CreateUser
  Scenario: Consuming service rest Post to create user
    When the user consuming service post with the data
      | name      | salary | age |
      | Alejandro | 100000 | 100 |
    Then he should see the code response 200

  @GetUser
  Scenario: Consuming service rest Get for one user
    When the user consuming service get whit id 1
    Then he should see the code response 200

  @DeleteUser
  Scenario: Consuming service rest Get for delete one user
    When the user consuming service get for delete whit id 1
    Then he should see the code response 404
