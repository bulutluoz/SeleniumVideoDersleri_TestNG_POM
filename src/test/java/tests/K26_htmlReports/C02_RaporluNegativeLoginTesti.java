package tests.K26_htmlReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;


public class C02_RaporluNegativeLoginTesti extends TestBaseRapor {

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
        extentTest = extentReports.createTest("Gecersiz Password Testi",
                "Kullanici gecerli email ve gecersiz password ile giris yapamamali");

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        testotomasyonuPage = new TestotomasyonuPage();
        extentTest.info("Kullanici testotomasyonu anasayfaya gider");

        //2- account linkine basin
        testotomasyonuPage.accountLinki.click();
        extentTest.info("account linkine basar");

        // 3-  3 farkli test method’u olusturun.
        //	- gecerli email, gecersiz password girin

        testotomasyonuPage.loginSayfasiEmailKutusu
                .sendKeys(ConfigReader.getProperty("toGecerliMail"));
        extentTest.info("Email kutusuna gecerli email'i yazar");

        testotomasyonuPage.loginSayfasiPasswordKutusu
                .sendKeys(ConfigReader.getProperty("toGecersizPassword"));
        extentTest.info("Password kutusuna gecersiz password'u yazar");

        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginSayfasiSubmitButonu
                .click();
        extentTest.info("Login butonuna basarak login olmayi dener");

        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.loginSayfasiEmailKutusu.isDisplayed());
        extentTest.info("Basarili olarak giris yapilamadigini test eder");

        extentTest.info("sayfayi kapatir");

    }

    @Test
    public void gecersizEmailTesti(){
        extentTest = extentReports.createTest("Gecersiz Email Testi",
                "Kullanici gecersiz email ve gecerli password ile giris yapamamali");

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotomasyonu anasayfaya gider");

        testotomasyonuPage = new TestotomasyonuPage();

        //2- account linkine basin
        testotomasyonuPage.accountLinki.click();
        extentTest.info("account linkine basar");

        //3-  3 farkli test method’u olusturun.
        //	- gecersiz email, gecerli password
        testotomasyonuPage.loginSayfasiEmailKutusu
                .sendKeys(ConfigReader.getProperty("toGecersizMail"));
        extentTest.info("Email kutusuna gecersiz email'i yazar");

        testotomasyonuPage.loginSayfasiPasswordKutusu
                .sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        extentTest.info("Password kutusuna gecerli password'u yazar");


        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginSayfasiSubmitButonu
                .click();
        extentTest.info("Login butonuna basarak login olmayi dener");


        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.loginSayfasiEmailKutusu.isDisplayed());
        extentTest.info("Basarili olarak giris yapilamadigini test eder");

        extentTest.info("sayfayi kapatir");

    }

    @Test
    public void gecersizEmailGecersizPasswordTesti(){
        extentTest = extentReports.createTest("Gecersiz Email ve gecersiz Password Testi",
                "Kullanici gecersiz email ve gecersiz password ile giris yapamamali");


        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotomasyonu anasayfaya gider");

        testotomasyonuPage = new TestotomasyonuPage();

        //2- account linkine basin
        testotomasyonuPage.accountLinki
                .click();
        extentTest.info("account linkine basar");

        //3-  3 farkli test method’u olusturun.
        //	- gecersiz email, gecersiz password.
        testotomasyonuPage.loginSayfasiEmailKutusu
                .sendKeys(ConfigReader.getProperty("toGecersizMail"));
        extentTest.info("Email kutusuna gecersiz email'i yazar");

        testotomasyonuPage.loginSayfasiPasswordKutusu
                .sendKeys(ConfigReader.getProperty("toGecersizPassword"));
        extentTest.info("Password kutusuna gecersiz password'u yazar");


        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginSayfasiSubmitButonu
                .click();
        extentTest.info("Login butonuna basarak login olmayi dener");


        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.loginSayfasiEmailKutusu.isDisplayed());
        extentTest.info("Basarili olarak giris yapilamadigini test eder");

        extentTest.info("sayfayi kapatir");

    }


}
