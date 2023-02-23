package CommonPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;

    @Parameters({"browsername", "localDriverpath", "url"})

    @BeforeClass
    public void Setup(String browsername, String localDriverpath, String url) throws InterruptedException{

        if (browsername.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", localDriverpath);
            driver= new ChromeDriver();
        }else if(browsername.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", localDriverpath);
            driver= new FirefoxDriver();
        }else {
            System.out.println("Do not found any browser.");
        }

        this.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        this.driver.manage().window().maximize();
        driver.navigate().to(url);
    }

    @AfterClass
    public void Terminate(){
        driver.close();
        System.out.println("Browser closed successfully.");
    }
}