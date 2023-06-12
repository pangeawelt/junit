package tag09_IFrameWindowHandle;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;


import java.util.Set;

import static org.junit.Assert.assertEquals;

public class C02_WindowHandle extends TestBase {
    /*


     */

    @Test
    public void windowHandle() {

        // Gehe zu https://the-internet.herokuapp.com/windows.
        driver.get("https://the-internet.herokuapp.com/windows");
        // Ermitteln Sie die ID der ersten Seite.
        String window1Handle=driver.getWindowHandle();
        System.out.println("window1Handle = " + window1Handle);
        // Überprüfen Sie, ob der Text auf der Seite "Opening a new window" lautet.
        // //h3[@]
        WebElement window1Text=driver.findElement((By.xpath("//h3[.='Opening a new window']")));
        assertEquals("HAat nicht gefunden","Opening a new window",window1Text.getText());

        // Prüfen Sie, ob der Seitentitel "Das Internet" lautet.
        String webseitetitle=driver.getTitle();
        assertEquals("The Internet",webseitetitle);
        // Klicken Sie auf die Schaltfläche "Hier klicken".
        driver.findElement(By.linkText("Click Here")).click();
        warte(3);

        // Wechseln Sie zu dem Fenster, das sich öffnet.
        //in diesem Seite öffnet 2 Webseite  dann wählt 2.Seite
        // im Sett unquie
        Set<String> allWindowshandle=driver.getWindowHandles();
        System.out.println("allWindowshandle = " + allWindowshandle);
        for (String w: allWindowshandle){
            if(!w.equals(window1Handle)){
               driver.switchTo().window(w);//wenn passt wird The Internet dh erste Windowshandle
            }
        }

        // Überprüfen Sie, ob der Seitentitel des neuen Fensters "Neues Fenster" lautet.
        assertEquals("New Window", driver.getTitle());
        String window2handle=driver.getWindowHandle();
        // Gehen Sie zurück zum vorherigen Fenster und überprüfen Sie, ob der Seitentitel "Das Internet" lautet.
        warte(2);
     driver.switchTo().window(window1Handle);
     assertEquals("Falsche Windowshandle","The Internet",driver.getTitle());

        // Wechseln Sie zurück zum 2. Fenster.
        warte(2);
        driver.switchTo().window(window2handle);

        // Gehen Sie zurück zu Fenster 1.
        warte(2);
        driver.switchTo().window(window1Handle);



    }
}
