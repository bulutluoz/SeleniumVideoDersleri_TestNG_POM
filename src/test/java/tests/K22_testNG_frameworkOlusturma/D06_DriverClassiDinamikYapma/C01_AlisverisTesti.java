package tests.K22_testNG_frameworkOlusturma.D06_DriverClassiDinamikYapma;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;


public class C01_AlisverisTesti {

    @Test(groups = "E2E")
    public void alisverisTesti(){

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        //2- belirlenmis arama kelimesi icin arama yapin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

        testotomasyonuPage.aramaKutusu
                .sendKeys(ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER);

        //3- Listelenen sonuclardan ilkini tiklayin
        testotomasyonuPage.bulunanUrunElementleriList
                            .get(0)
                            .click();

        //4- urun ismini kaydedin ve urunu sepete ekleyin
        String ilkUrunIsmi = testotomasyonuPage.ilkUrunSayfasindakiIsimElementi
                                                .getText();

        testotomasyonuPage.addToCartButonu
                            .click();

        //5- your cart linkine tiklayin
        testotomasyonuPage.yourCartElementi
                            .click();

        //6- kaydettiginiz urun ismi ile sepetteki urun isminin ayni oldugunu test edin
        String sepettekiUrunIsmi = testotomasyonuPage.sepettekiUrunIsimElementi.getText();

        Assert.assertEquals(sepettekiUrunIsmi,ilkUrunIsmi);

        //7- sayfayi kapatin
        Driver.quitDriver();


    }
}
