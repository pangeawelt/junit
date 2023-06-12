package tag10_HandleAlerts;

import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

public class C01_Allert extends TestBase {
/*Was ist eine Warnung/Allert? Ein Alert ist ein kleines Meldungsfeld,
 das eine Benachrichtigung auf dem Bildschirm anzeigt,
  um dem Benutzer eine Information oder die Erlaubnis
   zur Durchführung einer bestimmten Aktion zu geben.
   Es kann auch als Warnung verwendet werden.
   HTMLAlerts
    Wenn wir mit einem Rechtsklick prüfen können,
   wann ein Alert erscheint, handelt es sich um einen html-Alert
   und es ist keine zusätzliche Aktion erforderlich.
 JsAlerts
 Js-Warnungen können nicht inspiziert werden,
 sie benötigen eine zusätzliche Verarbeitung.
//Wenn kein rechtklik gibt
accept( ) => Dasselbe wie das Klicken auf OK bei einer Meldung.
            driver.switchTo( ).alert( ).accept( );
    dismiss() => Entspricht dem Klicken auf Abbrechen bei einer Warnmeldung.
            driver.switchTo( ).alert( ).dismiss();
 ●getText() => Zum Abrufen der Nachricht in einer Meldung.
            driver.switchTo( ).alert( ).getText();
 ●sendKeys("Text") => So senden Sie Text an das Textfeld der Warnmeldung
 driver.switchTo( ).alert( ).sendKeys("Text");
*/

    String webseite = "https://testcenter.techproeducation.com/index.php?page=javascript-alerts";

    @Test
    public void acceptAlert() throws InterruptedException {
        //Erstellen Sie eine Klasse:Alerts
        // ● Gehen Sie zu https://testcenter.techproeducation.com/index.php?page=javascript-alerts.
        driver.get(webseite);
        // Erstellen Sie eine Methode:// acceptAlert
        // ○1. Klicken Sie auf die Schaltfläche, klicken Sie auf die Schaltfläche OK
        // für die Meldung und testen Sie, ob die Ergebnismeldung
        // "Sie haben erfolgreich auf eine Meldung geklickt" lautet.
        //WebElement simpleElement=driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        driver.switchTo().//verpasst,verändern
                alert().  //Alert stellt um
                accept();//nach der Alert OK klickt
        Thread.sleep(2000);
        String actualText = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedText = "You successfully clicked an alert";
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void dismissAlert() throws InterruptedException {
        // Erstellen Sie eine Methode:dismissAlert
        // ○2. Klicken Sie auf die Schaltfläche,
        // klicken Sie auf die Schaltfläche Abbrechen für die Meldung und testen Sie,
        // ob die Ergebnismeldung "Sie haben geklickt:
        // Abbrechen".
        driver.get(webseite);
        // onclick="jsConfirm()" button[onclick='jsConfirm()'];
        driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();
        // enthält "succesfuly" oder?
        driver.findElement(By.xpath("//*[@id='result']"));
        String actualText = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String exceptedText = "succesfuly";
        Assert.assertFalse(actualText.contains(exceptedText));
    }

    @Test
    public void sendKeysAlert() throws InterruptedException {

        driver.get(webseite);
        driver.findElement(By.cssSelector("body > main > div > div.col-md-8 > div > button:nth-child(5)")).click();
        driver.switchTo().alert().sendKeys("Gani");
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        String actualText = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String exceptedText = "You entered: Gani\n" +"\n" ;
        Assert.assertFalse(actualText.contains(exceptedText));


        // Erstellen Sie eine Methode:sendKeysAlert
        // ○3. klicken Sie auf die Schaltfläche,
        // geben Sie Ihren Namen in das Textfeld in der Meldung ein, klicken Sie auf
        // OK und überprüfen Sie, ob Ihr Name in der Ergebnismeldung angezeigt wird.
    }
}

