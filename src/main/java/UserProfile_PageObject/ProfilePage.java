package UserProfile_PageObject;

import CommonPage.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.element.Element;
import javax.swing.*;
import java.util.List;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver driver){super(driver);}

    //Locators

    public By Menudropdown= By.xpath("//span[@class='hidden-xs']");
    public By Profile= By.xpath("//a[@routerlink='/user-profile']");
    public By Progressbar= By.xpath("//*[contains(@role,'progressbar')]");
    public By txtboxfname= By.xpath("//input[@formcontrolname='firstName']");
    public By txtboxlname= By.xpath("//input[@formcontrolname='lastName']");
    public By txtboxphone= By.xpath("//input[@formcontrolname='phoneNo']");

    public By companydropdown= By.xpath("//*[contains(@placeholder, 'Please Select Companies')]");
    public By companyList= By.xpath("//div[contains(@role, 'listbox')]");
    public By companyName= By.xpath("//span[contains(text(),'Organization_1')]");

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

            Thread.sleep(4000);
//            WebDriverWait wait = new WebDriverWait(driver, 30);
//            wait.until(ExpectedConditions.invisibilityOfElementLocated(Progressbar));

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

    public boolean updateCompanydetail() throws InterruptedException {
        try{

            WebElement cmpnyDrpdwn= (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.presenceOfElementLocated(companydropdown));
            cmpnyDrpdwn.click();

            List<WebElement> list= driver.findElements(companyList);
            for (WebElement element:list){
                System.out.println("List of company:\n" +element.getText());
                WebElement element1= (new WebDriverWait(driver,10))
                        .until(ExpectedConditions.visibilityOfElementLocated(companyName));
                element1.click();
                Thread.sleep(2000);

                WebElement phonetxtbxfield= new WebDriverWait(driver, 10)
                        .until(ExpectedConditions.presenceOfElementLocated(txtboxphone));

                Actions action= new Actions(driver);
               action.sendKeys(phonetxtbxfield, "1234567890").build().perform();
            }

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