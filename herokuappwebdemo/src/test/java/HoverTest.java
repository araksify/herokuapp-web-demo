import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.HoverPage;

import static org.testng.AssertJUnit.assertTrue;

public class HoverTest {
    ChromeDriver driver;
    HoverPage hoverPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        hoverPage = new HoverPage(driver);
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
    public void verifyScenarioHovers() throws InterruptedException {
        hoverPage.goToHoversPage();
        for (int i = 1; i < 4; i++) {
            hoverPage.hoverOverProfilePics(i);
            assertTrue("username user" + i + " is not displayed!",
                    hoverPage.isUsernamePresent("user" + i, i - 1));
        }
    }
}
