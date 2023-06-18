package tag15_Fileupload_Wait;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;


public class C02_ExplicitWait extends TestBase {

    /*
https://the-internet.herokuapp.com/dynamic_loading/1
Klicken Sie auf die Start-Schaltfläche.
Überprüfen Sie, ob der Text "Hello World!" auf der Seite angezeigt wird.
*/

    @Test
    public void explicitWaitTest() {
        //        https://the-internet.herokuapp.com/dynamic_loading/1

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //        Klicken Sie auf die Start-Schaltfläche.
        ////button
        driver.findElement(By.xpath("//button")).click();

        //        Überprüfen Sie, ob der Text "Hello World!" auf der Seite angezeigt wird.


        //    Assert.assertTrue( driver.findElement(By.xpath("//div[@id='finish']//h4")).isDisplayed());
        //       Hier wurde ein implizites Warten verwendet
        // Erstellen eines Objekts der Klasse WebDriverWait mit einer Dauer von 20 Sekunden.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement helloWordText = wait.until(ExpectedConditions.//ekadar-until
                visibilityOfElementLocated(By.xpath("(//h4)[2]")));
        //2.WEG
        // WebElement helloWordTextZweiteWeg= wait.until(ExpectedConditions.visibilityOf(helloWordText));

        Assert.assertTrue(helloWordText.isDisplayed());


        // Finden des HTML-Elements mittels eines XPath-Ausdrucks und Warten, bis es sichtbar ist.
        //WebElement halloWeltText = warten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));

    /*
    Dieser Code erstellt ein WebElement-Objekt, das ein Tag (HTML-Element) auf einer Webseite darstellt,
    das durch einen bestimmten XPath-Ausdruck angegeben ist.
    Der Ausdruck ExpectedConditions.visibilityOfElementLocated wartet darauf,
    dass ein Element auf der Webseite sichtbar wird, das durch einen bestimmten By (XPath, ID usw.)
    definiert ist. Wenn das Element sichtbar wird, gibt diese Methode ein WebElement-Objekt zurück.

    Dieses Objekt wird dann der Variablen halloWeltText zugewiesen und
     kann zur einfacheren Verwendung des Elements verwendet werden.
      Über dieses WebElement-Objekt können Sie beispielsweise den Textinhalt
      oder andere Eigenschaften des Elements abrufen.
       Dies ist eine häufig verwendete Vorgehensweise bei der Arbeit mit Webseiten
       in Automatisierungstools wie Selenium.
    */

        // Überprüfen Sie die Sichtbarkeit des Elements
        //  Assert.assertTrue(halloWeltText.isDisplayed());


    }
}
