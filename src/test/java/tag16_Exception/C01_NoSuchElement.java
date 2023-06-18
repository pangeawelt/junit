package tag16_Exception;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C01_NoSuchElement extends TestBase {
    /*
      NoSuchElementException;
          -This tritt auf, wenn versucht wird, auf ein Element zuzugreifen, das sich nicht auf der Seite befindet
       */

    @Test
    public void NoSuchElementException() {
   // Rufen wir die Seite //techproeducation auf
        driver.get("https://techproeducation.com");
    warte(5);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();//Um eine Anzeige zu schließen

  //  Suchen wir das Element //SearchBox
        driver.findElement(By.xpath("/html/body/div[1]/section[1]/div/div[2]/div/div/div/form")).sendKeys("java",Keys.ENTER);
}
}
