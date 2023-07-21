package Pages;

import net.bytebuddy.ByteBuddy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ElementActions;
import utils.waits;

import java.time.Duration;

public class LoginPage extends BasePage {

    By EmailTextFieldLocator = By.xpath("//input[@id='element-0']");
    By PasswordTextFieldLocator = By.xpath("//input[@id='element-3']");
    By LoginButtonLocator = By.xpath("//button[@type='submit']");
    By errorMessageLocator = By.xpath("//form/div[not(div/span)]");


    // locators

    public LoginPage(WebDriver driver){
        super(driver);
    }


    // method
    public void enterEmail(String Email){
        // waits
       elementActions.sendStringToField(EmailTextFieldLocator,Email);

    }
    public void EnterPassword(String password){
        elementActions.sendStringToField(PasswordTextFieldLocator,password);

    }
    public LandingPage ClickOnLoginButtonInCaseValidCredentials(){
        elementActions.ClickOnElement(LoginButtonLocator);
        return new LandingPage(driver);
    }
    public void ClickOnLoginButtonInCaseInValidCredentials(){
        elementActions.ClickOnElement(LoginButtonLocator);
    }
    public String getLoginErrorMessage(){
      return elementActions.getTextFromElement(errorMessageLocator);
    }

}
