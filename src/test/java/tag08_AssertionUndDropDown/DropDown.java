package tag08_AssertionUndDropDown;





import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class DropDown {
   /*
    Vorausgesetzt, der Benutzer befindet sich auf der Seite https://testcenter.techproeducation.com/index.php?page=dropdown
    -3 verschiedene Testmethoden
        1.Methode:
            a. Suchen Sie die Dropdown-Menüs für Jahr, Monat und Tag
            b. Erstellen Sie ein Select-Objekt
            c. Verwenden Sie das Select-Objekt, um auf 3 verschiedene Arten auszuwählen.
        2.Methode:
            a. Alle Staatsnamen drucken
        3.methode:
            a. Überprüfen Sie, ob die standardmäßig ausgewählte Option in der Dropdown-Liste "Staat auswählen" lautet

     */

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();//
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(" https://testcenter.techproeducation.com/index.php?page=dropdown");

    }

//    @After
//    public void tearDown() throws Exception {
//            driver.quit();
//    }

    @Test
    public void test01() throws InterruptedException {
      /*
       1.Method:
           a. Suchen Sie die Dropdown-Menüs für Jahr, Monat und Tag
            b. Erstellen Sie ein Select-Objekt
            c. Verwenden Sie das Select-Objekt, um auf 3 verschiedene Arten auszuwählen.


       */
        WebElement jahre = driver.findElement(By.xpath("//*[@id='year']"));
        Select select = new Select(jahre);
        Thread.sleep(2000);
        select.selectByIndex(5);//index beginnt  0  nimmt 5.
        //yil.sendKeys("2016");--> so kann ich klicken
        //driver.findElement(By.xpath("//*[@value='2016']")).click(); --> es ist auch möglich
        WebElement monat = driver.findElement(By.xpath("//*[@id='month']"));

        Select select1 = new Select(monat);
        Thread.sleep(2000);

        //select1.selectByVisibleText("April");
        select1.selectByValue("6");

        WebElement tag = driver.findElement(By.xpath("//*[@id='day']"));
        Select select2 = new Select(tag);
        Thread.sleep(2000);

        select2.selectByVisibleText("7");
    }

    @Test
    public void test02() {
//a. alles stadtsname

        WebElement allesStadt = driver.findElement(By.cssSelector("select[id='state']"));
        Select select = new Select(allesStadt);
        List<WebElement> stateList = select.getOptions();
        for (WebElement w : stateList) {
            System.out.println(w.getText());
        }
    }
    @Test
    public void test03() {

    }

}
