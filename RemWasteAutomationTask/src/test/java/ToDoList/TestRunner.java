package ToDoList;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (
        features = "src/test/java/ToDoList",
        glue = "ToDoList",
        tags = "@ToDoList"
)

public class TestRunner extends AbstractTestNGCucumberTests {
}