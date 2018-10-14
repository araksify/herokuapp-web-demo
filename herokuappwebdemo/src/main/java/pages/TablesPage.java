package pages;

import common.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class TablesPage extends AbstractPage {
    public TablesPage(WebDriver driver) {
        super(driver);
    }

    private final By EXAMPLE2_TABLE = By.id("table2");
    private static final String TABLES_URL = "http://the-internet.herokuapp.com/tables";
    private final By EXAMPLE2_LAST_NAME = By.xpath("//*[@id=\"table2\"]/thead/tr/th[1]/span");
    public final By LAST_NAMES = By.className("last-name");

    public enum ORDER {ASCENDING, DESCENDING}

    ;

    public void goToTablesPage() {
        helper.openURL(TABLES_URL);
    }

    public void clickToSortByLastName() {
        helper.click(EXAMPLE2_LAST_NAME);
    }

    public ArrayList<String> returnArrayOfColumn() {
        ArrayList<String> arr = new ArrayList<String>();
        for (int i = 1; i < helper.getElementCount(LAST_NAMES); i++) {
            arr.add(helper.getElementText(LAST_NAMES, i));
            System.out.println("First name is + " + helper.getElementText(LAST_NAMES, i));
        }
        return arr;
    }

    public boolean checkSorting(ArrayList<String> arraylist, ORDER order) {
        boolean isSorted = true;
        for (int i = 1; i < arraylist.size(); i++) {
            int diff = arraylist.get(i - 1).charAt(0) - arraylist.get(i).charAt(0);
            switch (order) {
                case ASCENDING:
                    if (diff > 0) {
                        isSorted = false;
                        break;
                    }
                    break;
                case DESCENDING:
                    if (diff < 0) {
                        isSorted = false;
                        break;
                    }
                    break;
                default:
                    isSorted = false;
            }
        }
        return isSorted;
    }

    public boolean isColumnSortedByOrder(ORDER order) {
        return checkSorting(returnArrayOfColumn(), order);
    }


}
