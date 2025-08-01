package ToDoList;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class LogInStepDef extends BaseTest {

    @Given("User inserts correct {string} and {string}")
    public void User_inserts_correct_email_and_password(String email, String password){

        email = propertiesReader.getProperty("logInEmail");
        password = propertiesReader.getProperty("logInPassword");
        browser.toDoList.navigationBar.openLogInPage();
        browser.toDoList.logInPage.insertEmailAndPassword(email,password);
    }

    @When("User presses log in button")
    public void User_presses_log_in_button(){
        browser.toDoList.logInPage.clickOnLogInButton();
    }

    @Then("User is redirected to the home page")
    public void User_is_redirected_to_the_home_page(){
        WebElement addTaskField = browser.toDoList.homePage.findElement(browser.toDoList.homePage.taskField);
        Assert.assertTrue(addTaskField.isDisplayed(),"Log in failed");
    }
}
