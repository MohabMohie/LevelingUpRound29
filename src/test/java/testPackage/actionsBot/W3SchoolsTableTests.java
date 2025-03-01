package testPackage.actionsBot;

import engine.ActionBot;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test public class W3SchoolsTableTests {
    ActionBot bot;

    public void checkContactNameForErnstHandelInAustria(){
        navigateToW3SchoolsTables();
        assertContactNameUsingCompanyAndCountry("Ernst Handel", "Austria", "Roland Mendel");
    }

    public void checkContactNameForAlfredsFutterkisteInGermany(){
        navigateToW3SchoolsTables();
        assertContactNameUsingCompanyAndCountry("Alfreds Futterkiste", "Germany", "Maria Anders");
    }

    private void navigateToW3SchoolsTables(){
        bot.navigate("https://www.w3schools.com/html/html_tables.asp");
    }

    private void assertContactNameUsingCompanyAndCountry(String company, String country, String expectedContactName){
        By contactName = By.xpath("//tr[contains(.,'"+company+"')][contains(.,'"+country+"')]/td[2]");
        bot.assertElementText(contactName, expectedContactName);
    }

    @BeforeMethod
    public void beforeMethod(){
        // setup
        ChromeOptions options = new ChromeOptions();
        options.enableBiDi().setPageLoadStrategy(PageLoadStrategy.NONE).addArguments("start-maximized");
        bot = new ActionBot(new ChromeDriver(options));
    }

    @AfterMethod
    public void afterMethod(){
        bot.quit();
    }

}
