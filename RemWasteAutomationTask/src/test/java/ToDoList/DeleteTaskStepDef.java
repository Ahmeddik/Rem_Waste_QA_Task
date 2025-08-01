package ToDoList;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DeleteTaskStepDef extends BaseTest{

    @When("Clicking on delete button next to a {string}")
    public void clickingOnDeleteButtonNextToATask(String task){
        task = propertiesReader.getProperty("taskToDelete");
        browser.toDoList.homePage.deleteTask(task);
    }

    @Then("The {string} is deleted from the ToDo List")
    public void theTaskIsDeletedFromTheToDoList(String task){
        task = propertiesReader.getProperty("taskToDelete");
//        WebElement taskName = browser.toDoList.homePage.findElement(browser.toDoList.homePage.taskNameCheckbox(task));
        Assert.assertFalse(browser.toDoList.homePage.checkIfTaskExists(task), "Task is not deleted");
    }
}
