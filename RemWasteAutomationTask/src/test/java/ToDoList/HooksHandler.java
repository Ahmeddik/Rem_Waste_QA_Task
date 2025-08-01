
package ToDoList;

import driver.WebDriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HooksHandler {

    @Before
    public void setUp() {
        WebDriverSingleton.getDriver().get("http://localhost:3000");
    }

    @After
    public void tearDown() {
        WebDriverSingleton.quitDriver();
    }
}
