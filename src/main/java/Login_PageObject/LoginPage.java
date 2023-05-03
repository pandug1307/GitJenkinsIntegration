package Login_PageObject;

import CommonPage.BasePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    public By loginMsg= By.xpath("//div[contains(@role,'alertdialog')]");
    //public By loggedinUser= By.xpath("//span[@class='hidden-xs']");
    //public By pageLoader= By.xpath("//mat-spinner[@role='progressbar']");

    //Locators Methoda
    public boolean verifyLoginPage(By username, String email, By pass, String passwd) {
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

            JavascriptExecutor jse = (JavascriptExecutor)driver;
            WebElement successMsg= driver.findElement(loginMsg);
            jse.executeScript("return arguments[0].text", successMsg);
            String toastMsg= "Login Successful.";

            if (toastMsg.contains(successMsg.getText())) {
                System.out.println(successMsg.getText());
                return true;

            }else {
                System.out.println(successMsg.getText());
                return false;
            }

        }catch (NoSuchElementException e){
            throw e;
        }
    }
}