package Login_Testcase;

import CommonPage.BaseTest;
import Dashboard_PageObject.DashboardPage;
import Login_PageObject.LoginPage;
import Logout_PageObject.LogoutPage;
import UserProfile_PageObject.ProfilePage;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.IDynamicGraph;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends BaseTest {
    public LoginTest(){}
    public LoginTest(WebDriver passdriver){ driver=passdriver;}

    @Test
    public void VerifyLogin() throws InterruptedException, IOException {

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

        extentTest.info("Verify the Logout");
        LogoutPage logoutPage= new LogoutPage(driver);
        logoutPage.verifyLogoutPage();
        extentTest.log(Status.PASS, "Logout success");
    }
}