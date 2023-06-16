package tag15_Fileupload_Wait;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SogetiJobApplicationTest {


        private WebDriver driver;




        @AfterEach
        public void tearDown() {
            // Tarayıcıyı kapat
            driver.quit();
        }

        @Test
        public void testJuniorTestmanagerJobApplication() {

                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));



            // Sogeti web sitesine git ve Jobs & Karriere sayfasına tıkla
            driver.get("https://www.sogeti.de/");
            driver.findElement(By.linkText("Jobs & Karriere")).click();

            // 2. sayfaya git ve Junior Testmanager / Testkoordinator iş ilanına tıkla
            driver.findElement(By.linkText("2")).click();
            driver.findElement(By.linkText("Junior Testmanager / Testkoordinator")).click();

            // "Ich bin interessiert" düğmesine tıkla ve çerezleri kabul et (varsa)
            driver.findElement(By.xpath("//button[contains(text(),'Ich bin interessiert')]")).click();
            WebElement cookieBanner = driver.findElement(By.id("cookie-banner"));
            if(cookieBanner.isDisplayed()) {
                driver.findElement(By.linkText("Akzeptieren")).click();
            }

            // Başvuru formunun yüklenip yüklenmediğini doğrula
            String expectedTitle = "Bewerbung | Sogeti Deutschland GmbH";
            Assert.assertTrue(driver.getTitle().equals(expectedTitle));
        }
    }

