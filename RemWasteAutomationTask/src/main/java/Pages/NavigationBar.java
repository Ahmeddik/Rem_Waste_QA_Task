package Pages;

import org.openqa.selenium.By;

public class NavigationBar extends BasePage{
    public By homePageButtonPage = By.xpath("//a[contains(.,'Home')]");
    public By logInButtonPage = By.xpath("//a[contains(.,'Login')]");
    public By registerButtonPage = By.xpath("//a[contains(.,'Register')]");

    public void openHomePage(){
        clickOnButton(homePageButtonPage);
    }
    public void openLogInPage(){
        clickOnButton(logInButtonPage);
    }
    public void openRegisterPage(){
        clickOnButton(registerButtonPage);
    }
}
