package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import static org.junit.Assert.assertEquals;


import java.time.Duration;

public abstract class TestBase {

    // Wir möchten verhindern,dass ein Objekt von testBase zu erzuegen deswegen ABSTRACT
    //


    protected static WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws InterruptedException {
       warte(3);
       driver.quit();
    }


    //HARD WAIT METHOD
    public static void warte(int sekunde) {
        try {
            Thread.sleep(sekunde * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    //Alert ACCEPT
    public static void alertAccept(){
        driver.switchTo().alert().accept();
    }
    //Alert DISMISS
    public static void alertDismiss(){
        driver.switchTo().alert().dismiss();
    }

    //Alert getTEXT
    public static void alertText(){
        driver.switchTo().alert().getText();
    }
    //Alert promptBOX
    public static void alertPrompt(String text){
        driver.switchTo().alert().accept();
    }

    /*anstatt
    * //   Select select2 = new Select(tag);
     //   select2.selectByVisibleText("7");
     * diese methode*/

    //DropDOWNMENU
    public static void ddmVisibleText(WebElement ddm,String wahl){
        Select select= new Select(ddm);
        select.selectByVisibleText(wahl);
    }

    //DropDownINDEX

    public static void ddmIndex(WebElement ddm,int index){
        Select select= new Select(ddm);
        select.selectByIndex(index);
    }
    //DropDownVALUE

    public static void ddmValue(WebElement ddm,String value){
        Select select= new Select(ddm);
        select.selectByValue(value);
    }




}
