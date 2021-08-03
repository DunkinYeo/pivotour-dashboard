package app.pivotour.dashboard.library;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static app.pivotour.dashboard.library.ThreadSafeWebDriverStorage.startWebDriverSession;
import static app.pivotour.dashboard.library.ThreadSafeWebDriverStorage.getDriver;
import static app.pivotour.dashboard.library.ThreadSafeWebDriverStorage.closeWebDriverSession;

/* To-Do for Selenium Grid */
public class SeleniumBase {

    public static WebDriver driver;

    // To-Do : Getting parameters from external config file
    public static PropertiesConfiguration config = null;
    public static boolean isRunningInGrid = false;

    public void openBrowser() throws MalformedURLException {
        String browser = config.getString("BROWSER");
        String baseurl = config.getString("BASEURL");
        /* Local Mode*/
        switch (browser) {
            case "CH": //Chrome
                System.setProperty("webdriver.chrome.driver", "/Users/3i-21-173/chromedriver");
                driver = new ChromeDriver();
                break;
            case "IE":
                //driver = new InternetExplorerDriver();
                break;
            case "FF":
                //driver = new FirefoxDriver();
                break;
        }

        driver.get(baseurl);
    }

    public void closeBrowser() {
        try {
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*Grid Mode*/
    public void openBrowserInGrid() throws MalformedURLException {
        isRunningInGrid = true;
        String hubhost = config.getString("HUBHOST");
        String browser = config.getString("BROWSER");
        String baseurl = config.getString("BASEURL");

        /* Selenium Grid Mode*/
        switch (browser) {
            case "CH": //Chrome
                ChromeOptions chromeOptions = new ChromeOptions();
                startWebDriverSession(hubhost, browser, baseurl);
                break;
            case "IE":
                //driver = new InternetExplorerDriver();
                break;
            case "FF":
                //driver = new FirefoxDriver();
                break;
        }

        getDriver().manage().window().maximize();
    }

    public void closeBrowserInGrid() {
        try {
            closeWebDriverSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void startSeleniumServer() throws Exception {

    }

    public void stopSeleniumServer() {
        //seleniumServer.stop();
    }



}
