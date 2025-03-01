package w3schools.advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FluentTables {
    private WebDriver driver;

    public FluentTables(WebDriver driver) {
        this.driver = driver;
    }

    public FluentTables navigate(){
        driver.navigate().to("https://www.w3schools.com/html/html_tables.asp");
        return this;
    }

    public String getContactNameUsingCompanyAndCountry(String company, String country){
        By contactName = By.xpath("//tr[contains(.,'"+company+"')][contains(.,'"+country+"')]/td[2]");
        return driver.findElement(contactName).getText();
    }
}
