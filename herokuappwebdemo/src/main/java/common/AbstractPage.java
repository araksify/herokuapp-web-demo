package common;

import org.openqa.selenium.WebDriver;

public class AbstractPage {
    protected WebDriver driver;

    protected Helper helper;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        this.helper = new Helper(driver);
    }
}
