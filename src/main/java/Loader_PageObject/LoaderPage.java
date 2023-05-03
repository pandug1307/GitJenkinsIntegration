package Loader_PageObject;

import CommonPage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoaderPage extends BasePage {
    public LoaderPage(WebDriver driver){
        super(driver);
    }

    //Locators
    public By pageLoader= By.xpath("//mat-spinner[@role='progressbar']");

    //Methods

    public boolean Loaderbar() {
        try{

            Boolean pageloader= (new WebDriverWait(driver,60))
                .until(ExpectedConditions.invisibilityOfElementLocated(pageLoader));

    }catch (NoSuchElementException e){
            throw e;
        }
        return true;
    }
}
