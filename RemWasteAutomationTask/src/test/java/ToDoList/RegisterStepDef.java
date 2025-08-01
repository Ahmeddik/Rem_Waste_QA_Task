package ToDoList;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class RegisterStepDef extends BaseTest{

    @Given("User presses on register button")
    public void userPressesOnRegisterButton(){
        browser.toDoList.navigationBar.openRegisterPage();
    }

    @When("User inserts valid {string} and {string}")
    public void UserInsertsValidEmailAndPassword(String email,String password){
        email = propertiesReader.getProperty("registerEmail");
        password = propertiesReader.getProperty("registerPassword");
        browser.toDoList.registerPage.register(email,password);

    }

    @Then("User redirected to the home page")
    public void User_redirected_to_the_home_page(){
        WebElement addTaskField = browser.toDoList.homePage.findElement(browser.toDoList.homePage.taskField);
        Assert.assertTrue(addTaskField.isDisplayed(),"Registration failed");
    }
}
