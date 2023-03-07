package UserProfile_Testcase;

import CommonPage.BaseTest;
import Login_PageObject.LoginPage;
import Logout_PageObject.LogoutPage;
import UserProfile_PageObject.ProfilePage;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserProfileTest extends BaseTest {
    public UserProfileTest(){}
    public UserProfileTest(WebDriver passdriver){driver=passdriver;}

    @Test
    public void verifyUserProfile() throws InterruptedException{

        extentTest= extentReports.createTest("To verify the Login page");
        LoginPage loginPage= new LoginPage(driver);
        extentTest.info("Login with valid credentials");
        loginPage.verifyLoginPage(loginPage.txtemailAddress, "umesh.pandey@softwebsolutions.com", loginPage.txtPasswrd, "Hello@#1234");
        extentTest= extentReports.createTest("to verify the page title");
        Assert.assertEquals(driver.getTitle(), "Allied Packaging Corporation");
        extentTest.log(Status.PASS, "Page title is matched");
        loginPage.getLoggedinmsg();
        extentTest.pass("Login success");
        Thread.sleep(8000);
        extentTest= extentReports.createTest("To verify the User Profile");
        ProfilePage profilePage= new ProfilePage(driver);
        extentTest.info("Select User Profile option");
        profilePage.clickProfile();
        profilePage.updateProfiledetail("UmeshU", "PandeyP");
        extentTest.info("Update user profile detail");
        profilePage.btnSubmit();
        extentTest.pass("Update user profile detail");
        Thread.sleep(2000);
        extentTest= extentReports.createTest("To verify the LogOut");
        LogoutPage logoutPage= new LogoutPage(driver);
        logoutPage.verifyLogoutPage();
        extentTest.pass("Logout success");
    }
}