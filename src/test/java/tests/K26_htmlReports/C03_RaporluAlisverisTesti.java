package tests.K26_htmlReports;


import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C03_RaporluAlisverisTesti extends TestBaseRapor {

    @Test
    public void alisverisTesti(){

        extentTest = extentReports.createTest("Alisveris Testi",
                "Kullanici sectigi urunun sepete eklendigini test eder");

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotomasyonu anasayfaya gider");

        //2- belirlenmis arama kelimesi icin arama yapin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

        testotomasyonuPage.aramaKutusu
                .sendKeys(ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER);
        extentTest.info("belirlenmis arama kelimesi icin arama yapar");

        //3- Listelenen sonuclardan ilkini tiklayin
        testotomasyonuPage.bulunanUrunElementleriList
                .get(0)
                .click();
        extentTest.info("Listelenen sonuclardan ilkini tiklar");

        //4- urun ismini kaydedin ve urunu sepete ekleyin
        String ilkUrunIsmi = testotomasyonuPage.ilkUrunSayfasindakiIsimElementi
                .getText();
        extentTest.info("urun ismini kaydeder");

        testotomasyonuPage.addToCartButonu
                .click();
        extentTest.info("urunu sepete ekler");

        //5- your cart linkine tiklayin
        testotomasyonuPage.yourCartElementi
                .click();
        extentTest.info("your cart linkine tiklar");

        //6- kaydettiginiz urun ismi ile sepetteki urun isminin ayni oldugunu test edin
        String sepettekiUrunIsmi = testotomasyonuPage.sepettekiUrunIsimElementi.getText();
        ReusableMethods.bekle(1);

        Assert.assertEquals(sepettekiUrunIsmi,ilkUrunIsmi);
        extentTest.pass("kaydettigi urun ismi ile sepetteki urun isminin ayni oldugunu test eder");

        //7- sayfayi kapatin
        extentTest.info("sayfayi kapatir");

    }

}
