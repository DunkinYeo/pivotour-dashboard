package app.pivotour.dashboard.tests;

import app.pivotour.dashboard.library.TestBase;
import app.pivotour.dashboard.pages.PublicTourPage;
import app.pivotour.dashboard.pages.LoginPage;
import app.pivotour.dashboard.pages.HeaderPage;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;

public class DashboardLoginTest extends TestBase {

    //@Test(groups = { "smoke" })
    public void VerifyLogin() {
        WebDriver driver = getDriver();                
        //Go to Tour frontpage (login)
        //driver.get(config.getString("BASEURL"));
        //Page loding timeout (10s)
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        try {
            //Input Email, Password and Click on Login button
            LoginPage login = new LoginPage();
            login.clickLogin(driver);
            //Check Title
            HeaderPage header = new HeaderPage();
            assertEquals(header.getPageTitle(driver), "Pivo Tour Dashboard");
            //Check Public Tour Page loaded
            PublicTourPage publicTour = new PublicTourPage();
            assertTrue(publicTour.getPageTitle(driver).contains("Public Tour"));

            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public void VerifyGoogleLogin() {

    }

    public void VerifyFacebookLogin() {

    }

    public void VerifyAppleLogin() {

    }

}
