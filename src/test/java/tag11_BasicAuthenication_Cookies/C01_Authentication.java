package tag11_BasicAuthenication_Cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Authentication extends TestBase {

    /*Basic Authentication is an authentication method used on web servers
    * du brauhcst
    Url: https://the-internet.herokuapp.com/basic_auth
    Username: admin
    Password: admin */

    //ALT + leerzeichnen öffnet TestMethode bei mir so eingestellt

    @Test
    public void test01(){
        // vorne username und password wurde eingefügt...
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        WebElement paragraf=driver.findElement(By.xpath("//p"));
        Assert.assertTrue(paragraf.getText().contains("Congratulations!"));

    }




}
