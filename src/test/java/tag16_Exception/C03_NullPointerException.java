package tag16_Exception;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_NullPointerException extends TestBase {
    /*
NullPointerException:
Wenn wir eine Variable oder ein Objekt erstellen und dieser Variable keinen Wert zuweisen oder diesen nicht gleichsetzen
erhalten wir eine NullPointerException-Ausnahme
*/
    WebDriver fahrer;
    Faker faker;
    Actions aktionen;
    Integer zahl;
    int nummer;
    Integer nummer2;
    String name;

    @Test
    public void NullPointerExceptionTest1() {
        //driver=new ChromeDriver(); da wir diese Zuweisung nicht gemacht haben (Null-Objekt) bekommen wir diesen Fehler
        driver.get("https://amazon.com");//java.lang.NullPointerException
        //Wir erhalten eine java.lang.NullPointerException-Ausnahme, da wir keine Zuweisung für unser driver-Objekt vorgenommen haben
        //Es wird keine cte-Fehlermeldung angezeigt, da dies keine Java-Bibliothek ist.
    }

    @Test
    public void NullPointerExceptionTest2() {
        //faker = new Faker(); da wir diese Zuweisung nicht durchgeführt haben, erhalten wir diesen Fehler
        System.out.println(faker.number().numberBetween(1, 10));//java.lang.NullPointerException
    }

    @Test
    public void NullPointerExceptionTest3() {
        //actions = new Actions(driver); da wir diese Zuweisung nicht durchgeführt haben, erhalten wir diesen Fehler
        aktionen.doubleClick().perform();//java.lang.NullPointerException
    }

    @Test
    public void NullPointerExceptionTest4() {
        //Da der Wert der Variablen zahl nicht zugewiesen wurde, haben wir die java.lang.NullPointerException-Ausnahme erhalten
        //zahl=5;
        System.out.println(zahl+5);

        //Wir erhalten eine NullPointerException-Ausnahme, wenn diese Codezeile und danach dieser Fehler aufgrund von Java-Bibliotheken nicht angezeigt wird.
    }

    @Test
    public void NullPointerExceptionTest5() {
        //Da der Wert der Variablen isim nicht zugewiesen wurde, haben wir die java.lang.NullPointerException-Ausnahme erhalten
        //isim="Gani";
        System.out.println(name.charAt(0));
    }

    @Test
    public void NullPointerExceptionTest6() {
        System.out.println(nummer + 6);
    }
//Keine NullPointerException erhalten, da das Ergebnis der Addition 6 ist
//weil der Wert von primitiven Datentypen "0" ist, wenn er nicht zugewiesen wird


    @Test
    public void NullPointerExceptionTest7() {
        System.out.println(nummer2 +6);
    }//NullPointerException erhalten, da der Wert von nicht primitiven Datentypen null ist, wenn er nicht zugewiesen wird
}

