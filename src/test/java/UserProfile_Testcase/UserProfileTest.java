package UserProfile_Testcase;

import CommonPage.BaseTest;
import Dashboard_PageObject.DashboardPage;
import Login_PageObject.LoginPage;
import Logout_PageObject.LogoutPage;
import UserProfile_PageObject.ProfilePage;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserProfileTest extends BaseTest {
    public UserProfileTest() {
    }

    public UserProfileTest(WebDriver passdriver) {
        driver = passdriver;
    }

    @Test
    public void ValidLogin() {
        extentTest= extentReports.createTest("To verify the Login page");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyValidLogin(loginPage.txtemailAddress, "umesh.pandey@softwebsolutions.com", loginPage.txtPasswrd, "Hello@#123");
        //loginPage.getLoggedinmsg();
        //Thread.sleep(8000);
        extentTest.info("Verify the Dashboard page");
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.verifyDashboardPage();
        extentTest.log(Status.PASS, "Dashboard page is displayed");
    }

    @Test
    public void verifyUserProfile() throws InterruptedException {

        extentTest= extentReports.createTest("To verify the User Profile");
        ProfilePage profilePage= new ProfilePage(driver);
        //extentTest.info("Select User Profile option");
        profilePage.clickProfile();
        profilePage.updateProfiledetail("UmeshU", "PandeyP");
        extentTest.info("Update user profile detail");
        profilePage.updateCompanydetail();
        extentTest.info("Update company profile detail");
        profilePage.btnSubmit();
        extentTest.log(Status.PASS, "User profile success");
    }

    @Test
    public void verifyLogout() {

        //Thread.sleep(5000);
        extentTest= extentReports.createTest("Verify the LogOut");
        LogoutPage logoutPage= new LogoutPage(driver);
        logoutPage.verifyLogoutPage();
        extentTest.log(Status.PASS, "Logout success");
    }
}