import Pages.LandingPage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.lang.model.element.Name;

public class LoginTests extends BaseTest {
    private LoginPage loginPage;
    private LandingPage landingPage;

    @DataProvider(name = "InvalidLoginData")
    public Object[][] invalidLoginDataProvider(){
        Object[][] invalidLoginData = new Object[2][2];

        /* *******for getting data from exel sheet******************************/

        // using apachePOI define the path of exel sheet
        // using apachePOI get data under email column     get array

        //Object[][] invalidLoginData = new Object[based on number of data][2];

        // for loop based on number of data
//        invalidLoginData[i][0] = data under email column[i]  ;
//        invalidLoginData[i][1] = data under password column[i];
        //
        // }
        invalidLoginData[0][0] = "aligika22@gmail.com";
        invalidLoginData[0][1] = "aesedgghy";

        invalidLoginData[1][0] = "ahmedawaga43@gmail.com";
        invalidLoginData[1][1] = "123456789";




        return invalidLoginData;
    }

    @DataProvider(name = "validLoginData")
    public Object[][] validLoginDataProvider(){
        Object[][] validLoginData = new Object[2][2];

        validLoginData[0][0] = "su1304117@su.edu.eg";
        validLoginData[0][1] = "5377353773";

        validLoginData[1][0] = "aligika22@gmail.com";
        validLoginData[1][1] = "5377353773";


        return validLoginData;
    }
//    @Test(priority = 0,dataProvider = "validLoginData")      // 0 is top
    @Test(dataProvider = "validLoginData")      // 0 is top
    public void LoginWithValidCredentials(String email, String password){
        loginPage = homePage.ClickOnLoginButton();
        loginPage.enterEmail(email);
        loginPage.EnterPassword(password);
        landingPage = loginPage.ClickOnLoginButtonInCaseValidCredentials();
        landingPage.waitUntilLoadingPageDisappear();     // for loading in page
        landingPage.clickOnProfileButton();
        String userEmail = landingPage.getUserEmailFromProfileMenu();
        Assert.assertEquals(userEmail,email,"Email Of Logged in User don't match");
        homePage = landingPage.ClickOnLogoutButton_InsidePopUp();


    }
     //@Test(priority = 1,dataProvider = "InvalidLoginData")
    @Test(dataProvider = "InvalidLoginData")
    public void LoginWithInValidCredentials(String email, String password){
        loginPage = homePage.ClickOnLoginButton();
        loginPage.enterEmail(email);
        loginPage.EnterPassword(password);
        loginPage.ClickOnLoginButtonInCaseInValidCredentials();
        // don't use Ever
//        try{
//            Thread.sleep(10000);
//        }catch (Exception e){
//            System.out.println(e);
//        }

        String errorMsg = loginPage.getLoginErrorMessage();
        Assert.assertEquals(errorMsg,"Wrong email or password.","Error Msg didn't Appear Correctly");
        homePage.navigateBaseUrl();
    }
//    @AfterMethod
//    public void afterMethod(){
//        homePage.navigateBaseUrl();
//    }
}
