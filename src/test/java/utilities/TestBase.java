package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import static org.junit.Assert.assertEquals;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class TestBase {

    // Wir möchten verhindern,dass ein Objekt von testBase zu erzuegen deswegen ABSTRACT


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

 /*   @After
    public void tearDown() {
        try {
            Thread.sleep(3000); //
            driver.close(); //
        } catch (InterruptedException e) {
            System.out.println("InterruptedException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }*/

   /* @After
    public void tearDown() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
            Thread.sleep(Duration.ofSeconds(3).toMillis()); //
            driver.quit(); //
        } catch (InterruptedException e) {
            System.out.println("InterruptedException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }*/

    //HARD WAIT METHOD
    public static void warte(int sekunde) {
        try {
            Thread.sleep(sekunde * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Alert ACCEPT
    public static void alertAccept() {
        driver.switchTo().alert().accept();
    }

    //Alert DISMISS
    public static void alertDismiss() {
        driver.switchTo().alert().dismiss();
    }

    //Alert getTEXT
    public static void alertText() {
        driver.switchTo().alert().getText();
    }

    //Alert promptBOX
    public static void alertPrompt(String text) {
        driver.switchTo().alert().accept();
    }

    /*anstatt
    * //   Select select2 = new Select(tag);
     //   select2.selectByVisibleText("7");
     * diese methode*/

    //DropDOWNMENU
    public static void ddmVisibleText(WebElement ddm, String wahl) {
        Select select = new Select(ddm);
        select.selectByVisibleText(wahl);
    }

    //DropDownINDEX

    public static void ddmIndex(WebElement ddm, int index) {
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }
    //DropDownVALUE

    public static void ddmValue(WebElement ddm, String value) {
        Select select = new Select(ddm);
        select.selectByValue(value);
    }

    //SwicthToWindow
    public static void switchToWindow(int zahl) {
        List<String> allesWindowshandel = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(allesWindowshandel.get(zahl));

    }

    //SwitchToWindow
    /*Das heißt, der Zweck der Methode window(int zahl) besteht darin,
    zwischen Fenstern mit dem angegebenen numerischen Index zu wechseln.*/
    public static void window(int zahl) {
        driver.switchTo().window(driver.getWindowHandles().toArray()[zahl].toString());
    }
/*Die Methode switchToWindow(int zahl) sammelt zunächst die Bezeichner aller verfügbaren
 Fenster in einem List-Objekt und schaltet dann zwischen den Fenstern
  an dem mit der Methode get() angegebenen Index um.
   Diese Methode erfordert ein wenig mehr Code,
   um eine Liste der verfügbaren Fenster zu erstellen.

Dagegen greift die Methode window(int zahl) direkt auf die Bezeichner der verfügbaren
Fenster zu und wandelt sie mit der Methode toArray() in ein Array um.
 Anschließend wird das Fenster in der angegebenen Reihenfolge ausgewählt
 und mit der Methode toString() fokussiert.
 Im Allgemeinen besteht der Unterschied zwischen diesen beiden Methoden darin, wie die verfügbaren Fenster gesammelt werden und welche Methode verwendet wird. Beide dienen
 jedoch demselben grundlegenden Zweck
 und können bei richtiger  Anwendung funktional sein.*/

    //ExcplicitWAIT

    public void visibleWait(WebElement element, int zahl) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(zahl));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    //FluentWAIT
    public void fluentWait(WebElement element, int zahl) {
        Wait<WebDriver> wait = new FluentWait<>(driver).
                withTimeout(Duration.ofSeconds(zahl)).//Fluentwait Zeit max festgelegt.
                        pollingEvery(Duration.ofSeconds(3)).//jede 3 Sekunden wirdElement  kontrolliert
                        withMessage("Ingnore Exception").//es ist nicht obligartisch
                        ignoring(NoSuchElementException.class);
    }

    //Alert Wait
    public static void alertWait(int zahl) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(zahl));
        wait.until(ExpectedConditions.alertIsPresent());

    }

    //ScreenShot für allesSeite
    public static void ganzesSeitenbild() {
        String speicherDate = new SimpleDateFormat("_hh_mm_ss_dd.MM.yyyy").format(new Date());
        String screenPath = "test_Output/screenShot" + speicherDate + ".png";
        TakesScreenshot ts = (TakesScreenshot) driver;//casting
        try {
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(screenPath));// mit .try fügt trycatchBlog
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    //WebElement ScreenShot

    public static  void screenShotWebElement(WebElement element) {

        String speicherDate = new SimpleDateFormat("_hh_mm_ss_dd.MM.yyyy").format(new Date());
        String screenPath = "test_Output/screenShot" + speicherDate + ".png";
        try {
            FileUtils.copyFile(element.getScreenshotAs(OutputType.FILE),new File(screenPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
