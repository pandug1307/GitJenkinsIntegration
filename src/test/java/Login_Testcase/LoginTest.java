package Login_Testcase;

import CommonPage.BaseTest;
import Dashboard_PageObject.DashboardPage;
import Login_PageObject.LoginPage;
import Logout_PageObject.LogoutPage;
import UserProfile_PageObject.ProfilePage;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.IDynamicGraph;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

public class LoginTest extends BaseTest {
    public LoginTest(){}
    public LoginTest(WebDriver passdriver){ driver=passdriver;}

    @Test
    public void VerifyLogin() throws InterruptedException, IOException, IndexOutOfBoundsException {

        extentTest= extentReports.createTest("To verify the Login page");
        LoginPage loginPage= new LoginPage(driver);
        extentTest.info("Verify the page tile");
        Assert.assertEquals(driver.getTitle(), "Allied Packaging Corporation");
        extentTest.log(Status.PASS, "Page title is matched");
        //String browserTitle= driver.getTitle();
        //System.out.println(browserTitle);
        extentTest.info("Login with valid credentials");
        loginPage.verifyLoginPage(loginPage.txtemailAddress, "umesh.pandey@softwebsolutions.com", loginPage.txtPasswrd, "Hello@#123");
        Thread.sleep(2000);
        loginPage.getLoggedinmsg();
        extentTest.log(Status.PASS, "Login success");

        extentTest= extentReports.createTest("Verify the Dashboard page");
        DashboardPage dashboardPage= new DashboardPage(driver);
        dashboardPage.verifyDashboardPage();
        extentTest.log(Status.PASS, "Dashboard page is displayed");

//        ProfilePage profilePage= new ProfilePage(driver);
//        profilePage.clickProfile();
//        Thread.sleep(2000);
//        profilePage.updateProfiledetail("UmeshU","PandeyP");
//        profilePage.btnSubmit();

        Thread.sleep(2000);
        extentTest.info("Verify the Logout");
        LogoutPage logoutPage= new LogoutPage(driver);
        logoutPage.verifyLogoutPage();
        extentTest.log(Status.PASS, "Logout success");

        extentTest= extentReports.createTest("Verify to open new Tab window");
        ((JavascriptExecutor) driver).executeScript("window.open('https://qa.iotconnect.io/dashboard','_blank')");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        extentTest.info("new Tab is opened successfully");
        //driver.switchTo().window(tabs.get(0));
        //extentTest.info("back to original window");
    }
}