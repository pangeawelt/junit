package tag05_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_MavenErsteTest {

    /*
    geht amazon.com
    suchtbox nimmt locat
    samsung heades sucht
    schreibt Anzahl der Ergebnis
    klickt erste Produkt
    alles Überschrift schreibt.

 *
 */

        public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


//        geht amazon.com
       driver.get("https://www.amazon.com");
//        suchtbox nimmt locat
            ////input[@id='twotabsearchtextbox']
            WebElement suchtbox= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
            suchtbox.sendKeys("Samsung headphones");
            suchtbox.submit();
//        samsung heades sucht
        WebElement ergebnissuch=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small'][1]"));

//        schreibt Anzahl der Ergebnis
            System.out.println("ergebnissuch = " + ergebnissuch.getText());
//        klickt erste Produkt
        //div[@class='a-section aok-relative s-image-fixed-height']
         WebElement   erstebild=driver.findElement(By.xpath("//div[@class='a-section aok-relative s-image-fixed-height']"));

            List<WebElement> allesbild= driver.findElements(By.xpath("//img[@class='s-image']"));
            allesbild.get(0).click();


//        alles Überschrift schreibt.
            List<WebElement> allesuebersichrift=driver.findElements(By.xpath("//h1[@class='a-size-large a-spacing-none']"));
         //   for (WebElement w :allesuebersichrift){
           //     System.out.println(w.getText());
        //    }
            //mit Lambda
            allesuebersichrift.forEach(t-> System.out.println(t.getText()));

            driver.quit();

    }
}
