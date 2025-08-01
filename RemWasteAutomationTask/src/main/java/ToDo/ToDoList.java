package ToDo;

import Pages.HomePage;
import Pages.LogInPage;
import Pages.NavigationBar;
import Pages.RegisterPage;

public class ToDoList {
    public HomePage homePage;
    public LogInPage logInPage;
    public RegisterPage registerPage;
    public NavigationBar navigationBar;

    public ToDoList(){

        homePage = new HomePage();
        logInPage = new LogInPage();
        registerPage = new RegisterPage();
        navigationBar = new NavigationBar();
    }
}
