package tests.K27_CrossBrowserTestler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.ReusableMethods;
import utilities.TestBaseCross;

public class C02_NegativeLoginTesti extends TestBaseCross {


    @Test
    public void gecersizPasswordTesti(){

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        driver.get(ConfigReader.getProperty("toUrl"));
        ReusableMethods.bekle(1);
        // 2- account linkine basin
        driver.findElement(By.xpath("(//span[.='Account'])[1]"))
                .click();
        ReusableMethods.bekle(1);
        // 3-  3 farkli test method’u olusturun.
        //	- gecerli email, gecersiz password
        driver.findElement(By.xpath("//input[@id='email']"))
                .sendKeys(ConfigReader.getProperty("toGecerliMail"));
        driver.findElement(By.xpath("//input[@id='password']"))
                .sendKeys(ConfigReader.getProperty("toGecersizPassword"));
        ReusableMethods.bekle(1);
        //4- Login butonuna basarak login olmayi deneyin
        driver.findElement(By.id("submitlogin"))
                .click();
        ReusableMethods.bekle(1);
        //5- Basarili olarak giris yapilamadigini test edin
        WebElement emailKutusu = driver.findElement(By.xpath("//input[@id='email']"));
        Assert.assertTrue(emailKutusu.isDisplayed());
        ReusableMethods.bekle(1);
        //6- Sayfayi kapatin
        driver.quit();
    }

    @Test
    public void gecersizEmailTesti(){

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        driver.get(ConfigReader.getProperty("toUrl"));
        ReusableMethods.bekle(1);
        // 2- account linkine basin
        driver.findElement(By.xpath("(//span[.='Account'])[1]"))
                .click();
        ReusableMethods.bekle(1);
        //3-  3 farkli test method’u olusturun.
        //	- gecersiz email, gecerli password
        driver.findElement(By.xpath("//input[@id='email']"))
                .sendKeys(ConfigReader.getProperty("toGecersizMail"));
        driver.findElement(By.xpath("//input[@id='password']"))
                .sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        ReusableMethods.bekle(1);
        //4- Login butonuna basarak login olmayi deneyin
        driver.findElement(By.id("submitlogin"))
                .click();
        ReusableMethods.bekle(1);
        //5- Basarili olarak giris yapilamadigini test edin
        WebElement emailKutusu = driver.findElement(By.xpath("//input[@id='email']"));
        Assert.assertTrue(emailKutusu.isDisplayed());
        ReusableMethods.bekle(1);
        //6- Sayfayi kapatin
        driver.quit();
    }

    @Test
    public void gecersizEmailGecersizPasswordTesti(){

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        driver.get(ConfigReader.getProperty("toUrl"));
        ReusableMethods.bekle(1);
        // 2- account linkine basin
        driver.findElement(By.xpath("(//span[.='Account'])[1]"))
                .click();
        ReusableMethods.bekle(1);
        // 3-  3 farkli test method’u olusturun.
        //	- gecersiz email, gecersiz password
        driver.findElement(By.xpath("//input[@id='email']"))
                .sendKeys(ConfigReader.getProperty("toGecersizMail"));
        driver.findElement(By.xpath("//input[@id='password']"))
                .sendKeys(ConfigReader.getProperty("toGecersizPassword"));
        ReusableMethods.bekle(1);
        //4- Login butonuna basarak login olmayi deneyin
        driver.findElement(By.id("submitlogin"))
                .click();
        ReusableMethods.bekle(1);
        //5- Basarili olarak giris yapilamadigini test edin
        WebElement emailKutusu = driver.findElement(By.xpath("//input[@id='email']"));
        Assert.assertTrue(emailKutusu.isDisplayed());
        ReusableMethods.bekle(1);
        //6- Sayfayi kapatin
        driver.quit();

    }
}
