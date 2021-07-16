package app.pivotour.dashboard.tests;

import app.pivotour.dashboard.library.TestBase;
import app.pivotour.dashboard.pages.HeaderPage;
import app.pivotour.dashboard.pages.LoginPage;
import app.pivotour.dashboard.pages.SearchResultPage;
import app.pivotour.dashboard.pages.TourViewerPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class TourViewerTest extends TestBase {

    @Test(groups = { "smoke" })
    public void verifyTourViewerUI() {
        WebDriver driver = getDriver();
        //Go to Tour frontpage (login)
        //driver.get(config.getString("BASEURL"));

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try {
            //Input Email, Password and Click on Login button
            LoginPage login = new LoginPage();
            login.clickLogin(driver);

            HeaderPage header = new HeaderPage();
            Thread.sleep(3000);
            header.searchTour(driver, "12 - 13 edited");

            Thread.sleep(5000);

            SearchResultPage search = new SearchResultPage();
            search.getTourByTitle(driver,"12 - 13 edited").click();
            Thread.sleep(5000);

            ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));

            TourViewerPage tourView = new TourViewerPage();
            System.out.println(tourView.getPageTitle(driver));
            assertTrue(tourView.getPageTitle(driver).contains("12 - 13 edited"));
            //More asserts to be added below

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

    }


}
