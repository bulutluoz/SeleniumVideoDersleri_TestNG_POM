package tests.K25_paralelTestCalistirma;

public class C01_Gorevler {
    /*
         Paralel calistirma icin
         suite tag'ina 2 tane attribute eklememiz gerekiyor

         thread-count : ayni anda kac browser'in calisacagini belirler
         parallel : calisacak browser'lar arasinda gorev paylasim seviyesini belirler

        paylasim seviyesi method secilirse :
                her browser bir method'u calistirmaya baslar,
                method'u bitiren yeni bir method alir.

                Bu secimin negatif tarafi, birbirine bagli method'lar varsa
                bu method'lari farkli browser'lar calistirmak isteyebilir
                bu da testlerin FAILED olmasina sebep olur

        diger seviye alternatifleri class ve test bazinda paylasimdir

        En dogru secim test seviyesinde paylasim olacaktir
        Calisacak browserlarin mumkun oldugunca esit is yukune sahip olmasi
        ve mumkun oldugunca ayni surede islerini bitirmeleri icin
        calisacak class'lari biz browser'lara gore farkli testler olarak hazirlayabiliriz

        kullanilmasi zorunlu olmayan verbose attribute'u
        konsolda yazdirilan aciklama miktarini belirler
        1 en az aciklama
        10 en cok aciklama olmak uzere
        istenen deger yazilabilir
    */
    /*
        1- Smoke test icin asagida belirlenen class'lari
           class seviyesinde paralel olarak calistirin
            K22 D03 den C01
            K22 D04 den C03 ve C04
            K22 D05 den C02
            K22 D06 dan C01

        2- K23 package'indaki tum class'lari
           method seviyesinde paylasim ile paralel olarak calistirin

        3- Kullanici E2E testi icin asagida belirlenen methodlari
           test seviyesinde paylasim ile paralel calistirin
            K22 D04 den C01'deki positiveLoginTesti
            K22 D05 den C02'deki gecersizEmailGecersizPasswordTesti
            K22 D06 dan C01'deki alisverisTesti
            K23 C02'deki ilkUrunIsimtesti

        4- Regression testi icin framework'deki tum testleri
           class seviyesinde paylasim ile paralel calistirin

     */


}
