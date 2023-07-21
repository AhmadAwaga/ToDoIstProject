package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class waits {
     private WebDriver driver;
    private  WebDriverWait wait;
    private  WebDriverWait wait_lazy;

     public waits(WebDriver driver){
         this.driver = driver;
          wait = new WebDriverWait(driver, Duration.ofSeconds(5));
          // mints
         wait_lazy = new WebDriverWait(driver, Duration.ofSeconds(60));

     }

     public void WaitForClickbility(By locator){
         try{
             wait.until(ExpectedConditions.elementToBeClickable(locator));
         }
         catch (Exception e){
             System.out.println(e);
         }

     }
    public void WaitForClickbility(WebElement element){
        try{
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }
        catch (Exception e){
            System.out.println(e);
        }

    }
    public void WaitForClickbility_lazyWait(By locator){
        try{
            wait.until(ExpectedConditions.elementToBeClickable(locator));
        }
        catch (Exception e){
            System.out.println(e);
        }

    }
    public void WaitForVisibility(By locator){
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated((locator)));
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public void WaitForVisibility(WebElement element){
        try{
            wait.until(ExpectedConditions.visibilityOf(element));
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public void WaitForPresents(By locator){
        try{
           wait_lazy.until(ExpectedConditions.presenceOfElementLocated(locator));
            //wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void waitForVisibility_lazyWait(By locator){
         try{
             wait_lazy.until(ExpectedConditions.visibilityOfElementLocated(locator));
         }
         catch (Exception e){
             System.out.println(e);
         }
    }
    public void waitForElementNotToBePresent(By locator){
         try {
             // not present
             wait.until(ExpectedConditions.numberOfElementsToBeLessThan(locator, 1));
         }catch (Exception e){
             System.out.println(e);
         }
    }


}
