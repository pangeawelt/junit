package tag16_Exception;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C04_StaleElementReferanceException extends TestBase {
    //Driver ist gleich und element auch aber XPath ist nicht funktioniert.

/*
        StaleElementReferenceException:
               Sie tritt auf, wenn die Gültigkeit eines Webelements auf einer Webseite verloren geht.
            Mit anderen Worten, wenn wir nach dem Auffinden eines Webelements die Seite aktualisieren oder zurückspulen.
            Wenn wir erneut auf dieses Element zugreifen wollen, erhalten wir diesen Fehler. Um dies zu beheben
            Wir müssen dem Webelement denselben Locate erneut zuweisen (wir können sagen, dass wir den Locate des Webelements erinnern)
     */

    @Test
    public void staleElementExceptionTest() {

        driver.get("https://www.techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        driver.navigate().refresh();

        WebElement lmsLogin = driver.findElement(By.linkText("LMS LOGIN"));
        lmsLogin.click();//funktioniert

    }

    @Test
    public void staleElementExceptionTest2() {

        driver.get("https://www.techproeducation.com");
        warte(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        WebElement lmsLogin = driver.findElement(By.linkText("LMS LOGIN"));
        lmsLogin.click();
        driver.navigate().refresh();
        //login clik
        lmsLogin.click();//org.openqa.selenium.StaleElementReferenceException
        //nach der Locat nimmt wurde Seite gefrischt dann wurde gelickt.kommt exception

    }

    @Test
    public void staleElementExceptionTest3() {

        driver.get("https://www.techproeducation.com");
        warte(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        WebElement lmsLogin = driver.findElement(By.linkText("LMS LOGIN"));
        lmsLogin.click();
        driver.navigate().refresh();
         lmsLogin = driver.findElement(By.linkText("LMS LOGIN"));
        //login clik
        lmsLogin.click();//
        //nach der Locat nimmt wurde Seite gefrischt dann wurde gelickt.kommt exception

    }
    @Test
    public void staleElementReferanceExceptionTest6odev() {


        driver.get("https://amazon.com");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //5 Iphone reheinfolgw
        List<WebElement> sache = driver.findElements(By.xpath("//h2"));
        for (int i = 0; i < sache.size(); i++) {
            sache.get(i).click();
            warte(3);
            driver.navigate().back();
            warte(3);
            if (i == 4) {
                break;
            }
        }
    }


}
