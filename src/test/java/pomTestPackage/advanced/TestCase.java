package pomTestPackage.advanced;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class TestCase {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        // setup
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE).addArguments("start-maximized").setImplicitWaitTimeout(Duration.ofSeconds(5));
        driver = new ChromeDriver(options);
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
}
