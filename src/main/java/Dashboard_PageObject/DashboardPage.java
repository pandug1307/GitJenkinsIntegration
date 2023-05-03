package Dashboard_PageObject;

import CommonPage.BasePage;
import org.openqa.selenium.*;

public class DashboardPage extends BasePage {
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    public By pageDashboard = By.xpath("//*[contains(text(),'Dashboard')]//self::h2");
    //public By pageLoader= By.xpath("//mat-spinner[@role='progressbar']");

    //Methods
    public boolean verifyDashboardPage() {
        try {

            JavascriptExecutor jse = (JavascriptExecutor)driver;
            WebElement element= driver.findElement(pageDashboard);
            jse.executeScript("return arguments[0].text", element);
            String text= "Dashboard";

            if (text.contains(element.getText())) {
                System.out.println(element.getText());
                return true;

            } else {
                System.out.println(element.getText());
                return false;
            }

        }catch (NoSuchElementException e){
            throw e;
        }
    }
}