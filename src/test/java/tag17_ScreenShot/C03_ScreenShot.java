package tag17_ScreenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_ScreenShot extends TestBase {
    @Test
    public void classWork() {
// Gehen wir zur Techproeducation-Seite
        driver.get("https://techproeducation.com");
        warte(3);
        try {
// Wir schließen die Werbung
            driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

// Wir nehmen ein Screenshot der Seite
        ganzesSeitenbild();

// Wir suchen nach "Java" im Suchfeld
        driver.findElement(By.xpath("//input[@type='search']"))
                .sendKeys("Java", Keys.ENTER);

// Wir nehmen ein Screenshot des Suchergebnisses
        WebElement ergebnisText = driver.findElement(By.xpath("//h1"));
        screenShotWebElement(ergebnisText);

// Wir gehen zum Amazon in einem neuen Tab
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");

// Wir nehmen ein Screenshot der Amazon-Seite
        ganzesSeitenbild();

// Wir suchen nach "iPhone" im Suchfeld
        driver.findElement(By.id("twotabsearchtextbox"))
                .sendKeys("iPhone", Keys.ENTER);

// Wir nehmen ein Screenshot des Suchergebnisses
        WebElement ergebnisText2 = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        screenShotWebElement(ergebnisText2);

// Wir wechseln zurück zur Techproeducation-Seite und nehmen ein Screenshot
        window(0);
        ganzesSeitenbild();
    }

}
