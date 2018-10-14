import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.TablesPage;

import static org.testng.AssertJUnit.assertTrue;

public class TablesTest {
    ChromeDriver driver;
    TablesPage tablesPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        tablesPage = new TablesPage(driver);
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
    public void verifySortableDataTable() {
        tablesPage.goToTablesPage();
        tablesPage.clickToSortByLastName();
        assertTrue("Last Names are not sorted",
                tablesPage.isColumnSortedByOrder(TablesPage.ORDER.ASCENDING));
        tablesPage.clickToSortByLastName();
        assertTrue("Last Name Column did not change order!",
                tablesPage.isColumnSortedByOrder(TablesPage.ORDER.DESCENDING));
    }
}
