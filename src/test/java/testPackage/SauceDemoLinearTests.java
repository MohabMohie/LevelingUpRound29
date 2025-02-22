package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SauceDemoLinearTests {
    @Test
    public void userScenario(){
        // setup
        WebDriver driver;
        ChromeOptions options = new ChromeOptions();
        options.enableBiDi().setPageLoadStrategy(PageLoadStrategy.NORMAL).addArguments("start-maximized").setImplicitWaitTimeout(Duration.ofSeconds(5));
        driver = new ChromeDriver(options);

        // login page
        driver.navigate().to("https://www.saucedemo.com/");
        var usernameInput = By.id("user-name");
        var passwordInput = By.id("password");
        var loginButton = By.id("login-button");

        driver.findElement(usernameInput).sendKeys("standard_user");
        driver.findElement(passwordInput).sendKeys("secret_sauce");
        driver.findElement(loginButton).click();

        // items page
        var firstItemAddToCartButton = By.xpath("(//div[@class='inventory_item']//button)[1]");
        driver.findElement(firstItemAddToCartButton).click();

        var cartLink = By.xpath("//div[@id='shopping_cart_container']/a");
        driver.findElement(cartLink).click();

        // cart page
        var inventoryItemNameLabel = By.className("inventory_item_name");

        var inventoryItemName = driver.findElement(inventoryItemNameLabel).getText();
        Assert.assertEquals(inventoryItemName, "Sauce Labs Backpack");

        // teardown
        driver.quit();
    }
}
