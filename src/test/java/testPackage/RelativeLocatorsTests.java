package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class RelativeLocatorsTests {
    WebDriver driver;

    @Test
    public void testRelativeLocators(){
        driver.get("https://www.saucedemo.com/");
//        By usernameInput = RelativeLocator.with(By.tagName("input")).below(By.xpath("//div[text()='Swag Labs']"));
        var usernameInput = By.id("user-name");
        driver.findElement(usernameInput).sendKeys("standard_user" + Keys.TAB + "secret_sauce" + Keys.ENTER);

        // check the login was successful
        var inventoryPageTitle = By.className("title");
        var title = driver.findElement(inventoryPageTitle).getText();
        Assert.assertEquals(title, "Products");
    }

    @BeforeMethod
    public void beforeMethod(){
        // setup
        ChromeOptions options = new ChromeOptions();
        options.enableBiDi().setPageLoadStrategy(PageLoadStrategy.NORMAL).addArguments("start-maximized").setImplicitWaitTimeout(Duration.ofSeconds(5));
        driver = new ChromeDriver(options);
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
}
