package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    private Driver(){
        // Driver constructor'ini gorunur yapip
        // access modifier olarak private belirlendigi icin
        // bu class'dan kimse obje olusturamaz
        // (Singleton Pattern)
    }

    public static WebDriver driver;

    public static WebDriver getDriver(){

        String kullanilacakBrowser = ConfigReader.getProperty("browser");

        if (driver == null){


            switch (kullanilacakBrowser){

                case "firefox" :
                    driver = new FirefoxDriver();
                    break;

                case "edge" :
                    driver = new EdgeDriver();
                    break;

                case "safari" :
                    driver = new SafariDriver();
                    break;

                default:
                    driver = new ChromeDriver();

            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        return driver;
    }


    public static void quitDriver(){
        driver.quit();
        driver = null;
    }



}
