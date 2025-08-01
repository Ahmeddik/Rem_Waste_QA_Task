package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage {


    public By taskField = By.xpath("//input[@placeholder='What do you want to do?']");

    public By taskNameCheckbox(String taskName) {
        By taskCheckBox = By.xpath("//li[(del[text()='" + taskName + "'] or text()[normalize-space()='" + taskName + "'])]/input[@type='checkbox']");
        return taskCheckBox;
    }

    public By deleteCheckboxButton(String taskName) {
        By deleteCheckBox = By.xpath("//li[(del[text()='" + taskName + "'] or normalize-space(text())='" + taskName + "')]/button");
        return deleteCheckBox;
    }


    public void insertTask(String taskName) {
        insertInTextField(taskField, taskName);
    }

    public boolean checkBoxStatus(String taskName) {
        WebElement checkBoxStatus = driver.findElement(taskNameCheckbox(taskName));
        boolean isTaskCheckBoxChecked = checkBoxStatus.isSelected();
        return isTaskCheckBoxChecked;
    }

    public void checkTaskToBeDone(String taskName) {
        clickOnButton(taskNameCheckbox(taskName));
    }

    public void deleteTask(String taskName) {
        clickOnButton(deleteCheckboxButton(taskName));
    }

    public boolean checkIfTaskExists(String taskName) {
        List<WebElement> taskList = driver.findElements(By.xpath("//ul/li"));

        boolean taskFound = false;

        for (WebElement task : taskList) {
            String text = task.getText().trim();
            if (text.contains(taskName)) {
                taskFound = true;
                return taskFound;
            }
        }
        return false;
    }
}