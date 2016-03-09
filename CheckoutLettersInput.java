package Dima.Tests.GudUA;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
public class CheckoutLettersInput {
    private FirefoxDriver driver;
    @Before
    public void  precondition(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

    }
    @org.junit.Test
    public void test1() throws InterruptedException {
        driver.get("http://gud.ua/shop");
        driver.findElement(By.cssSelector("div[class = 'col s4 part left-part'] a")).click();
        driver.findElement(By.cssSelector("div[class='col s4 right-align']")).click();
        driver.findElement(By.id("slide-cart-open")).click();
        driver.findElement(By.cssSelector("a[class = 'button checkout']")).click();
        driver.findElement(By.id("first_name")).sendKeys("Дима");
        driver.findElement(By.id("email")).sendKeys("blsdsaasdffdsfd@ukr.net");
        driver.findElement(By.id("last_name")).sendKeys("Уруру");
        driver.findElement(By.id("phone")).sendKeys("23432");
        driver.findElement(By.id("u-np-city")).sendKeys("Киев");
        driver.findElement(By.id("u-np-department")).sendKeys("22");
        driver.findElement(By.id("payment-type-cod")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[class = 'button submit']")).click();

//        String s = driver.findElement(By.cssSelector("div[class = 'col m6 offset-m1 center-align'] p")).getText();
//        System.out.println(s);
//

// Assert.assertEquals(driver.findElement(By.cssSelector("div[class = 'col m6 offset-m1 center-align'] p")).getText(), "Спасибо,\n" +
//                "Ваш заказ успешно оформлен.\n" +
//                "Письмо с подтверждением отправлено на ваш e-mail.\n" +
//                "Мы свяжемся с вами в ближайшее время.");






        //driver.findElement(By.id("cart-amount")).click();


//        driver.findElement(By.name("btnG")).click();
//        Assert.assertTrue(driver.findElement(By.id("resultStats")).isDisplayed());
    }
    @After
    public void postCondition(){
       driver.close();

    }
}
