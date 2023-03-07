package Login_PageObject;

import CommonPage.BasePage;
import CommonPage.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver){super(driver);}
    public ExtentReports extentReports;
    public ExtentTest extentTest;

    //Locators
    public By Msg= By.xpath("//body//app-root//h2[1]");
    public By txtemailAddress= By.xpath("//input[@id='mat-input-0']");
    public By txtPasswrd= By.xpath("//input[@id='mat-input-1']");
    public By chckbxRememberMe= By.xpath("//span[@class='mat-checkbox-inner-container']");
    public By btnSignIn= By.xpath("//span[@class='mat-button-wrapper' and text()='Sign In']");

    //Locators Method
    public boolean verifyLoginPage(By username, String email, By pass, String passwd) throws InterruptedException{
        try{

            WebElement welcmeTxtmsg= (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(Msg));
            System.out.println(welcmeTxtmsg.getText());

            WebElement emailaddress= (new WebDriverWait(driver,10))
                    .until(ExpectedConditions.presenceOfElementLocated(username));
            emailaddress.sendKeys(email);

            WebElement Passwd= (new WebDriverWait(driver,10))
                    .until(ExpectedConditions.presenceOfElementLocated(pass));
            Passwd.sendKeys(passwd);

            WebElement RememberMe= (new WebDriverWait(driver,10))
                    .until(ExpectedConditions.presenceOfElementLocated(chckbxRememberMe));
            RememberMe.click();

            WebElement btnSignin= (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.presenceOfElementLocated(btnSignIn));
            btnSignin.click();

//            WebElement btnSign= driver.findElement(By.xpath("//span[@class='mat-button-wrapper' and text()='Sign In']"));
//            if (btnSign.click();){
//                System.out.println();
//            }

           return true;

        }catch (Exception e){
            return false;

        }
    }

    public boolean getLoggedinmsg() throws InterruptedException{
        try {

            WebElement failureMsg= driver.findElement(By.xpath("//div[@role='alertdialog']"));
            if (failureMsg.isDisplayed() == true) {
                System.out.println(failureMsg.getText());
                extentTest.info("Unknown error");

        }else {
                WebElement successMsg= driver.findElement(By.xpath("//div[@class='ng-tns-c8-2 ng-star-inserted ng-trigger ng-trigger-flyInOut ngx-toastr toast-success']"));
                System.out.println(successMsg.getText());
                extentTest.info("Login successfully");
        }

        return true;

    }catch (Exception e){
            return false;

        }
    }
}