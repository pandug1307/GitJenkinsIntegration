package Login_Testcase;

import CommonPage.BaseTest;
import Login_PageObject.LoginPage;
import Logout_PageObject.LogoutPage;
import UserProfile_PageObject.ProfilePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    public LoginTest(){}
    public LoginTest(WebDriver passdriver){ driver=passdriver;}

    @Test
    public void VerifyLogin() throws InterruptedException {
        LoginPage loginPage= new LoginPage(driver);
        String browserTitle= driver.getTitle();
        System.out.println(browserTitle);
        loginPage.verifyLoginPage(loginPage.txtemailAddress, "umesh.pandey@softwebsolutions.com", loginPage.txtPasswrd, "Hello@#1234");
        Thread.sleep(4000);
        loginPage.getLoggedinmsg();
//        ProfilePage profilePage= new ProfilePage(driver);
//        profilePage.clickProfile();
//        Thread.sleep(2000);
//        profilePage.updateProfiledetail("UmeshU","PandeyP");
//        profilePage.btnSubmit();
        LogoutPage logoutPage= new LogoutPage(driver);
        logoutPage.verifyLogoutPage();
    }
}