package app.pivotour.dashboard.pages;

import org.openqa.selenium.WebDriver;

public class TourViewerPage {

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

}
