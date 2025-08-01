package Pages;

import org.openqa.selenium.By;

public class RegisterPage extends BasePage{
    public By emailField = By.xpath("//input[@type='email']");
    public By passWordField = By.xpath("//input[@type='password']");
    public By registerButton = By.xpath("//button[contains(.,'register')]");

    public void register(String email, String passWord){
        insertInTextField(emailField,email);
        insertInTextField(passWordField,passWord);
        clickOnButton(registerButton);
    }
}
