package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementActions {
    private WebDriver driver;
    private waits wait;

    //  Constructor
    public ElementActions(WebDriver driver){
        this.driver = driver;
        wait = new waits(driver);
    }
    // action method

    public WebElement retrieveElement(By locator){
        // waits for present
        wait.WaitForPresents(locator);
        return driver.findElement(locator);

    }
    public void ClickOnElement(By locator){
        // scroll to the element
        scrollElementToView(locator);
        wait.WaitForClickbility(locator);
        //driver.findElement(locator).click();
        retrieveElement(locator).click();

    }
    public void ClickOnElement(WebElement element){
        // scroll to the element
        scrollElementToView(element);
        wait.WaitForClickbility(element);
        //driver.findElement(locator).click();
        element.click();                                  //don't need to retrieve

    }
    public void sendStringToField(By locator, String string){
        // scroll to the element
        scrollElementToView(locator);
        wait.WaitForClickbility(locator);
        retrieveElement(locator).sendKeys(string);
    }
    public void sendStringToField(WebElement element, String string){
        // scroll to the element
        scrollElementToView(element);
        wait.WaitForClickbility(element);
        element.sendKeys(string);
    }
    public void scrollElementToView(By locator){
        WebElement element = retrieveElement(locator);
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor)driver).executeScript(script,element);
    }
    public void scrollElementToView(WebElement element){
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor)driver).executeScript(script,element);
    }
    public String getTextFromElement(By locator){
        scrollElementToView(locator);
        wait.WaitForVisibility(locator);
        String errorMsg = retrieveElement(locator).getText();
        return errorMsg;
    }
    public String getTextFromElement(WebElement element){
        scrollElementToView(element);

        wait.WaitForVisibility(element);
        String errorMsg = element.getText();
        return errorMsg;
    }



}
