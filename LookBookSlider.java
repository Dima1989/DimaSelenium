package Dima.Tests.GudUA;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by uzer on 08.03.2016.
 */
public class LookBookSlider {
    private FirefoxDriver driver;



    @Before
    public void  precondition(){
        driver = new FirefoxDriver();
//        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }


    @org.junit.Test

    public void test1() throws InterruptedException {



        driver.get("http://gud.ua/");
        String expected = driver.findElement(By.cssSelector("div#lookbook-slider>ul li:nth-child(2)>div>a")).getAttribute("href");
        Thread.sleep(3000L);
        driver.findElement(By.cssSelector("div#lookbook-slider div[class='control right-control']")).click();
        Thread.sleep(1500L);
        driver.findElement(By.cssSelector("div#lookbook-slider>ul li.active>div>a")).click();
        Thread.sleep(2000L);
        String actual = driver.getCurrentUrl();
        System.out.println("Ecpected result " + expected);
        System.out.println("Actual result " + actual);
        Assert.assertTrue(expected.equals(actual));
    }



    @After
    public void postCondition(){
        driver.close();

    }
}
