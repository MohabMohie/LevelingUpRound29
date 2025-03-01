package pomTestPackage.traditional;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import w3schools.traditional.Tables;

import java.time.Duration;

@Test public class W3SchoolsTableTests {
    private WebDriver driver;
    private Tables tables;

    public void checkContactNameForErnstHandelInAustria(){
        tables.navigate();
        String contactNameText = tables.getContactNameUsingCompanyAndCountry("Ernst Handel", "Austria");
        Assert.assertEquals(contactNameText, "Roland Mendel");
    }

    public void checkContactNameForAlfredsFutterkisteInGermany(){
        tables.navigate();
        String contactNameText = tables.getContactNameUsingCompanyAndCountry("Alfreds Futterkiste", "Germany");
        Assert.assertEquals(contactNameText, "Maria Anders");
    }

    @BeforeMethod
    public void beforeMethod(){
        // setup
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE).addArguments("start-maximized").setImplicitWaitTimeout(Duration.ofSeconds(5));
        driver = new ChromeDriver(options);
        tables = new Tables(driver);
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }

}
