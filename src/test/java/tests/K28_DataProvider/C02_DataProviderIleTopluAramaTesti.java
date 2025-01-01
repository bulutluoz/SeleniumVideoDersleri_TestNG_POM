package tests.K28_DataProvider;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_DataProviderIleTopluAramaTesti {

    /*
        Data provider ile verilen bir listedeki her bir deger icin
        test method'unu bagimsiz olarak calistirabiliriz

        DataProvider ile test yapabilmek icin
        1- once test methodumuzu parametre ile calisacak sekilde
           tek bir urun icin yazalim

        2- Test method'una disardan bir dataProvider tanimlayalim

        3- yazdigimiz data provider isminin ustune yaklasip
           intelliJ'in data provider'i olusturmasini isteyelim

        4- data provider, @DataProvider notasyonuna sahip ozel bir method'dur
           MUTLAKA iki katli bir Object(Non-Primitive) Array DONDURMELIDIR
     */


    @DataProvider
    public static Object[][] aranacakUrunProvideri() {

        String[][] aranacakUrunler = {
                                        {"phone"}, {"java"}, {"dress"}, {"baby"}, {"nutella"},
                                        {"samsung"}, {"iphone"}, {"shirt"}
                                      };

        return aranacakUrunler;
    }

    @Test(dataProvider = "aranacakUrunProvideri")
    public void aramaTesti( String aranacakUrun ){

        // testotomasyonu sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        // arama kutusuna aranacakUrun'u yazdirip enter'a basin
        testotomasyonuPage.aramaKutusu.sendKeys(aranacakUrun + Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin
        String unExpectedSonucYazisi = ConfigReader.getProperty("toBulunamadiYazisi"); // 0 Products Found
        String actualAramaSonucYazisi = testotomasyonuPage.aramaSonucElementi.getText();

        Assert.assertNotEquals(actualAramaSonucYazisi,unExpectedSonucYazisi,
                aranacakUrun + " icin arama sonucu : " + actualAramaSonucYazisi);

        // sayfayi kapatin
        Driver.quitDriver();
    }
}
