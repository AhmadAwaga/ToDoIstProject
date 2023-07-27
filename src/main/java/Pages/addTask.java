package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class addTask extends BasePage{
    // locators
    private By addTaskButton = By.xpath("//button[@id='quick_add_task_holder']");
    public addTask(WebDriver driver){
        super(driver);
    }

    // methods
    public void clickOnAddTaskButton(){
        elementActions.ClickOnElement(addTaskButton);
    }
}
