package app.pivotour.dashboard.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage {

    public WebElement getTourByTitle(WebDriver driver, String tourTitle) {
        //WebElement tour = driver.findElement(By.xpath("//h3[contains(text(),'" + tourTitle + "')]"));
        WebElement tour = driver.findElement(By.xpath("//*[@id='app']/div/div[2]/div/div[2]/div/div[2]/div/div[1]/h3"));

        return tour;
    }
}
