package tag15_Fileupload_Wait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C05_ExplicitWait extends TestBase {


    @Test
    public void explicitWait() {
        //https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");


        driver.findElement(By.xpath("//*[text()='Remove']")).click();
        //*[text()=['It's gone!']
        Assert.assertTrue(driver.findElement(By.xpath("(//p)[2]")).isDisplayed());
        //Implicitwait ist reicht.
    }
}
