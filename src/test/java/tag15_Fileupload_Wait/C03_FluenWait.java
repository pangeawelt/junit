package tag15_Fileupload_Wait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utilities.TestBase;

import java.time.Duration;

/*
https://the-internet.herokuapp.com/dynamic_loading/1
Klicken Sie auf die Start-Schaltfläche.
Überprüfen Sie, ob der Text "Hello World!" auf der Seite angezeigt wird.
*/
public class C03_FluenWait extends TestBase {


    @Test
    public void fluenWait() {

        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Klicken Sie auf die Start-Schaltfläche.
        driver.findElement(By.xpath("//button")).click();

        //Überprüfen Sie, ob der Text "Hello World!" auf der Seite angezeigt wird.
        Wait<WebDriver> wait = new FluentWait<>(driver).
                withTimeout(Duration.ofSeconds(30)).//Fluentwait Zeit max festgelegt.
                        pollingEvery(Duration.ofSeconds(3)).//jede 3 Sekunden wirdElement  kontrolliert
                        withMessage("Ingnore Exception").//es ist nicht obligartisch
                        ignoring(NoSuchElementException.class);

        WebElement helloWordText = driver.findElement(By.xpath("(//h4)[2]"));
        Assert.assertTrue(helloWordText.isDisplayed());


    }
}
