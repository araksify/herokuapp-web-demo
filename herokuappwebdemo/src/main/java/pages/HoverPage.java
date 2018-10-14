package pages;

import common.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HoverPage extends AbstractPage {

    public HoverPage(WebDriver driver) {
        super(driver);
    }

    private static final String HOVER_URL = "http://the-internet.herokuapp.com/hovers";
    private static final By NAMES = By.tagName("h5");


    public void goToHoversPage() {
        helper.openURL(HOVER_URL);
    }

    public void hoverOverProfilePics(int index) {
        helper.hoverOverElement("img", index);
    }

    public boolean isUsernamePresent(String username, int index) {
        return helper.getElementText(NAMES, index).contains(username);
    }

}
