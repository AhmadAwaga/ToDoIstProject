package Pages;

import org.openqa.selenium.WebDriver;
import utils.ElementActions;
import utils.waits;

public class BasePage {
    private String baseURL = "https://todoist.com/";
    protected WebDriver driver;
    protected waits wait;
    protected ElementActions elementActions;

    // constructor
    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new waits(driver);
        elementActions = new ElementActions(driver);
    }

    public void navigateBaseUrl(){
        driver.get(baseURL);
    }
    public void MaximizeWindow(){
        driver.manage().window().maximize();
    }
}
