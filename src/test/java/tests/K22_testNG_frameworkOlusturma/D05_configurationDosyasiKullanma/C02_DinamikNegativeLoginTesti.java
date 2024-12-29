package tests.K22_testNG_frameworkOlusturma.D05_configurationDosyasiKullanma;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_DinamikNegativeLoginTesti {

    //1- https://www.testotomasyonu.com/ anasayfasina gidin
    //2- account linkine basin
    // 3-  3 farkli test method’u olusturun.
    //	- gecerli email, gecersiz password
    //	- gecersiz email, gecerli password
    //	- gecersiz email, gecersiz password.
    //4- Login butonuna basarak login olmayi deneyin
    //5- Basarili olarak giris yapilamadigini test edin

    TestotomasyonuPage testotomasyonuPage;

    @Test
    public void gecersizPasswordTesti(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        testotomasyonuPage = new TestotomasyonuPage();

        //2- account linkine basin
        testotomasyonuPage.accountLinki.click();

        // 3-  3 farkli test method’u olusturun.
        //	- gecerli email, gecersiz password girin

        testotomasyonuPage.loginSayfasiEmailKutusu
                            .sendKeys(ConfigReader.getProperty("toGecerliMail"));

        testotomasyonuPage.loginSayfasiPasswordKutusu
                            .sendKeys(ConfigReader.getProperty("toGecersizPassword"));

        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginSayfasiSubmitButonu
                            .click();

        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.loginSayfasiEmailKutusu.isDisplayed());

        Driver.quitDriver();

    }

    @Test
    public void gecersizEmailTesti(){

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        testotomasyonuPage = new TestotomasyonuPage();

        //2- account linkine basin
        testotomasyonuPage.accountLinki.click();

        //3-  3 farkli test method’u olusturun.
        //	- gecersiz email, gecerli password
        testotomasyonuPage.loginSayfasiEmailKutusu
                .sendKeys(ConfigReader.getProperty("toGecersizMail"));
        testotomasyonuPage.loginSayfasiPasswordKutusu
                .sendKeys(ConfigReader.getProperty("toGecerliPassword"));

        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginSayfasiSubmitButonu
                            .click();

        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.loginSayfasiEmailKutusu.isDisplayed());

        Driver.quitDriver();

    }

    @Test(groups = {"E2E","smoke","regression"})
    public void gecersizEmailGecersizPasswordTesti(){

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        testotomasyonuPage = new TestotomasyonuPage();

        //2- account linkine basin
        testotomasyonuPage.accountLinki
                            .click();

        //3-  3 farkli test method’u olusturun.
        //	- gecersiz email, gecersiz password.
        testotomasyonuPage.loginSayfasiEmailKutusu
                            .sendKeys(ConfigReader.getProperty("toGecersizMail"));
        testotomasyonuPage.loginSayfasiPasswordKutusu
                            .sendKeys(ConfigReader.getProperty("toGecersizPassword"));

        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginSayfasiSubmitButonu
                            .click();

        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.loginSayfasiEmailKutusu.isDisplayed());

        Driver.quitDriver();

    }

}
