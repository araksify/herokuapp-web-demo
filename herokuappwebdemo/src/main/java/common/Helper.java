package common;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Helper {

    private WebDriver driver;

    public Helper(WebDriver driver) {
        this.driver = driver;
    }

    long timeout = 30;

    public void highlightElement(WebElement element) {
        for (int i = 0; i < 2; i++) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
                    element,
                    "color: black; border: 4px solid yellow;");
        }
    }

    private WebElement locateElement(By by) {
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        WebElement element = driver.findElement(by);
        highlightElement(element);
        return element;
    }

    public void click(By by) {
        WebElement webElement = locateElement(by);
        WebDriverWait webDriverWait = new WebDriverWait(driver, 50);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        webElement.click();
    }

    public void clickByIndex(By by, int index) {
        List<WebElement> elements = driver.findElements(by);
        elements.get(index).click();
    }

    public void enterText(By by, String string) {
        WebElement webElement = locateElement(by);
        webElement.sendKeys(string);
    }

    public boolean isElementPresent(By by) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        List<WebElement> elements;
        elements = driver.findElements(by);
        if (elements.size() > 0)
            return true;
        else
            return false;
    }

    public boolean isPartialTextPresent(String string, String tagname) {
        WebElement webElement = driver.findElement(By.tagName(tagname));
        String text = webElement.getText();
        return text.contains(string);
    }

    public void hoverOverElement(String tagname, int index) {
        Actions builder = new Actions(driver);
        List<WebElement> hoverElements = driver.findElements(By.tagName(tagname));
        builder.moveToElement(hoverElements.get(index)).click().perform();
    }

    public String getElementText(By by, int index) {
        List<WebElement> elements = driver.findElements(by);
        return elements.get(index).getText();
    }

    public void openURL(String url) {
        driver.navigate().to(url);
    }

    public int getElementCount(By by) {
        List<WebElement> elements = driver.findElements(by);
        return elements.size();
    }
}
