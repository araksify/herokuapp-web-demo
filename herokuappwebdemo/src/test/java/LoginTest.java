import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.LoginPage;

import static org.testng.AssertJUnit.assertTrue;

public class LoginTest {
    ChromeDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.close(); //Close the current window..
    }

    @AfterClass
    public void afterClass() {
        driver.quit(); //Quits this driver, closing every associated window.
    }

    @Test
    public void verifyScenarioLoginSuccess() {
        loginPage.goToLoginPage();
        loginPage.fillInUserCredentials("tomsmith", "SuperSecretPassword!");
        String successMessage = "You logged into a secure area!";
        assertTrue("Success message is Not present", loginPage.isLoginTextPresent(successMessage, "div"));
    }

    @Test
    public void verifyLoginFailure1() {
        loginPage.goToLoginPage();
        loginPage.fillInUserCredentials("wrontUserName", "SuperSecretPassword!");
        String failureMessage = "Your username is invalid";
        assertTrue("Invalid username message is not Present", loginPage.isLoginTextPresent(failureMessage, "div"));
    }

    @Test
    public void verifyLoginFailure2() {
        loginPage.goToLoginPage();
        loginPage.fillInUserCredentials("tomsmith", "wrongPassword");
        String failureMessage = "Your password is invalid";
        assertTrue("Invalid password message is not Present", loginPage.isLoginTextPresent(failureMessage, "div"));
    }

}
