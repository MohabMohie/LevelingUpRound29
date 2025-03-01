package w3schools.advanced;

import org.openqa.selenium.WebDriver;

public abstract class PageObjectModel {
    WebDriver driver;

    public PageObjectModel(WebDriver driver) {
        this.driver = driver;
    }
}
