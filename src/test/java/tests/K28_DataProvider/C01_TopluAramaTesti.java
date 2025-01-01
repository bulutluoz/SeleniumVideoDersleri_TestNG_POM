package tests.K28_DataProvider;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C01_TopluAramaTesti {

    @Test
    public void topluAramaTesti(){

        // testotomasyonu sayfasina gidin
        // verilen urunlerin herbiri icin arama yaptirip
        // arama sonucunda urun bulunabildigini test edin

        // phone, java, dress, baby, nutella, samsung, iphone, shirt

        List<String> aranacakUrunlerList = new ArrayList<>(Arrays.asList("phone", "java", "dress", "baby", "nutella", "samsung", "iphone", "shirt"));


        // testotomasyonu sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // verilen urunlerin herbiri icin arama yaptirip
        // arama sonucunda urun bulunabildigini test edin

        SoftAssert softAssert = new SoftAssert();
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

        for (String eachUrun : aranacakUrunlerList){

            testotomasyonuPage.aramaKutusu.sendKeys(eachUrun + Keys.ENTER);

            String unExpectedSonucYazisi = ConfigReader.getProperty("toBulunamadiYazisi"); // 0 Products Found
            String actualAramaSonucYazisi = testotomasyonuPage.aramaSonucElementi.getText();

            softAssert.assertNotEquals(actualAramaSonucYazisi,unExpectedSonucYazisi,
                    eachUrun + " icin arama sonucu : " + actualAramaSonucYazisi);
        }

        softAssert.assertAll();

        Driver.quitDriver();


     }
}
