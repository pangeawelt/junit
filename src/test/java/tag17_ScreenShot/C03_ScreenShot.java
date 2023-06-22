package tag17_ScreenShot;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
        //ergebnistext zuzeigen
        String ergebnis= driver.findElement(By.xpath("//*[@class='a-color-state a-text-bold']")).getText();

        Assert.assertEquals("\"iPhone\"",ergebnis);

        //klicken erste Ergbenis
        driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/div/div/div/div/div/div[1]/div/div[2]/div/span/a/div/img")).click();
       WebElement erstepreis= driver.findElement(By.xpath("(//*[@class='a-offscreen'])[1]"));
        //*[@class='a-offscreen'])[1]
        Assert.assertEquals("149,99$",erstepreis);



    }




}
