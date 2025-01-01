package tests.K27_CrossBrowserTestler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.ReusableMethods;
import utilities.TestBaseCross;

public class C01_PositiveLoginTesti extends TestBaseCross{

    @Test
    public void positiveLoginTesti(){

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        driver.get(ConfigReader.getProperty("toUrl"));
        ReusableMethods.bekle(1);

        // 2- account linkine basin
        driver.findElement(By.xpath("(//span[.='Account'])[1]"))
                .click();
        ReusableMethods.bekle(1);

        // 3- Kullanici email'i olarak gecerli email girin
        driver.findElement(By.xpath("//input[@id='email']"))
                .sendKeys(ConfigReader.getProperty("toGecerliMail"));

        // 4- Kullanici sifresi olarak gecerli password girin
        driver.findElement(By.xpath("//input[@id='password']"))
                .sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        ReusableMethods.bekle(1);
        // 5- Login butonuna basarak login olun
        driver.findElement(By.id("submitlogin"))
                .click();
        ReusableMethods.bekle(1);
        // 6- Basarili olarak giris yapilabildigini test edin
        WebElement logoutButonu = driver.findElement(By.xpath("//span[.='Logout']"));

        Assert.assertTrue(logoutButonu.isDisplayed());

        ReusableMethods.bekle(1);
        logoutButonu.click();
        // 7- Sayfayi kapatin
        driver.quit();

    }

}
