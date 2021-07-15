package app.pivotour.dashboard.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

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
            btnSearch.sendKeys(keyword);
            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
}
