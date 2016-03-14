package Dima.Tests.GudUA;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class ProductPageScrollButton {

    private FirefoxDriver driver;


    @Before
    public void precondition() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @org.junit.Test
    public void test1() throws InterruptedException, IOException {
        Long PrePosition = 0L, PostPosition = 0L;//screen position befor and after click
        boolean[] up = {true, true, true};
        boolean[] down = {true, true, true};
        String code;// code number of product
        JavascriptExecutor executor = (JavascriptExecutor) driver;

        driver.get("http://gud.ua/en/shop");
        driver.manage().window().maximize();

        WebElement element = driver.findElement(By.cssSelector("div[class='col s8 m4 item']:last-of-type"));
        executor.executeScript("arguments[0].scrollIntoView()", element);// scroll page to Show all button
        driver.findElement(By.cssSelector("a[id='show-all']")).click();// click on Show all
        Thread.sleep(5000L);

        List<WebElement> Products = driver.findElements(By.cssSelector("div[class='col s8 m4 item'] div[class='col s8 l6 offset-l1']>a"));//count products
        Map<String, String> map = new HashMap<String, String>();//store test results
//        System.out.println(Products.size());
//        Long hight = (Long) executor.executeScript("return window.innerHeight;");
        for (int i = 0; i < Products.size() - 45; i++) {//click down
            Thread.sleep(3000L);
            List<WebElement> Products1 = driver.findElements(By.cssSelector("div[class='col s8 m4 item'] div[class='col s8 l6 offset-l1']>a"));
            Products1.get(i).click();
            Thread.sleep(2000);
            List<WebElement> image = driver.findElements(By.cssSelector("img[class='image']"));

            for (int j = 1; j < image.size() - 1; j++) {//click up
                PrePosition = (Long) executor.executeScript("return window.scrollY;");
                driver.findElement(By.cssSelector("button.control.down.hide-on-med-and-down")).click();
                Thread.sleep(1000);
                PostPosition = (Long) executor.executeScript("return window.scrollY;");
//                System.out.println("Post " + PostPosition + " Pre " + PrePosition);
                down[j - 1] = (PostPosition - PrePosition) > 10;//does screen change position?

            }
            Thread.sleep(2000);
            for (int j = 1; j < image.size() - 1; j++) {
                PrePosition = (Long) executor.executeScript("return window.scrollY;");
                driver.findElement(By.cssSelector("button.control.up.hide-on-med-and-down")).click();
                Thread.sleep(1000);
                PostPosition = (Long) executor.executeScript("return window.scrollY;");
//                System.out.println("Post " + PostPosition + " Pre " + PrePosition);
                up[j - 1] = (PostPosition - PrePosition) < 0;//does screen change position?
            }
            code = driver.findElement(By.cssSelector("span[class='code']")).getText();//find code number of product

            if (up[0] && up[1] && up[2] && down[0] && down[1] && down[2]) {
                map.put(code, " pass");
            } else {
                map.put(code, " failed");
            }
//            System.out.println(down[0] +" " + down[1] + " " + down[2] + " " + up[0] + " " +  up[1] + " " + up[2]);
            down[0] = true;
            down[1] = true;
            up[0] = true;
            up[1] = true;
            driver.get("http://gud.ua/en/shop");
            element = driver.findElement(By.cssSelector("div[class='col s8 m4 item']:last-of-type"));//

            executor.executeScript("arguments[0].scrollIntoView()", element);// scroll page to Show all button
            Thread.sleep(2000L);
            driver.findElement(By.cssSelector("a[id='show-all']")).click();// click on Show all


        }
//        for (Map.Entry<String, String> pair : map.entrySet())
//        {
//            String key = pair.getKey();                      //ключ
//            String value = pair.getValue();                  //значение
//            System.out.println(key + ":" + value);
//        }
        File file = new File("Hello1.txt");
        // creates the file
        file.createNewFile();
        // creates a FileWriter Object
        FileWriter writer = new FileWriter(file);

        for (Map.Entry<String, String> pair : map.entrySet()) {// write test result to the file
            String key = pair.getKey();                      //ключ
            String value = pair.getValue();                  //значение
            System.out.println(key + ":" + value);
            writer.write(pair.getKey() + " " + pair.getValue() + "                                                            ");
        }
        writer.flush();
        writer.close();
    }


    @After
    public void postCondition() throws IOException {


        driver.close();

    }
}
