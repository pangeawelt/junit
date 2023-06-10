package tag08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Assertion {
    WebDriver driver;
    /*  /*
1) Rufen Sie https://amazon.com auf.
2) Erstellen Sie 4 Testmethoden mit den folgenden Namen und führen Sie die erforderlichen Tests durch
    ○ title Test => Test, ob der Seitentitel das Wort ,ob "Amazon" enthält
    ○ image Test => Testen Sie, ob das Amazon-Bild angezeigt wird (isDisplayed())
    ○ Testen Sie, ob das Suchfeld zugänglich ist (isEnabled())
    ○ wrongTitleTest => Überprüfen, ob der Seitentitel nicht "amazon" enthält
*/
        @Before
    public void setUp() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driver.get("https://www.amazon.com");
        }

        @After
    public void tearDown() throws InterruptedException {
            Thread.sleep(3000);
            driver.quit();
        }
        @Test
    public void test01(){
   // ○ image Test => Testen Sie, ob das Amazon-Bild angezeigt wird (isDisplayed())
      WebElement amazonbild= driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));
      Assert.assertTrue("Das Amazon-Logo wird nicht angezeigt.", amazonbild.isDisplayed());

        }

    @Test
    public void test02(){
        // ○ title Test => Test, ob der Seitentitel das Wort ,ob "Amazon" enthält
        String actualtitle=driver.getTitle();
        String expectedtitle="Amazon";

        boolean enthaelt= actualtitle.contains(expectedtitle);
        Assert.assertTrue(enthaelt);

    }
    /*@Test
    public void test02() {
    String actualTitle = driver.getTitle();
    String expectedTitle = "Amazon";

   Assert.assertTrue(actualTitle.contains(expectedTitle), "Der Seitentitel enthält nicht das Wort "Amazon".");
}*/
        @Test
    public void test03() {

            //○ Testen Sie, ob das Suchfeld zugänglich ist (isEnabled())==kullanilabilirmi
            WebElement suchfeld= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
            Assert.assertTrue("Suchfeld ist zuganglich.", suchfeld.isEnabled());


}
    @Test
    public void test04() {

  //  ○ wrongTitleTest => Überprüfen, ob der Seitentitel nicht "amazon" enthält
    String actualTitle=driver.getTitle();
    String exceptedTitle="amazon";
        Assert.assertFalse(actualTitle.contains(exceptedTitle));//false
         }



}
