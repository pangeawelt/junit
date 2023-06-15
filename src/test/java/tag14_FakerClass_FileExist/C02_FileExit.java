package tag14_FakerClass_FileExist;

import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileExit extends TestBase {
    @Test
    public void fileExistTest1() {

        String benutzerDIR = System.getProperty("user.dir");//C:\Users\TechProEd\IdeaProjects\B129SeleniumMavenJunit
        //Gibt den Pfad des IDE-Projekts dynamisch zurück

        String benutzerHOME = System.getProperty("user.home");//C:/Users/TechProEd(Benutzername)
        //Gibt den Benutzernamen dynamisch zurück

        //boolean isExist = Files.exists(Paths.get("C:/Users/Zbook/Desktop/logo.jpeg"));
        // System.out.println("isExist = " + isExist);

        String benutzerHome = System.getProperty("user.home");//Hilft dabei, die Adresse mit dem Benutzernamen zu erhalten.
        boolean existiert = Files.exists(Paths.get(benutzerHome + "/Desktop/logo.jpeg"));
        //"Paths.get()" Methode wird verwendet, um ein "Path" Objekt zu erstellen, das den vollständigen Pfad
        // einer Datei oder eines Ordners darstellt und während der Dateiverarbeitung verwendet werden kann.
        System.out.println("existiert = " + existiert);
        Assert.assertTrue(existiert);
        //Ich möchte, dass es vorhanden ist. Wenn ich es nicht wollte, würde ich assertFalse verwenden.

         /*
    Wenn fehlgeschlagen: Die Datei ist nicht auf dem Desktop vorhanden, der Dateiname ist falsch oder
    es gibt zusätzliche Dateien wie OneDrive dazwischen.
     */
    }

    @Test
    public void fileExistTest() {

        String benutzerDIR = System.getProperty("user.dir");//C:\Users\TechProEd\IdeaProjects\B129SeleniumMavenJunit
        //Gibt den Pfad des IDE-Projekts dynamisch zurück

        String benutzerHOME = System.getProperty("user.home");//C:/Users/TechProEd(Benutzername)
        //Gibt den Benutzernamen dynamisch zurück

        //boolean isExist = Files.exists(Paths.get("C:/Users/Zbook/Desktop/logo.jpeg"));
        // System.out.println("isExist = " + isExist);

        String benutzerHome = System.getProperty("user.home");//Hilft dabei, die Adresse mit dem Benutzernamen zu erhalten.
        boolean existiert = Files.exists(Paths.get(benutzerHome + "/Desktop/logo.jpeg"));
        //"Paths.get()" Methode wird verwendet, um ein "Path" Objekt zu erstellen, das den vollständigen Pfad
        // einer Datei oder eines Ordners darstellt und während der Dateiverarbeitung verwendet werden kann.
        System.out.println("existiert = " + existiert);
        Assert.assertTrue(existiert);
        //Ich möchte, dass es vorhanden ist. Wenn ich es nicht wollte, würde ich assertFalse verwenden.

         /*
    Wenn fehlgeschlagen: Die Datei ist nicht auf dem Desktop vorhanden, der Dateiname ist falsch oder
    es gibt zusätzliche Dateien wie OneDrive dazwischen.
     */
    }
}
