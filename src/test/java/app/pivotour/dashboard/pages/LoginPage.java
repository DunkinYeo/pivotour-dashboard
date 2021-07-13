package app.pivotour.dashboard.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    
    public void clickLogin(WebDriver driver) {
        //email field
        driver.findElement(By.cssSelector("#app > div > div > div > form > div:nth-child(1) > div > div > input")).sendKeys("Test@3i.ai");
        //password field
        driver.findElement(By.xpath("//*[@id='app']/div/div/div/form/div[2]/div/div[1]/input")).sendKeys("3iDev8593");
        //Click Login button
        driver.findElement(By.xpath("//*[@id='app']/div/div/div/form/button")).click();
    }
}
