package tag11_BasicAuthenication_Cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.devtools.v85.network.model.DataReceived;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Set;

public class C02_Cookies extends TestBase {
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
        driver.get("https://www.amazon.com");

        //listet alles cookies auf.
        //umaufzulisten brauche ich driver.manage().getCookies()
        Set<Cookie> allesCookies = driver.manage().getCookies();
        int counter = 1; //schalter
        for (Cookie w : allesCookies
        ) {
            System.out.println(counter + ". Cookie: " + w);
            System.out.println("Name  :" + w.getName());
            System.out.println("Value : " + w.getValue());
            counter++;
        }

        /*mit LAMBDA
        driver.manage().getCookies()
                .forEach(w -> {
                    System.out.println(counter+". Cookie: "+w);
                    System.out.println("Name  :"+ w.getName());
                    System.out.println("Value : "+ w.getValue());
                    counter++;
                });
         */

        //testet bitte anzahl der cookies>5
        int anzahlcookies = allesCookies.size();
        Assert.assertTrue(anzahlcookies > 5);

        // name: i18n-prefs und Value USD überprüft ,ob richtig ist.
    String cookieValue= driver.manage().getCookieNamed("i18n-prefs").getValue();
    //String cookieValue =--->USD
    Assert.assertEquals("USD",cookieValue);


    /* ALTE VERSION NACH DER JAVA17 wurde ASSERTTHAT nicht mehr verwendet ;
    mit assertThat; assertThat(actual).isEqualTo(expected)
    assertThat(driver.manage().getCookieNamed("i18n-prefs").getValue()).isEqualTo("USD");
     "isNotEqualTo()", "isGreaterThan()", "isLessThan() auch möglich
     * */
    // eine Cooike Objekt erzeugt und fügt im Webseite ein
        Cookie cookie=new Cookie("meine liebslten cookie ","nutlla");
        driver.manage().addCookie(cookie);
        //testet richtig wurde eingefügt..

        allesCookies=driver.manage().getCookies();
        counter=1;
        for (Cookie cookie1:allesCookies){
            System.out.println(counter+". cookie "+cookie1);
            counter++;
        }




}
}
