package Login_Testcase;

import CommonPage.BaseTest;
import Login_PageObject.LoginPage;
import Logout_PageObject.LogoutPage;
import UserProfile_PageObject.ProfilePage;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.IDynamicGraph;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    public LoginTest(){}
    public LoginTest(WebDriver passdriver){ driver=passdriver;}

    @Test
    public void VerifyLogin() throws InterruptedException {

        extentTest= extentReports.createTest("To verify the Login page");
        LoginPage loginPage= new LoginPage(driver);
        extentTest.info("Verify the page tile");
        Assert.assertEquals(driver.getTitle(), "Allied Packaging Corporation");
        extentTest.log(Status.PASS, "Page title is matched");
        //String browserTitle= driver.getTitle();
        //System.out.println(browserTitle);
        extentTest.info("Login with valid credentials");
        loginPage.verifyLoginPage(loginPage.txtemailAddress, "umesh.pandey@softwebsolutions.com", loginPage.txtPasswrd, "Hello@#1234");
        Thread.sleep(2000);
        loginPage.getLoggedinmsg();
        extentTest.log(Status.PASS, "Login success");

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