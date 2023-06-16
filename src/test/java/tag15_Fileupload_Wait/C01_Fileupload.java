package tag15_Fileupload_Wait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.network.model.DataReceived;
import utilities.TestBase;

import java.awt.*;

public class C01_Fileupload extends TestBase {


    @Test
    public void dateiUploadTest() throws AWTException {
/*
Gehen Sie zu https://the-internet.herokuapp.com/upload
Laden Sie die Datei logo.jpeg hoch
Überprüfen Sie, ob der Text "File Uploaded!" angezeigt wird

//immer zuerst manuell testen

Wenn wir auf einer Webseite eine Upload-Funktion durchführen müssen:
1- Wir lokalisieren das Webelement, auf das wir hochladen möchten
2- Wir weisen den Dateipfad, den wir hochladen werden, einer Zeichenfolge zu
3- Wir senden die Zeichenfolge mit dem Dateipfad an das lokalisierte Webelement mit der Methode sendkeys ()
*/

        //Gehen Sie zu https://the-internet.herokuapp.com/upload
        driver.get("https://the-internet.herokuapp.com/upload");
        //Laden Sie die Datei b129.txt hoch
        WebElement fileWahlWebElement=driver.findElement(By.xpath("//*[@id='file-upload']"));
        warte(3);
        String FilePath="C:\\Users\\Student\\OneDrive - GFN AG (EDU)\\Desktop\\Sogeti_Anschreiben.pdf";
       // System.getProperty("user.home")+"C:\\Users\\Student\\OneDrive - GFN AG (EDU)\\Desktop\\Sogeti_Anschreiben.pdf";
        fileWahlWebElement.sendKeys(FilePath);


        //String dateiPfad = System.getProperty("user.home")+"\\OneDrive\\Masaüstü\\b129.txt";

        //Bis hierhin ist es kein Test, um ein Test zu sein, muss eine Assertion vorhanden sein
        driver.findElement(By.id("file-submit")).click();

        //Überprüfen Sie, ob der Text "File Uploaded!" angezeigt wird
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());

        //Wenn SendKEYS nicht funktioniert dann kannst du Robot Objekt erreichen.
        //Robot rbt= new Robot();
        //rbt.keyPress();


    }
}
