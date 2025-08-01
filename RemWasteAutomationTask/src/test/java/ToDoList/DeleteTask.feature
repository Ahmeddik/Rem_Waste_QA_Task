Feature: Delete a task from the ToDo List
  As A User
  I want to click on the delete button
  In order to delete a task from the ToDo List

  @ToDoList
  Scenario Outline: Delete a task from the ToDo List
    Given Customer logged in his account with "<loginEmail>" and "<loginPassword>"
    When Clicking on delete button next to a "<task>"
    Then The "<task>" is deleted from the ToDo List

    Examples:
      |loginEmail|loginPassword|task        |
      |logInEmail|logInPassword|taskToDelete|