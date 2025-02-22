package testPackage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicElementsTests {

    @Test
    public void testMethod(){
        // setup
        WebDriver driver;
        ChromeOptions options = new ChromeOptions();
//        options.enableBiDi().setPageLoadStrategy(PageLoadStrategy.NORMAL).addArguments("start-maximized").setImplicitWaitTimeout(Duration.ofSeconds(5));
        options.enableBiDi().setPageLoadStrategy(PageLoadStrategy.NORMAL).addArguments("start-maximized");
        driver = new ChromeDriver(options);
        Wait<WebDriver> wait;
//        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(2))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(InvalidElementStateException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NotFoundException.class);

        driver.navigate().to("https://www.selenium.dev/selenium/web/dynamic.html");

        By adderButton = By.id("adder");
        driver.findElement(adderButton).click();

        By boxZeroDiv = By.id("box0");

        wait.until(d -> {
            driver.findElement(boxZeroDiv).click();
            return true;
        });

        By revealButton = By.id("reveal");
        driver.findElement(revealButton).click();

        By revealedInput = By.id("revealed");

        wait.until(d -> {
            d.findElement(revealedInput).sendKeys("Hello, World!");
            return true;
        });

        driver.quit();

    }
}
