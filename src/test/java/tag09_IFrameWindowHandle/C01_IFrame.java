package tag09_IFrameWindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TastBase;
import static org.junit.Assert.*;

public class C01_IFrame extends TastBase {

    /*
    geht //https://the-internet.herokuapp.com/iframe
    Stellen Sie sicher, dass der fettgedruckte Text das Wort "Editor" enthält.
    Löschen Sie den Text im Textfeld
    Schreiben Sie anstelle des gelöschten Textes "Dieses Textfeld befindet sich im iFrame".
    Überprüfen Sie, ob "Elemental Selenium" auf der Seite sichtbar ist.
    * */
    @Test
    public void iFrame01() {
        //    geht //https://the-internet.herokuapp.com/iframe
        //    Stellen Sie sicher, dass der fettgedruckte Text das Wort "Editor" enthält.
        //    Löschen Sie den Text im Textfeld
        //    Schreiben Sie anstelle des gelöschten Textes "Dieses Textfeld befindet sich im iFrame".
        //    Überprüfen Sie, ob "Elemental Selenium" auf der Seite sichtbar ist.
        driver.get("https://the-internet.herokuapp.com/iframe");
        String überschrift = driver.findElement(By.xpath("//h3[.='An iFrame containing the TinyMCE WYSIWYG Editor']")).getText();
        assertTrue(überschrift.contains("Editor"));

        //IFRAME
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);
        WebElement textBox = driver.findElement(By.xpath("//p[.='Your content goes here.']"));
        textBox.clear();
        textBox.sendKeys("Dieses Textfeld befindet sich im iFrame");
        //Zuerst sollte man außer IFrame nehmen.

        //Da sich unser WebElement in der Standardseite befindet, müssen wir den Treiber
        // zunächst außerhalb des Iframe, d. h. auf unserer Seite, holen.
        driver.switchTo().parentFrame(); //parent Iframe gibt zurück
        WebElement elementalSelenium=driver.findElement((By.linkText("Elemental Selenium")));
        assertTrue(elementalSelenium.isDisplayed());

    }


}
