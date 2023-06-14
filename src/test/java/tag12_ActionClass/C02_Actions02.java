package tag12_ActionClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions02 extends TestBase {

        /*
Gehen Sie zur Amazon-Startseite
Warten Sie auf "Account & List" (Maus über - hover over)
Klicken Sie auf den Link "Account" im geöffneten Menü
Bestätigen Sie, dass die geöffnete Seite den Titel "Ihr Konto" enthält.
 */

    @Test
    public void actions02() {
//        Gehen Sie zur Amazon-Startseite
        driver.get("https://www.amazon.com");

//        Warten Sie auf "Account & List" (Maus über - hover over)
        WebElement kontoUndListe = driver.findElement(By.id("nav-link-accountList"));
       // WebElement kontoUndListe = driver.findElement(By.xpath("//*[@class='nav-text']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(kontoUndListe).perform();//moveToElement() Methode führt "hover over" aus.
//        Klicken Sie auf den Link "Account" im geöffneten Menü
        driver.findElement(By.linkText("Konto")).click();

//        Bestätigen Sie, dass die geöffnete Seite den Titel "Ihr Konto" enthält.
        String seitenTitel = driver.getTitle();
        Assert.assertEquals("Ihr Konto", seitenTitel);

    }
}

