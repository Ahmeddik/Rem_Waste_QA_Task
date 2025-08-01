Feature: LogIn to my ToDo List
  As A User
  I want to log in to my account
  In order to add task to my ToDo List

  @ToDoList
  Scenario Outline: Log in to my ToDo List
    Given User inserts correct "<email>" and "<password>"
    When User presses log in button
    Then User is redirected to the home page

    Examples:
      |email     |password     |
      |logInEmail|logInPassword|
