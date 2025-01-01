package tests.K28_DataProvider;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_TopluNegativeLoginTesti {

    //1- https://www.testotomasyonu.com/ anasayfasina gidin
    //2- account linkine basin
    //3- asagidaki listede verilen email ve sifreleri yazin
    //4- Login butonuna basarak login olmayi deneyin
    //5- Basarili olarak giris yapilamadigini test edin
    //   anil@hotmail.com  13579 , ceren@gmail.com 24680 , cansu@yahoo.com asdfgh


    @DataProvider
    public static Object[][] TestDataProvideri() {

        String[][] kullaniciBilgileriArr = {
                                                {"anil@hotmail.com", "13579"},
                                                {"ceren@gmail.com", "24680"},
                                                {"cansu@yahoo.com","asdfgh"}
                                            };

        return kullaniciBilgileriArr;
    }

    @Test(dataProvider = "TestDataProvideri")
    public void negatifLoginTesti(String verilenEmail , String verilenSifre){

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        //2- account linkine basin
        testotomasyonuPage.accountLinki
                            .click();

        //3- parametre olarak verilen email ve sifreleri yazin
        testotomasyonuPage.loginSayfasiEmailKutusu.sendKeys(verilenEmail);
        testotomasyonuPage.loginSayfasiPasswordKutusu.sendKeys(verilenSifre);

        ReusableMethods.bekle(3);
        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginSayfasiSubmitButonu
                            .click();

        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.loginSayfasiEmailKutusu.isDisplayed());

        //6- sayfayi kapatin
        Driver.quitDriver();
    }
}
