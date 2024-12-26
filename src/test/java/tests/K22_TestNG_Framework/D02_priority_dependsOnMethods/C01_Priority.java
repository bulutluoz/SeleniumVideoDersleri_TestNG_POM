package tests.K22_TestNG_Framework.D02_priority_dependsOnMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_Priority {
    // uc farkli test method'u olusturun
    // testotomasyonu, wisequarter ve bestbuy sitelerine gidip
    // url'in testotomasyonu, wisequarter ve bestbuy kelimeleri icerdigini test edin
    // ve windowlari kapatin
    /*
        TestNG biz birsey soylemedi isek
        test method'larini alfabetik siraya uygun olarak calistirir

        1- biz test method'larina priority tanimlarsak
           priority degerlerini kucukten buyuge dogru calistirir

        2- bazi method'lar priority atayip, bazilarina atama yapmazsak
           atama yapilmayan method'larin priority degeri
           default deger olan 0 olur ve buna uygun sirada calisir

        3- ayni priority degerine sahip birden fazla method olursa
           esit priority degeri olanlar, kendi iclerinde alfabetik siraya uyarlar
     */

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test (priority = 20)
    public void testotomasyonuTest() throws InterruptedException {

        driver.get("https://www.testotomasyonu.com");

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        Thread.sleep(1000);

    }

    @Test
    public void wisequarterTest() throws InterruptedException {
        driver.get("https://www.wisequarter.com");

        String expectedUrlIcerik = "wisequarter";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        Thread.sleep(1000);
    }

    @Test
    public void bestbuyTest() throws InterruptedException {
        driver.get("https://www.bestbuy.com");

        String expectedUrlIcerik = "bestbuy";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        Thread.sleep(1000);
    }
}
