package Dima.Tests.GudUA;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BuyProductRozetka {
    private FirefoxDriver driver;
    @org.junit.Test
    public void test(){

        driver = new FirefoxDriver();
        driver.get("http://rozetka.com.ua/");
        driver.findElement(By.cssSelector("div[name='header-search-input-text-wrap']")).sendKeys("Гитара");

zxcxzc
            }

}
