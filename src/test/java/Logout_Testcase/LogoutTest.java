package Logout_Testcase;

import CommonPage.BaseTest;
import Logout_PageObject.LogoutPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Set;

public class LogoutTest extends BaseTest {
    public LogoutTest(){}
    public LogoutTest (WebDriver passdriver){driver=passdriver;}

    @Test
    public void VerifyLogout() throws InterruptedException {
        LogoutPage logoutPage= new LogoutPage(driver);
        logoutPage.verifyLogoutPage();

    }
}