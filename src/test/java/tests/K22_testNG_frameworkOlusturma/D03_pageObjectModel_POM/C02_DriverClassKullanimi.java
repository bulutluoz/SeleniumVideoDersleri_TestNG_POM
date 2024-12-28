package tests.K22_testNG_frameworkOlusturma.D03_pageObjectModel_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_DriverClassKullanimi {

    // uc farkli test method'u olusturun
    // testotomasyonu, wisequarter ve bestbuy sitelerine gidip
    // url'in bu kelimeleri icerdigini test edin
    // ve windowlari kapatin

    @Test
    public void testotomasyonuTest(){

        Driver.getDriver().get("https://www.testotomasyonu.com");

        String expectedurlIcerik = "testotomasyonu";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedurlIcerik));
        ReusableMethods.bekle(1);
        Driver.quitDriver();
    }

    @Test
    public void wisequarterTest(){

        Driver.getDriver().get("https://www.wisequarter.com");

        String expectedurlIcerik = "wisequarter";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedurlIcerik));
        ReusableMethods.bekle(1);
        Driver.quitDriver();
    }

    @Test
    public void bestbuyTest(){
        Driver.getDriver().get("https://www.bestbuy.com");

        String expectedurlIcerik = "bestbuy";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedurlIcerik));
        ReusableMethods.bekle(1);
        Driver.quitDriver();
    }
}
