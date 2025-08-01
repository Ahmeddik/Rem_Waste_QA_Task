package Pages;

import org.openqa.selenium.By;

public class LogInPage extends BasePage{
    public By emailField = By.xpath("//input[@type='email']");
    public By passWordField = By.xpath("//input[@type='password']");
    public By logInButton = By.xpath("//button[contains(.,'log in')]");

    public void insertEmailAndPassword(String email, String passWord){
        insertInTextField(emailField,email);
        insertInTextField(passWordField,passWord);
    }

    public void clickOnLogInButton(){
        clickOnButton(logInButton);
    }

}
