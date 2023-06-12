package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;


import java.time.Duration;

public abstract class TestBase {

    // Wir möchten verhindern,dass ein Objekt von testBase zu erzuegen deswegen ABSTRACT
    //


    protected static WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws InterruptedException {
       warte(3);
       driver.quit();
    }

    public static void warte(int sekunde) {
        try {
            Thread.sleep(sekunde * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
