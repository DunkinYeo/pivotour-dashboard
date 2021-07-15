package app.pivotour.dashboard.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage {

    public WebElement getTourByTitle(WebDriver driver, String tourTitle) {
        WebElement tour = driver.findElement(By.xpath("//*[text()='" + tourTitle + "']"));
        return tour;
    }
}
