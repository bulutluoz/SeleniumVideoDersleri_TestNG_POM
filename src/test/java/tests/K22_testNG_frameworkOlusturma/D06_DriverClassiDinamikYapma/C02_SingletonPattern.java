package tests.K22_testNG_frameworkOlusturma.D06_DriverClassiDinamikYapma;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import javax.swing.*;

public class C02_SingletonPattern {

    @Test
    public void test01(){

        /*
            Page Object Model'i dizayn edenler
            Driver class'indan getDriver() yerine farkli kullanimlarin onune gecmek icin

            Bir class'dan obje olusturulabilmesini ENGELLEMEK icin
            kullanilabilecek farkli yontemler var
            POM'i hazirlayanlar bu alternatifler icerisinde
            Singleton pattern'i tercih etmisler

            Singleton pattern
            obje olusturmayi engellemek icin Constructor'i sinirlama
            uzerine kurulmustur.

            Boylece Driver class'ini istenen yontem disinda
            obje olusturularak KULLANILAMAZ

         */


        // testotomasyon anasayfaya gidin
        // Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // Driver obje = new Driver();
        // 'Driver()' has private access in 'utilities.Driver'

        // obje.getDriver().get(ConfigReader.getProperty("toUrl"));
        // bu sekilde de kullanabildik

        // obje.driver.get(ConfigReader.getProperty("toUrl"));
        // NullPointerException


    }
}
