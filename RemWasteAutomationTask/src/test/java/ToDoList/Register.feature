Feature: Registering new account on ToDo List
  As A User
  I want to create new account on ToDo List
  In order to make a ToDo List

  @ToDoList
  Scenario Outline: Register new account on ToDo List
    Given User presses on register button
    When User inserts valid "<email>" and "<password>"
    Then User is redirected to the home page

    Examples:
      |email        |password        |
      |registerEmail|registerPassword|
