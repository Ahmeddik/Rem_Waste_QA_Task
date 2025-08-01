package Pages;

import driver.WebDriverSingleton;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    public WebDriver driver = WebDriverSingleton.getDriver();

    Wait wait = new WebDriverWait(driver,Duration.ofSeconds(5));

    public void clickOnButton(By elementLocator){
        waitForElementToBeClickable(elementLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(elementLocator));
    }

    public void insertInTextField(By elementLocator, String text){
        waitForElementToBeClickable(elementLocator);
        driver.findElement(elementLocator).sendKeys(text);

    }

    public void pressEnter(By elementLocator){
        waitForElementToBeClickable(elementLocator);
        driver.findElement(elementLocator).sendKeys(Keys.ENTER);
    }

    public WebElement findElement (By elementLocator){
        waitForElementToBePresented(elementLocator);

        return WebDriverSingleton.getDriver().findElement(elementLocator) ;
    }

    public void waitForElementToBeVisible (By elementLocator){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(elementLocator)));
    }

    public void waitForElementToBeInvisible (By elementLocator){
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(elementLocator)));
    }

    public void waitForElementToBeClickable (By elementLocator){
        wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
    }
    public void waitForElementToBePresented (By elementLocator){
        wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
    }

}
