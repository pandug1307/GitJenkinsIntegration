package Login_Testcase;

import CommonPage.BaseTest;
import Dashboard_PageObject.DashboardPage;
import Login_PageObject.LoginPage;
import Logout_PageObject.LogoutPage;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;

public class LoginTest extends BaseTest {
    public LoginTest(){}
    public LoginTest(WebDriver passdriver){ driver=passdriver;}

    @Test
    public void InValidLogin() {

        extentTest= extentReports.createTest("Verify the InValid Login");
        LoginPage loginPage= new LoginPage(driver);
        extentTest.info("Verify the page tile");
        Assert.assertEquals(driver.getTitle(), "Allied Packaging Corporation");
        extentTest.log(Status.PASS, "Page title is matched");

        //extentTest.info("Verify the InValidLogin");
        boolean result= loginPage.verifyInvalidLogin(loginPage.txtemailAddress, "allied.packagingqa@mailinator.com", loginPage.txtPasswrd, "Softweb123");
        if (result==false) {
            extentTest.log(Status.PASS, "Login succeed");
        }
        else {
            extentTest.log(Status.FAIL, "Login failed");
        }
    }

    @Test
    public void ValidLogin() {

        extentTest= extentReports.createTest("Verify the Valid Login");
        LoginPage loginPage= new LoginPage(driver);
        extentTest.info("Verify the page tile");
        Assert.assertEquals(driver.getTitle(), "Allied Packaging Corporation");
        extentTest.log(Status.PASS, "Page title is matched");

        //extentTest.info("Verify the ValidLogin");
        boolean result= loginPage.verifyValidLogin(loginPage.txtemailAddress, "umesh.pandey@softwebsolutions.com", loginPage.txtPasswrd, "Hello@#123");
        if (result==true) {
            extentTest.log(Status.PASS, "Login succeed");
        }
        else {
            extentTest.log(Status.FAIL, "Login failed");
        }

        DashboardPage dashboardPage= new DashboardPage(driver);
        boolean result1= dashboardPage.verifyDashboardPage();
        if (result1==true) {
            extentTest.log(Status.PASS, "Dashboard page is display");
        }else {
            extentTest.log(Status.FAIL, "Dashboard page do not display");
        }
    }

    @Test
    public void verifyLogout() {

        extentTest= extentReports.createTest("Verify the Logout");
        //Thread.sleep(5000);
        //extentTest.info("Verify the Logout");
        LogoutPage logoutPage= new LogoutPage(driver);
        logoutPage.verifyLogoutPage();
        extentTest.log(Status.PASS, "Logout success");

        //extentTest= extentReports.createTest("Verify to open new Tab window");
        ((JavascriptExecutor) driver).executeScript("window.open('https://qa.iotconnect.io/dashboard','_blank')");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        //extentTest.info("new Tab is opened successfully");
//        driver.switchTo().window(tabs.get(0));
//        extentTest.info("back to original window");
    }
}