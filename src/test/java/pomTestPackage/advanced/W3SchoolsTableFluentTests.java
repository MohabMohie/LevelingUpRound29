package pomTestPackage.advanced;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import w3schools.advanced.FluentTables;

import java.time.Duration;

@Test public class W3SchoolsTableFluentTests {
    private WebDriver driver;

    public void checkContactNameForErnstHandelInAustria(){
        String contactNameText = new FluentTables(driver).navigate().getContactNameUsingCompanyAndCountry("Ernst Handel", "Austria");
        Assert.assertEquals(contactNameText, "Roland Mendel");
    }

    public void checkContactNameForAlfredsFutterkisteInGermany(){
        String contactNameText = new FluentTables(driver).navigate().getContactNameUsingCompanyAndCountry("Alfreds Futterkiste", "Germany");
        Assert.assertEquals(contactNameText, "Maria Anders");
    }

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
