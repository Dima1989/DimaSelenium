package Dima.Tests.GudUA;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProductPageScrollButton {

    private FirefoxDriver driver;



    @Before
    public void  precondition(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }


    @org.junit.Test

    public void test1() throws InterruptedException {


        Long PrePosition = 0L, PostPosition = 0L;
        boolean[] up = {true, true};
        boolean[] down = {true, true};
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        driver.get("http://gud.ua/product/702-alphabet");
        driver.manage().window().maximize();
        Long hight = (Long) executor.executeScript("return window.innerHeight;");
        List<WebElement> image = driver.findElements(By.cssSelector("img[class='image']"));

        for (int i = 1; i < image.size()-1; i++) {
            PrePosition = (Long) executor.executeScript("return window.scrollY;");
            driver.findElement(By.cssSelector("button[class='control down hide-on-med-and-down']")).click();
            PostPosition = (Long) executor.executeScript("return window.scrollY;");
            down[i-1] = PostPosition > (PrePosition + 0.2 * hight);
        }

        for (int i = 1; i < image.size()-1; i++) {
            PrePosition = (Long) executor.executeScript("return window.scrollY;");
            driver.findElement(By.cssSelector("button[class='control up hide-on-med-and-down']")).click();
            PostPosition = (Long) executor.executeScript("return window.scrollY;");
            up[i-1] = PostPosition < (PrePosition  - 0.2 * hight);
        }
        System.out.println(down[0] +" " + down[1] + " " + up[0] + " " +  up[1]);
        Assert.assertTrue(up[0] && up[1] && down[0] && down[1]);
    }

    @org.junit.Test
    public void test2() throws InterruptedException {
        Long PrePosition = 0L, PostPosition = 0L;
        boolean[] up = {true, true};
        boolean[] down = {true, true};
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        driver.get("http://gud.ua/product/805-basic-new");
        driver.manage().window().maximize();
        Long hight = (Long) executor.executeScript("return window.innerHeight;");
        List<WebElement> image = driver.findElements(By.cssSelector("img[class='image']"));

        for (int i = 1; i < image.size()-1; i++) {
            PrePosition = (Long) executor.executeScript("return window.scrollY;");
            driver.findElement(By.cssSelector("button[class='control down hide-on-med-and-down']")).click();
            PostPosition = (Long) executor.executeScript("return window.scrollY;");
            down[i-1] = PostPosition > (PrePosition + 0.1 * hight);

        }

        for (int i = 1; i < image.size()-1; i++) {
            PrePosition = (Long) executor.executeScript("return window.scrollY;");
            driver.findElement(By.cssSelector("button[class='control up hide-on-med-and-down']")).click();
            PostPosition = (Long) executor.executeScript("return window.scrollY;");
            up[i-1] = PostPosition < (PrePosition - 0.1 * hight);
        }
        System.out.println(down[0] +" " + down[1] + " " + up[0] + " " +  up[1]);
        Assert.assertTrue(up[0] && up[1] && down[0] && down[1]);
    }


    @After
    public void postCondition(){
        driver.close();

    }
}
