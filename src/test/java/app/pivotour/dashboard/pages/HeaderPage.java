package app.pivotour.dashboard.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class HeaderPage {
    
    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public void searchTour(WebDriver driver, String keyword) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try {
            //Search a Tour by title
            WebElement btnSearch = driver.findElement(By.className("search-button"));
            btnSearch.click();
            WebElement inputSearch = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"));
            inputSearch.sendKeys(keyword);
            inputSearch.sendKeys(Keys.RETURN);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }
    
}
