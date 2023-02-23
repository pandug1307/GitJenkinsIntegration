package UserProfile_PageObject;

import CommonPage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.tools.tree.NewArrayExpression;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver driver){super(driver);}

    //Locators

    public By Menudropdown= By.xpath("//span[@class='hidden-xs']");
    public By Profile= By.xpath("//a[@routerlink='/user-profile']");
    public By txtboxfname= By.xpath("//input[@formcontrolname='firstName']");
    public By txtboxlname= By.xpath("//input[@formcontrolname='lastName']");
    //public By btnSave= By.xpath("//span[@class='mat-button-wrapper' and text()='SAVE']");

    //Locators method

    public boolean clickProfile() throws InterruptedException{
        try{

            WebElement menu= (new WebDriverWait(driver, 20))
                    .until(ExpectedConditions.presenceOfElementLocated(Menudropdown));
            menu.click();

            WebElement profile= (new WebDriverWait(driver, 20))
                    .until(ExpectedConditions.presenceOfElementLocated(Profile));
            profile.click();

            return true;

        }catch (Exception e){
            return false;
        }
    }

    public boolean updateProfiledetail(String firstname, String lastname) throws InterruptedException{
        try{

            WebElement fname= (new WebDriverWait(driver,20))
                    .until(ExpectedConditions.presenceOfElementLocated(txtboxfname));
            fname.clear();
            fname.sendKeys(firstname);

            WebElement lname= (new WebDriverWait(driver,20))
                    .until(ExpectedConditions.presenceOfElementLocated(txtboxlname));
            lname.clear();
            lname.sendKeys(lastname);

            return true;

        }catch (Exception e){
            return false;
        }
    }

    public boolean btnSubmit() throws InterruptedException{
        try{

            WebElement btnSave= driver.findElement(By.xpath("//span[@class='mat-button-wrapper' and text()='SAVE']"));
            if (btnSave.isEnabled()) {
                btnSave.click();
                System.out.println("Profile updated successfully");
            }
            else {
                System.out.println("Save button seeing disabled");
            }
            return true;

        }catch (Exception e){
            return false;
        }
    }

    public boolean Profileupdatemsg() throws InterruptedException{
        try {

            String msg= driver.findElement(By.xpath("")).getText();
            System.out.println(msg);

            return true;

        }catch (Exception e){
            return false;

        }
    }
}