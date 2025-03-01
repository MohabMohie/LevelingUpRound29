package testPackage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class DemoTests {
    @Test
    public void browserActions() {
        WebDriver driver;

        ChromeOptions options = new ChromeOptions();
//        options.addArguments("start-maximized");
//        options.addArguments("--headless");
        options.enableBiDi().setPageLoadStrategy(PageLoadStrategy.NORMAL).addArguments("start-maximized");

        driver = new ChromeDriver(options);

//        driver = new ChromeDriver();
//        driver.manage().window().maximize();

//        var availableLogTypes = driver.manage().logs().getAvailableLogTypes();
        driver.navigate().to("https://www.selenium.dev/selenium/web/web-form.html");
//        var driverLogs = driver.manage().logs().get("driver");
//        var browserLogs = driver.manage().logs().get("browser");
//        var clientLogs = driver.manage().logs().get("client");

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//        driver.navigate().to("https://www.google.com");
//        driver.get("https://www.google.com");
//        var firstWindowHandle = driver.getWindowHandle();
//        driver.switchTo().newWindow(WindowType.TAB);
//        driver.switchTo().window(firstWindowHandle);



        driver.quit();
    }

    @Test
    public void elementActions() {
        WebDriver driver;
        ChromeOptions options = new ChromeOptions();
        options.enableBiDi().setPageLoadStrategy(PageLoadStrategy.NORMAL).addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.navigate().to("https://www.selenium.dev/selenium/web/web-form.html");
//        By.xpath("//*[@id='my-text-id']");


//        By.cssSelector("");

//        By.name("gender");
//        By.id("my-text-id");
//        By.className("");
//        By.tagName("input");
//        By.linkText("Selenium Official Page");
//        By.partialLinkText("Official Page");

//        driver.findElement(By.id("my-text-id")).click();



        driver.findElement(By.id("my-text-id")).sendKeys("Hello World");

        // 1. using a by object
        var inputLocator = By.id("my-text-id");
        driver.findElement(inputLocator).getText();

        // 2. using a webelement reference
        WebElement inputElement = driver.findElement(By.id("my-text-id"));
        inputElement.getText();

        // 3. @FindBy => Page Factory pattern


//        String text = driver.findElement(By.id("my-text-id")).getText();
//        var attribute = driver.findElement(By.id("my-text-id")).getAttribute("value");
//        var domAttribute = driver.findElement(By.id("my-text-id")).getDomAttribute("value");
//        var domProperty = driver.findElement(By.id("my-text-id")).getDomProperty("value");

//        driver.findElements();
        driver.quit();
    }

    @Test
    public void disabledElement(){
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/click_tests/disabled_element.html");

        driver.findElement(By.tagName("input")).sendKeys("Hello World");

        driver.quit();
    }
}