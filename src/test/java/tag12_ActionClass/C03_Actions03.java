package tag12_ActionClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Actions03 extends TestBase {
    @Test
    public void actions() {
//Gehe zur Adresse https://techproeducation.com
        driver.get("https://techproeducation.com");
        warte(2);
//Klicke auf das Schließen-Icon
        driver.findElement(By.xpath("//*[@class='eicon-close']"))
                .click();
//Gehe zum unteren Teil der Seite
        Actions actions = new Actions(driver);
        actions.
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_UP).
                sendKeys(Keys.ARROW_DOWN).
                perform();

//Gehe zum oberen Teil der Seite
        warte(2);
        actions.sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).sendKeys(Keys.ARROW_UP).perform();
    }

    @Test
    public void actions2() {
        driver.get("https://techproeducation.com");
        warte(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        //geht runter
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END);
        //geht oben
        warte(4);
        actions.sendKeys(Keys.HOME).build().perform();//
        //build() wir können mehrere actionsobjekt verbinden
    }
    @Test
    public void actions3() {
        //Ageht amazon.com
        driver.get("https://amazon.com");
        //mit groß Buschtabieren SAMSUNG
        WebElement serachbox = driver.findElement(By.id("twotabsearchtextbox"));
        serachbox.sendKeys(Keys.SHIFT,"sa",Keys.SHIFT,"msung",Keys.ENTER);//SAmsung
        driver.navigate().back();
        WebElement serachbox2 = driver.findElement(By.id("twotabsearchtextbox"));
        serachbox2.sendKeys(Keys.SHIFT,"iphone");//IPHONE
    }
}