package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class SauceDemoStructuredTests {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        // setup
        ChromeOptions options = new ChromeOptions();
        options.enableBiDi().setPageLoadStrategy(PageLoadStrategy.NORMAL).addArguments("start-maximized").setImplicitWaitTimeout(Duration.ofSeconds(5));
        driver = new ChromeDriver(options);
    }

    @AfterClass
    public void teardown(){
        // teardown
        driver.quit();
    }

    @Test
    public void login(){
        // login page
        driver.navigate().to("https://www.saucedemo.com/");
        var usernameInput = By.id("user-name");
        var passwordInput = By.id("password");
        var loginButton = By.id("login-button");

        driver.findElement(usernameInput).sendKeys("standard_user");
        driver.findElement(passwordInput).sendKeys("secret_sauce");
        driver.findElement(loginButton).click();

        // check the login was successful
        var inventoryPageTitle = By.className("title");
        var title = driver.findElement(inventoryPageTitle).getText();
        Assert.assertEquals(title, "Products");
    }

    @Test(dependsOnMethods = "login")
    public void addItemToCart(){
        // items page
        var firstItemAddToCartButton = By.xpath("(//div[@class='inventory_item']//button)[1]");
        driver.findElement(firstItemAddToCartButton).click();

        var cartBadge = By.className("shopping_cart_badge");
        var cartBadgeValue = driver.findElement(cartBadge).getText();
        Assert.assertEquals(cartBadgeValue, "1");
    }

    @Test(dependsOnMethods = {"login","addItemToCart"})
    public void checkItemIsDisplayedSuccessfullyInMyCart(){
        // navigate to cart
        var cartLink = By.xpath("//div[@id='shopping_cart_container']/a");
        driver.findElement(cartLink).click();

        // check the item was added successfully
        var inventoryItemNameLabel = By.className("inventory_item_name");

        var inventoryItemName = driver.findElement(inventoryItemNameLabel).getText();
        Assert.assertEquals(inventoryItemName, "Sauce Labs Backpack");
    }
}
