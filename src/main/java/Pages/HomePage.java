package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ElementActions;
import utils.waits;

import java.time.Duration;

public class HomePage extends BasePage{

    // locators
    private By LoginButtonLocator = By.xpath("//ul//a[@href='/auth/login']");


    // constructor
    public HomePage(WebDriver driver){
       super(driver);
    }

    // method
    public LoginPage ClickOnLoginButton(){

        elementActions.ClickOnElement(LoginButtonLocator);
        // go to login page
        LoginPage loginPage = new LoginPage(driver);
        return loginPage;

    }
}
