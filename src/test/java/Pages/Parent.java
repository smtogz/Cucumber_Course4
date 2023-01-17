package Pages;

import Utilities.GWD;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class Parent {
    WebDriverWait wait=new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(5));
    public void sendKeysFunction(WebElement element,String value){
        waitUntilVisibile(element);
        scrollToElement(element);
        element.clear();
        element.sendKeys(value);
    }
    public void verifyContainsTextFunction(WebElement element,String value){
       // waitUntilVisibile(element);
        wait.until(ExpectedConditions.textToBePresentInElement(element,value));
        Assert.assertTrue(element.getText().toLowerCase().contains(value.toLowerCase()),"the text could not be found");
        new Actions(GWD.getDriver()).sendKeys(Keys.ESCAPE).perform();
    }
    public void clickFunction(WebElement element){
        waitUntilToBeClickable(element);
        scrollToElement(element);
        element.click();
    }
    public void waitUntilVisibile(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitUntilToBeClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void scrollToElement(WebElement element){
        JavascriptExecutor js=(JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView();",element);
    }
    public void waitUntilLoading()
    {
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("fuse-progress-bar > *"), 0));
        // progressbar ın çocukları
    }
}
