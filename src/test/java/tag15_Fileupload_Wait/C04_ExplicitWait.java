package tag15_Fileupload_Wait;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_ExplicitWait extends TestBase {

    @Test
    public void explicitWait() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //
        driver.findElement(By.xpath("//button")).click();

        //Überprüfen Sie, ob der Text "Hello World!" auf der Seite angezeigt wird.
        WebElement helloWordText = driver.findElement(By.xpath("(//h4)[2]"));
        visibleWait(helloWordText, 21);
        Assert.assertTrue(helloWordText.isDisplayed());

    }
}