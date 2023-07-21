package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage {
    private By profileImgButtonInsideHeder = By.xpath("//button[@aria-haspopup='menu']//img");
    private By profileMenu = By.xpath("//div[@aria-label='Settings menu']");
    private By emailTextField_InsideProfileMenuPopup = By.xpath("//p[@class='user_menu_email']");
    private By logoutButtonInsideProfileMenu
            = By.xpath("//div[@data-testid='user_menu_version']/preceding::span[@class='user_menu_label'][1]");
    private By loadingPageLocator = By.xpath("//div[@id='loading']");
    public LandingPage(WebDriver driver){
        super(driver);

    }
    public void waitUntilLoadingPageDisappear(){
        wait.waitForVisibility_lazyWait(loadingPageLocator);
        wait.waitForElementNotToBePresent(loadingPageLocator);
    }

    public void clickOnProfileButton(){
        elementActions.ClickOnElement(profileImgButtonInsideHeder);
        wait.waitForVisibility_lazyWait(profileMenu);
        //wait.WaitForVisibility(profileMenu);           // double check
    }
    public String getUserEmailFromProfileMenu(){
        return elementActions.getTextFromElement(emailTextField_InsideProfileMenuPopup);
    }

    public HomePage ClickOnLogoutButton_InsidePopUp(){
        elementActions.ClickOnElement(logoutButtonInsideProfileMenu);
        return new HomePage(driver);
    }
}
