//package ToDoList;
//
//import browser.Browser;
//import driver.WebDriverSingleton;
//
//public class BaseTest {
//    protected WebDriverSingleton driver;
//    protected static Browser browser = new Browser();
//    protected PropertiesReader propertiesReader = new PropertiesReader("D:\\New folder\\RemWasteAutomationTask\\src\\main\\resources\\data.properties");
//    String url = "http://localhost:3000";
//
//    public BaseTest(){
//        driver = WebDriverSingleton.getDriverSingleton();
//    }
//
//}
package ToDoList;

import browser.Browser;
import driver.WebDriverSingleton;
import utils.PropertiesReader;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected static WebDriver driver;
    protected static Browser browser;
    protected PropertiesReader propertiesReader;
    protected String url;

    public BaseTest() {
        driver = WebDriverSingleton.getDriver(); // Correct static method
        browser = new Browser(); // Browser initializes your page objects
        propertiesReader = new PropertiesReader("src/main/resources/data.properties");
        url = "http://localhost:3000";
    }
}
