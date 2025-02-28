package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

@Test public class W3SchoolsTableTests {
    WebDriver driver;

    public void checkContactNameForErnstHandelInAustria(){
        navigateToW3SchoolsTables();
        String contactNameText = getContactNameUsingCompanyAndCountry("Ernst Handel", "Austria");
        Assert.assertEquals(contactNameText, "Roland Mendel");
    }

    public void checkContactNameForAlfredsFutterkisteInGermany(){
        navigateToW3SchoolsTables();
        String contactNameText = getContactNameUsingCompanyAndCountry("Alfreds Futterkiste", "Germany");
        Assert.assertEquals(contactNameText, "Maria Anders");
    }

    private void navigateToW3SchoolsTables(){
        driver.navigate().to("https://www.w3schools.com/html/html_tables.asp");
    }

    private String getContactNameUsingCompanyAndCountry(String company, String country){
        By contactName = By.xpath("//tr[contains(.,'"+company+"')][contains(.,'"+country+"')]/td[2]");
       return driver.findElement(contactName).getText();
    }

    @BeforeMethod
    public void beforeMethod(){
        // setup
        ChromeOptions options = new ChromeOptions();
        options.enableBiDi().setPageLoadStrategy(PageLoadStrategy.NONE).addArguments("start-maximized").setImplicitWaitTimeout(Duration.ofSeconds(5));
        driver = new ChromeDriver(options);
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }

}
