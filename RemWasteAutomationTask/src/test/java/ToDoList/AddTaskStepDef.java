package ToDoList;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AddTaskStepDef extends BaseTest{

    @Given("Customer logged in his account with {string} and {string}")
    public void customerLoggedInHisAccountWithLoginEmailAndLoginPassword(String email, String password){

        email = propertiesReader.getProperty("logInEmail");
        password = propertiesReader.getProperty("logInPassword");

        browser.toDoList.navigationBar.openLogInPage();
        browser.toDoList.logInPage.insertEmailAndPassword(email,password);
        browser.toDoList.logInPage.clickOnLogInButton();
    }

    @When ("Adding {string} to the ToDo List and press enter")
    public void whenAddingTaskToTheToDoListAndPressEnter(String task){
        task = propertiesReader.getProperty("addingTask");
        browser.toDoList.homePage.insertTask(task);
        browser.toDoList.homePage.pressEnter(browser.toDoList.homePage.taskField);
    }

    @Then("The {string} is added to the ToDo List")
    public void AnItemIsAddedYoTheToDoList(String task){
        task = propertiesReader.getProperty("addingTask");
        WebElement taskCheckBox = browser.toDoList.homePage.findElement(browser.toDoList.homePage.taskNameCheckbox(task));
        Assert.assertFalse(taskCheckBox.isSelected());
    }

    @When ("Clicking on the checkbox of a {string}")
    public void clickingOnTheCheckboxOfATask(String task){
        task = propertiesReader.getProperty("taskName");
        browser.toDoList.homePage.checkTaskToBeDone(task);
    }

    @Then("{string} status change to be done")
    public void tasksStatusChangeToDoneOrNotDone(String task){
        task = propertiesReader.getProperty("addingTask");
        boolean checkBoxStatus = browser.toDoList.homePage.checkBoxStatus(task);
        Assert.assertTrue(checkBoxStatus,"Task is not Done");
    }
}
