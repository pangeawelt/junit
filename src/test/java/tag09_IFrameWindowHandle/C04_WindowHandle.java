package tag09_IFrameWindowHandle;

import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C04_WindowHandle extends TestBase {


    @Test
    public void test01() {
        //Gehen Sie zu //https://the-internet.herokuapp.com/windows.
        driver.get("https://the-internet.herokuapp.com/windows");

        //Abrufen der ID (Fensterhandle-Wert) der ersten Seite.
        String firstPageWindowHandle = driver.getWindowHandle();

        //Prüfen, dass der Text auf der Seite "Neues Fenster öffnen" lautet.
        WebElement pageText = driver.findElement(By.xpath("//h3"));
        Assert.assertEquals("Ein neues Fenster öffnen", pageText.getText());

        //Prüfen, dass der Seitentitel "Das Internet" lautet.
        String actualTitle = driver.getTitle();
        Assert.assertEquals("Das Internet", actualTitle);

        //Klicken Sie auf die Schaltfläche "Hier klicken".
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();

        //Wechsel zu dem Fenster, das sich öffnet.
        /*
            Wenn wir auf eine Schaltfläche klicken, öffnet sich ein neues Fenster ohne unsere Kontrolle,
         Um die Webelemente in diesem Fenster zu behandeln, muss ich mit der Methode swichtto() umschalten
         aber da es außerhalb unserer Kontrolle geöffnet wird, kennen wir den Handle-Wert nicht, so dass alle geöffneten Fenster
         Wir ermitteln ein SET mit der Methode getWindowHandles(). Oder wir überprüfen eine ArrayList
         */
        Set<String> allleswindows = driver.getWindowHandles();
        for (
                String w : allleswindows) {
            if (!w.equals(firstPageWindowHandle)) {
                driver.switchTo().window(w);
            }
        }
        //Zweck dieser Funktion ist es,
        // zu dem Fenster zu wechseln,
        // das sich außerhalb unserer Kontrolle öffnet
/*
        List<String> allleswindows = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(allleswindows.get(1));
 */

        // Überprüfen, dass der Seitentitel des neuen Fensters "Neues Fenster" lautet.
        String actualtitle = driver.getTitle();
        Assert.assertEquals("New Window", actualtitle);
        String secondPageHandleDegree = driver.getWindowHandle();

        //Rückkehr zum vorherigen Fenster und Überprüfung,
        // dass der Seitentitel "Das Internet" lautet.
        driver.switchTo().window(firstPageWindowHandle);
        Assert.assertEquals("Das Internet", driver.getTitle());

        warte(3);

      //  Wieder zum 2.  Fenster wechseln.
        driver.switchTo().window(secondPageHandleDegree);

        warte(3);
        // Wieder zum 1. Fenster zurückkehren.
        driver.switchTo().window(firstPageWindowHandle);
    }
}
