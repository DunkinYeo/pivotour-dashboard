package app.pivotour.dashboard.library;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/* To-Do for Selenium Grid */
public class SeleniumBase {

    public static WebDriver driver;

    // To-Do : Getting parameters from external config file
    public static PropertiesConfiguration config = null;

    public void openBrowser() throws MalformedURLException {
        String hubhost = config.getString("HUBHOST");
        String browser = config.getString("BROWSER");
        String baseurl = config.getString("BASEURL");
        //System.out.println(hubhost);
        //System.out.println(browser);
        //System.out.println(baseurl);
        switch (browser) {
            default: //Chrome local
                /* Local */
                System.setProperty("webdriver.chrome.driver", "/Users/3i-21-173/chromedriver");
                driver = new ChromeDriver();
                break;
            case "CH": //Chrome
                /* Selenium Grid */
                //System.setProperty("webdriver.chrome.driver", "/Users/3i-21-173/chromedriver");
                ChromeOptions chromeOptions = new ChromeOptions();
                driver = new RemoteWebDriver(new URL(hubhost), chromeOptions);
                break;
            case "IE":
                //driver = new InternetExplorerDriver();
                break;
            case "FF":
                //driver = new FirefoxDriver();
                break;
        }
        //System.out.println("baseurl");
        driver.get(baseurl);
        //driver.get("http://");
    }

    public void closeBrowser() {
        try {
            driver.quit();
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
