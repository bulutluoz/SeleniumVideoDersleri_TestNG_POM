package tests.K23_testNG_Assertions;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_CokluAssertion {

    @Test
    public void ilkUrunIsimtesti(){

        // 1- testotomasyonu anasayfaya gidip
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // url'in testotomasyonu icerdigini test edin
        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik),"url verilen icerige sahip degil");

        // 2- nutella icin arama yapip
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.aramaKutusu.sendKeys("nutella" + Keys.ENTER);

        // urun bulunamadigini test edin
        //int actualBulunanUrunSayisi = testotomasyonuPage.bulunanUrunElementleriList
                                                        //.size();

        //Assert.assertEquals(actualBulunanUrunSayisi,0);
        // actual bulunan urun sayisi icin List kullanirsak
        // driver, list'e eklenecek WebElement bulmak icin
        // implicitly wait suresince bekleyecektir


        String actualAramaSonucYazisi = testotomasyonuPage.aramaSonucElementi
                                                            .getText();

        Assert.assertEquals(actualAramaSonucYazisi,ConfigReader.getProperty("toBulunamadiYazisi"));


        // 3- belirlenen arama kelimesi icin arama yapip
        testotomasyonuPage.aramaKutusu.sendKeys(ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER);

        // urun bulunabildigini test edin
        actualAramaSonucYazisi = testotomasyonuPage.aramaSonucElementi.getText();

        Assert.assertNotEquals(actualAramaSonucYazisi,ConfigReader.getProperty("toBulunamadiYazisi"));

        // 4- ilk urunu tiklayip,
        testotomasyonuPage.bulunanUrunElementleriList
                            .get(0)
                            .click();

        // urun isminde case sensitive olmadan aranacak kelime bulundugunu test edin

        String expectedIsimIcerik = ConfigReader.getProperty("toAranacakKelime");
        String actualUrunIsmi = testotomasyonuPage.ilkUrunSayfasindakiIsimElementi
                                                    .getText()
                                                    .toLowerCase();

        Assert.assertTrue(actualUrunIsmi.contains(expectedIsimIcerik));

        // 5- sayfayi kapatin

        Driver.quitDriver();


    }
}
