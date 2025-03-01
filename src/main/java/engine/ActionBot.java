package engine;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public class ActionBot {
    private final WebDriver driver;
    private final FluentWait<?> wait;
    private static final Duration ELEMENT_IDENTIFICATION_TIMEOUT = Duration.ofSeconds(30);
    private static final Duration ASSERTIONS_TIMEOUT = Duration.ofSeconds(5);

    public ActionBot(WebDriver driver) {
        this.driver = driver;
        this.wait = new FluentWait<>(driver)
                .withTimeout(ELEMENT_IDENTIFICATION_TIMEOUT)
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(InvalidElementStateException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NotFoundException.class)
                .ignoring(AssertionError.class);
        System.out.println("Initializing ActionBot");
    }

    public void type(By locator, CharSequence... text) {
        wait.until(d -> {
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
            return true;
        });
        System.out.println("Typing "+ Arrays.toString(text) + " in " +locator);
    }

    public void quit() {
        driver.quit();
        System.out.println("Quitting the browser");
    }

//    public String getTextNative(By locator) {
//        System.out.println("Getting text from " + locator);
//        return driver.findElement(locator).getText();
//    }
//
//    public String getTextNativexx(By locator) {
//        System.out.println("Getting text from " + locator);
//        String text = "";
//        wait.until(d -> {
//            text = driver.findElement(locator).getText();
//            return true;
//        });
//        return text;
//    }

    public String getText(By locator) {
        AtomicReference<String> text = new AtomicReference<>("");
        System.out.println("Getting text from " + locator);
        wait.until(d -> {
            text.set(driver.findElement(locator).getText());
            return true;
        });
        return text.get();
    }

    public void assertElementText(By locator, String expectedText) {
        System.out.println("Asserting text from " + locator + " is " + expectedText);
        wait.withTimeout(ASSERTIONS_TIMEOUT).until(d -> {
            Assert.assertEquals(driver.findElement(locator).getText(), expectedText);
            return true;
        });
    }

    public void navigate(String url){
        wait.until(d -> {
            driver.navigate().to(url);
            return true;
        });
        System.out.println("Navigating to " + url);
    }
}
