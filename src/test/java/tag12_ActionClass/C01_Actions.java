package tag12_ActionClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;


/*Mit Aktionen Klasse I Maus und Tastatur werden Operationen durchgeführt.
2 Tipp ;
##Mausbasierte Aktionen:
Doppelklick, Rechtsklick, klicken und halten, ziehen und ablegen, über ein Element bewegen usw., scrollen.
##Tastatur-basierte Aktionen:
Umschalt-, Strg- und Alt-Tasten.
Actions hat viele nützliche Maus- und Tastaturfunktionen*/
public class C01_Actions extends TestBase {
    @Test
    public void actions() {
        // Gehen Sie zur Website https://the-internet.herokuapp.com/context_menu
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //  Klicken Sie mit der rechten Maustaste auf das Feld
        // Die Methode contextClick() wird für den Rechtsklick benötigt. Hierfür muss ein Actions-Objekt erstellt werden.
        // Schritt 1: Erstellen Sie ein Actions-Objekt.
       Actions actions= new Actions(driver);


        //Schritt 2: Suchen Sie das WebElement "hot-spot", an dem die Aktion durchgeführt werden soll.
        WebElement box=driver.findElement(By.id("hot-spot"));

        warte(2);
        // Schritt 3: Führen Sie die Aktion aus.
        actions.
                contextClick(box).
                perform();
         //Die perform()-Methode sollte zuletzt aufgerufen werden.

        // Testen Sie, ob der angezeigte Text im Alarm "You selected a context menu" ist
        String alerttext = driver.switchTo().alert().getText();
        Assert.assertEquals("You selected a context menu", alerttext);
        warte(2);
        // Klicken Sie auf OK, um den Alarm zu schließen
        driver.switchTo().
                alert().
                accept();
        // alertAccept aus TestBAse kann man direkt aufrufen.

    }


}
