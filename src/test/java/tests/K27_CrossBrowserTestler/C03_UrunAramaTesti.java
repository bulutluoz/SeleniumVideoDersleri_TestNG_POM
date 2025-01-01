package tests.K27_CrossBrowserTestler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.ReusableMethods;
import utilities.TestBaseCross;

public class C03_UrunAramaTesti extends TestBaseCross {

    @Test
    public void test01(){

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        driver.get(ConfigReader.getProperty("toUrl"));
        ReusableMethods.bekle(1);
        // phone icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);
        ReusableMethods.bekle(1);
        // arama sonucunda urun bulunabildigini test edin
        int actualAramaSonucSayisi = driver.findElements(By.xpath("//*[@*='prod-img']"))
                                            .size();

        Assert.assertTrue(actualAramaSonucSayisi>0);
        ReusableMethods.bekle(1);
        // Sayfayi kapatin
        driver.quit();

    }

}
