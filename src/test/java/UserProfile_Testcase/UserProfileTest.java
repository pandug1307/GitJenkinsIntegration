package UserProfile_Testcase;

import CommonPage.BaseTest;
import Login_PageObject.LoginPage;
import Logout_PageObject.LogoutPage;
import UserProfile_PageObject.ProfilePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class UserProfileTest extends BaseTest {
    public UserProfileTest(){}
    public UserProfileTest(WebDriver passdriver){driver=passdriver;}

    @Test
    public void verifyUserProfile() throws InterruptedException{
        LoginPage loginPage= new LoginPage(driver);
        loginPage.verifyLoginPage(loginPage.txtemailAddress, "umesh.pandey@softwebsolutions.com", loginPage.txtPasswrd, "Hello@#1234");
        loginPage.getLoggedinmsg();
        Thread.sleep(8000);
        ProfilePage profilePage= new ProfilePage(driver);
        profilePage.clickProfile();
        profilePage.updateProfiledetail("UmeshU", "PandeyP");
        profilePage.btnSubmit();
        Thread.sleep(2000);
        LogoutPage logoutPage= new LogoutPage(driver);
        logoutPage.verifyLogoutPage();
    }

}
