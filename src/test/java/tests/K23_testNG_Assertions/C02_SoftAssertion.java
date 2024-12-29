package tests.K23_testNG_Assertions;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_SoftAssertion {

    @Test(groups = "E2E")
    public void ilkUrunIsimtesti(){

        // 1- testotomasyonu anasayfaya gidip
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        SoftAssert softAssert = new SoftAssert();

        // url'in testotomasyonu icerdigini test edin
        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertTrue(actualUrl.contains(expectedUrlIcerik),"url verilen icerige sahip degil");

        // 2- nutella icin arama yapip
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.aramaKutusu.sendKeys("nutella" + Keys.ENTER);

        String actualAramaSonucYazisi = testotomasyonuPage.aramaSonucElementi
                .getText();

        // arama sonucunda urun bulunamadigini test edin
        softAssert.assertEquals(actualAramaSonucYazisi,ConfigReader.getProperty("toBulunamadiYazisi"),
                "nutella icin arama sonucu beklenenden farkli");


        // 3- belirlenen arama kelimesi icin arama yapip
        testotomasyonuPage.aramaKutusu.sendKeys(ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER);

        // urun bulunabildigini test edin
        actualAramaSonucYazisi = testotomasyonuPage.aramaSonucElementi.getText();

        softAssert.assertNotEquals(actualAramaSonucYazisi,ConfigReader.getProperty("toBulunamadiYazisi"),
                "aranacak kelime arandiginda sonuc beklenenden farkli");

        // 4- ilk urunu tiklayip,
        testotomasyonuPage.bulunanUrunElementleriList
                .get(0)
                .click();

        // urun isminde case sensitive olmadan aranacak kelime bulundugunu test edin

        String expectedIsimIcerik = ConfigReader.getProperty("toAranacakKelime");
        String actualUrunIsmi = testotomasyonuPage.ilkUrunSayfasindakiIsimElementi
                .getText()
                .toLowerCase();

        softAssert.assertTrue(actualUrunIsmi.contains(expectedIsimIcerik),
                "Urun ismi aranacak kelimeyi icermiyor");

        softAssert.assertAll();

        // 5- sayfayi kapatin
        Driver.quitDriver();


    }

}
