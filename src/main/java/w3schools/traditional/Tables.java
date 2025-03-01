package w3schools.traditional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Tables {
    private WebDriver driver;

    public Tables(WebDriver driver) {
        this.driver = driver;
    }

    public void navigate(){
        driver.navigate().to("https://www.w3schools.com/html/html_tables.asp");
    }

    public String getContactNameUsingCompanyAndCountry(String company, String country){
        By contactName = By.xpath("//tr[contains(.,'"+company+"')][contains(.,'"+country+"')]/td[2]");
        return driver.findElement(contactName).getText();
    }
}
