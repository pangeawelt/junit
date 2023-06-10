package tag07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_ClassWorkCheckBox {
    WebDriver driver;

    //Vor jeder Test führt aus
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    //Close
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        // // Abrufen der Webelemente für die Kontrollkästchen//checkboxes
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));

        // Prüfen Sie, ob die Kontrollkästchen nicht aktiviert sind, und aktivieren Sie sie dann.
        if (!checkbox1.isSelected() || !checkbox2.isSelected()) {
            checkbox1.click();
        }


       //   System.out.println(checkbox1.isSelected());
       // System.out.println(checkbox2.isSelected());


    }
    ////input[type='checkbox'][1]


    }




