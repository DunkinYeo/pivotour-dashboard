package app.pivotour.dashboard.library;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;

import java.io.File;

public class TestBase extends SeleniumBase {

    /*
        To-Do : Any config for Remote Selenium Server in @BeforeTest
     */
    @Parameters({ "configfile" })
    @BeforeSuite(groups = { "abstract" })
    public void initFramework(@Optional("src/test/resources/config.properties") String configfile) throws Exception {
        // Initialize configuration
        Configurations configs = new Configurations();
        // Read data from this file
        File propertiesFile = new File(configfile);
        //FileBasedConfigurationBuilder<PropertiesConfiguration> builder = configs.propertiesBuilder(propertiesFile);
        PropertiesConfiguration conf = configs.properties(propertiesFile);

        config = conf;
    }
    @BeforeTest(groups = { "abstract" })
    public void initTests() throws Exception{
        // Start Selenium Server
        //super.startSeleniumServer();
    }

    // Create global WebDriver
    @BeforeMethod(groups = { "abstract" })
    public void setUpTests() {
        try {
            super.openBrowser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Close WebDriver
    @AfterMethod(groups = { "abstract" })
    public void tearDownTests() throws Exception{
        try {
            super.closeBrowser();
        } catch (Exception e) {
            //
        }
    }

    @AfterTest(groups = { "abstract" })
    public void cleanUp() {
        try {


        } catch (Exception e) {

        }
    }

    public WebDriver getDriver() {
        return driver; // static handle to Selenium object
    }

}
