package Dashboard_PageObject;

import CommonPage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class DashboardPage extends BasePage {
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    public By pageDashboard = By.xpath("//*[contains(text(),'Dashboard')]//self::h2");

    //Methods
    public boolean verifyDashboardPage() throws IOException {
        try {

            boolean element = driver.findElement(pageDashboard).isDisplayed();
            if (element) {
                System.out.println("Dashboard page is displayed");
            } else {
                System.out.println("Do not found the Dashboard page");
            }
            return true;

        }catch (Exception e){
            return false;
        }
    }
}