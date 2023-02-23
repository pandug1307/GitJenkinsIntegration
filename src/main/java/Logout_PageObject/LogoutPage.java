package Logout_PageObject;

import CommonPage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage extends BasePage {
    public LogoutPage(WebDriver driver){super(driver);}

    //Locators
    public By Menudropdown= By.xpath("//span[@class='hidden-xs']");
    public By btnSignout= By.xpath("//a[@href='javascript:void(0)' and text()=' Sign Out']");

    //Locators Method
    public boolean verifyLogoutPage() throws InterruptedException {
        try{
            WebElement menu= (new WebDriverWait(driver, 20))
                    .until(ExpectedConditions.presenceOfElementLocated(Menudropdown));
            menu.click();

            WebElement btnsignout= (new WebDriverWait(driver,20))
                    .until(ExpectedConditions.presenceOfElementLocated(btnSignout));
            btnsignout.click();

            return true;

        }catch (Exception e){
            return false;

        }
    }

}