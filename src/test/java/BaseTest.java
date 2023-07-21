import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class BaseTest {
    // attributes
   private WebDriver driver;
   protected HomePage homePage;


    @Parameters({"browser"})
    @BeforeTest
    public void Setup(@Optional("chrome") String browserName){
        if(browserName.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }

        homePage = new HomePage(driver);
        homePage.navigateBaseUrl();
        homePage.MaximizeWindow();

    }

    @AfterTest
    public void Quit(){
        driver.quit();
    }
}
