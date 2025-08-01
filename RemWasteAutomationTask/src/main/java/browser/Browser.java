package browser;

import ToDo.ToDoList;
import driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;

public class Browser {

    private final WebDriver driver;
    public ToDoList toDoList;

    public Browser() {
        this.driver = WebDriverSingleton.getDriver();
        toDoList = new ToDoList();
    }
}
