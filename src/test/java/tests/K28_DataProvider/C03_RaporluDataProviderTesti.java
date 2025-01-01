package tests.K28_DataProvider;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C03_RaporluDataProviderTesti  extends TestBaseRapor{


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

        extentTest = extentReports.createTest(aranacakUrun +" arama testi" ,
                "Kullanici " + aranacakUrun + " icin arama yaptiginda sonuc bulabilmeli");

        // testotomasyonu sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotomasyonu sayfasina gider");

        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        // arama kutusuna aranacakUrun'u yazdirip enter'a basin
        testotomasyonuPage.aramaKutusu.sendKeys(aranacakUrun + Keys.ENTER);

        extentTest.info(" arama kutusuna "+aranacakUrun+" yazdirip enter'a basar");

        // arama sonucunda urun bulunabildigini test edin
        String unExpectedSonucYazisi = ConfigReader.getProperty("toBulunamadiYazisi"); // 0 Products Found
        String actualAramaSonucYazisi = testotomasyonuPage.aramaSonucElementi.getText();

        Assert.assertNotEquals(actualAramaSonucYazisi,unExpectedSonucYazisi,
                aranacakUrun + " icin arama sonucu : " + actualAramaSonucYazisi);

        extentTest.pass("arama sonucunda urun bulunabildigini test eder");

        // sayfayi kapatin
        extentTest.info("sayfayi kapatir");
    }



}
