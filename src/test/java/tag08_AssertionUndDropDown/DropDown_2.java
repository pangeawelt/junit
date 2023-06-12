package tag08_AssertionUndDropDown;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class DropDown_2 extends TestBase {


    @Test
    public void test01() {
        driver.get(" https://testcenter.techproeducation.com/index.php?page=dropdown");

      /*
       1.Methode;
            a. Jahre,Monat,Tag Locat nimmt
            b. Select Objekt erzeugt

         */
    WebElement jahre = driver.findElement(By.xpath("//*[@id='year']"));
    Select select = new Select(jahre);
        select.selectByIndex(5);//index beginnt = 0
        warte(2);
    //jahre.sendKeys("2016");--> auch wahlen
    //driver.findElement(By.xpath("//*[@value='2016']")).click(); --> auch wahlen
    WebElement monat = driver.findElement(By.xpath("//*[@id='month']"));
    Select select1 = new Select(monat);
    //select1.selectByVisibleText("April");
        select1.selectByValue("6");
        warte(2);
    WebElement tag = driver.findElement(By.xpath("//*[@id='day']"));
    //   Select select2 = new Select(tag);
     //   select2.selectByVisibleText("7");
    // man kann auch mit Utilsmethode aufrufen

        ddmVisibleText(tag,"7");
        warte(2);

}
}
