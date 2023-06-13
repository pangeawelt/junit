package tag11_BasicAuthenication_Cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;


import java.util.Set;

import utilities.TestBase;

public class C03_Cookies extends TestBase {
     /*Was ist ein Cookie?
    Cookies sind Informationsdateien,
    die vorübergehend im Browser angelegt werden.
    Cookies werden vorübergehend auf unserem Computer gespeichert.
    Cookies können eine Vielzahl von Informationen enthalten,
    darunter auch persönliche Daten.

    IM APP LIEGT COOKIES
    #auflisten ,
        * */

    @Test
    public void cookies() {
        // 1. Gehe zur Amazon Startseite
        driver.get("https://amazon.com");

        // 2. Liste alle Cookies auf
        Set<Cookie> cookieSet = driver.manage().getCookies();
        int zaehler = 1;
        for (Cookie c : cookieSet) {
            System.out.println(zaehler + ". Cookie: " + c);
            System.out.println("Name : " + c.getName());
            System.out.println("Wert : " + c.getValue());
            zaehler++;
        }
    /*    MIT LAMBDA
        Set<Cookie> cookieSet = driver.manage().getCookies();
        cookieSet.forEach(c -> {
            System.out.println(cookieSet.indexOf(c) + 1 + ". Cookie: " + c);
            System.out.println("Name : " + c.getName());
            System.out.println("Wert : " + c.getValue());
        });
*/
        // 3. Überprüfe, ob die Anzahl der Cookies größer als 5 ist
        int cookieAnzahl = cookieSet.size();
        Assert.assertTrue(cookieAnzahl > 5);

        // 4. Überprüfe, ob der Cookie mit dem Namen "i18n-prefs" den Wert "USD" hat
        String cookieValue = driver.manage().getCookieNamed("i18n-prefs").getValue();
        Assert.assertEquals("USD", cookieValue);

        // 5. Erstelle einen neuen Cookie namens "en sevdigim cookie" mit dem Wert "cikolatali" und füge ihn der Seite hinzu
        Cookie cookie = new Cookie("mein liebsten Cookie", "nutella");
        driver.manage().addCookie(cookie);

        // 6. Überprüfe, ob der hinzugefügte Cookie erfolgreich hinzugefügt wurde
        cookieSet = driver.manage().getCookies();
        zaehler = 1;
        for (Cookie c : cookieSet) {
            System.out.println(zaehler + ". Cookie: " + c);
            zaehler++;
        }

        // 7. Lösche den Cookie mit dem Namen "skin" und überprüfe, ob er erfolgreich gelöscht wurde

        int anzahlVorLoeschen = driver.manage().getCookies().size();
        driver.manage().deleteCookieNamed("skin");
        int anzahlNachLoeschen = driver.manage().getCookies().size();
        Assert.assertEquals(1, (anzahlVorLoeschen - anzahlNachLoeschen));
        cookieSet = driver.manage().getCookies();
        zaehler = 1;
        for (Cookie c : cookieSet) {
            System.out.println(zaehler + ". Cookie: " + c);
            zaehler++;
        }
        /* MIT LAMBDA
        int anzahlVorLoeschen = driver.manage().getCookies().size();
        driver.manage().deleteCookieNamed("skin");
        int anzahlNachLoeschen = driver.manage().getCookies().size();
        Assert.assertEquals(1, (anzahlVorLoeschen - anzahlNachLoeschen));
        driver.manage().getCookies().forEach(c -> System.out.println((driver.manage().getCookies().indexOf(c) + 1) + ". Cookie: " + c));
*/

        // 8. Lösche alle Cookies und überprüfe, ob sie erfolgreich gelöscht wurden
        driver.manage().deleteAllCookies();
        cookieSet = driver.manage().getCookies();
        Assert.assertTrue(cookieSet.isEmpty());
    }
}


