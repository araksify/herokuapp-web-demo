package pages;

import common.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends AbstractPage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private static final By LOGIN_EMAIL = By.id("username");
    private static final By LOGIN_PASSWORD = By.id("password");
    private static final By LOGIN_BUTTON = By.tagName("button");

    private static final String LOGIN_URL = "http://the-internet.herokuapp.com/login";


    public void goToLoginPage() {
        helper.openURL(LOGIN_URL);
    }

    public void fillInUserCredentials(String username, String password) {
        helper.enterText(LOGIN_EMAIL, username);
        helper.enterText(LOGIN_PASSWORD, password);
        helper.click(LOGIN_BUTTON);
    }

    public boolean isLoginTextPresent(String string, String tagname) {
        return helper.isPartialTextPresent(string, tagname);
    }
}
