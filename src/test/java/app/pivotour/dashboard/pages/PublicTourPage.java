package app.pivotour.dashboard.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PublicTourPage {

    public String getPageTitle(WebDriver driver)
    {
        return driver.findElement(By.className("custom-header__title")).getText();
    }

}