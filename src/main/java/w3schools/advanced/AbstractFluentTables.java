package w3schools.advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AbstractFluentTables extends PageObjectModel {
    By contactName = By.xpath("");

    public AbstractFluentTables(WebDriver driver) {
        super(driver);
    }

    public AbstractFluentTables navigate(){
        driver.navigate().to("https://www.w3schools.com/html/html_tables.asp");
        return this;
    }

    public String getContactNameUsingCompanyAndCountry(String company, String country){
        contactName = By.xpath("//tr[contains(.,'"+company+"')][contains(.,'"+country+"')]/td[2]");
        return driver.findElement(contactName).getText();
    }
}
