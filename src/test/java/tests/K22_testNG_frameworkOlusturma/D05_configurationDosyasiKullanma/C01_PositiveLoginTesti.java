package tests.K22_testNG_frameworkOlusturma.D05_configurationDosyasiKullanma;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_PositiveLoginTesti {

    @Test
    public void positiveLoginTesti(){
        /*
            Testlerimizi DINAMIK yapmak
            ve test datalarina KOLAY ERISMEK icin
            test datalarini configuration.properties dosyasina yazip
            ihtiyacimiz oldugunda oradan almak istiyoruz

            Java ile o bilgilere ulasmak icin
            once dosya yolunu almamiz
            sonra oradaki bilgileri okumamiz
            bilgiler icerisinde ihtiyacimiz olan "toUrl", "toGecerliEmail"
            gibi bilgileri diger bilgilerden ayirip
            alip bu test class'ina getirmemiz tek satirla olabilecek bir islem degildir

            Bu uzun islemi bizim adimiza yapip
            verdigimiz "toUrl", "toGecerliEmail" gibi key'lerin
            karsisindaki value'leri alip bize getirecek hazir bir method olusturalim
         */

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // 2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLinki
                            .click();

        // 3- Kullanici email'i olarak wise@gmail.com girin
        testotomasyonuPage.loginSayfasiEmailKutusu
                            .sendKeys(ConfigReader.getProperty("toGecerliMail"));

        // 4- Kullanici sifresi olarak 12345 girin
        testotomasyonuPage.loginSayfasiPasswordKutusu
                            .sendKeys(ConfigReader.getProperty("toGecerliPassword"));

        // 5- Login butonuna basarak login olun
        testotomasyonuPage.loginSayfasiSubmitButonu
                            .click();

        // 6- Basarili olarak giris yapilabildigini test edin
        Assert.assertTrue(testotomasyonuPage.logoutButonu.isDisplayed());

        // 7- logout olun
        testotomasyonuPage.logoutButonu.click();

        // 8- sayfayi kapatin
        Driver.quitDriver();

    }

}
