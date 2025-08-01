Feature: Add task to ToDo List
  As A User
  I want to add a task to ToDo List
  In order to mark and un-mark tasks

  @ToDoList
  Scenario Outline: Add task to ToDo List
    Given Customer logged in his account with "<loginEmail>" and "<loginPassword>"
    When Adding "<task>" to the ToDo List and press enter
    Then The "<task>" is added to the ToDo List

    Examples:
      |loginEmail|loginPassword|task      |
      |logInEmail|logInPassword|addingTask|


  @ToDoList
  Scenario Outline: Check or Uncheck task
    Given Customer logged in his account with "<loginEmail>" and "<loginPassword>"
    When Clicking on the checkbox of a "<task>"
    Then "<task>" status change to be done

    Examples:
      |loginEmail|loginPassword|task    |
      |logInEmail|logInPassword|taskName|
