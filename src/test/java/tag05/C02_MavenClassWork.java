package tag05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_MavenClassWork {
    /*
   Gehen Sie zu http://zero.webappsecurity.com
   Klicken Sie auf die Schaltfläche Signin
   Drucken Sie "username" in das Login-Feld
   Drucken Sie "Passwort" in das Feld Passwort
   Klicken Sie auf die Schaltfläche "Sign in
   Gehen Sie auf die Seite Rechnungen bezahlen
   Geben Sie einen beliebigen Betrag, den Sie einzahlen möchten, in das Feld Betrag ein
   Drucken Sie "2023-03-27" in das Feld Datum
   Klicken Sie auf die Schaltfläche "Bezahlen
   Vergewissern Sie sich, dass die Meldung "The payment was successfully submitted." erscheint.
    */
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


//        geht http://zero.webappsecurity.com

//        suchtbox nimmt locat





//        Gehen Sie zu http://zero.webappsecurity.com
        driver.get("http://zero.webappsecurity.com");
//        Klicken Sie auf die Schaltfläche Signin
        ////button[@id='signin_button']
      //  WebElement suchtbox= driver.findElement(By.xpath("//input[@id='//button[@id='signin_button']"));
      //  suchtbox.click();
        //oder
        driver.findElement(By.id("signin_button")).click();
//        Drucken Sie "username" in das Login-Feld
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");

        //        Drucken Sie "Passwort" in das Feld Passwort
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");

//        Klicken Sie auf die Schaltfläche "Sign in
        //input[@id='user_login']
        driver.findElement(By.xpath("//input[@id='user_login']")).submit();
        driver.navigate().back();
//        Gehen Sie auf die Seite Rechnungen bezahlen
        driver.findElement(By.xpath("//*[@id=\"online-banking\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"pay_bills_link\"]")).click();
//        Geben Sie einen beliebigen Betrag, den Sie einzahlen möchten, in das Feld Betrag ein
        driver.findElement(By.xpath("//*[@id=\"sp_amount\"]")).sendKeys("1000");

//        Drucken Sie "2023-03-27" in das Feld Datum
        driver.findElement(By.xpath("//input[@id='sp_date']")).click();
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[4]/a")).click();
//        Klicken Sie auf die Schaltfläche "Bezahlen
        driver.findElement(By.xpath("//*[@id=\"sp_description\"]")).sendKeys("Bezahlen");
//        Vergewissern Sie sich, dass die Meldung "The payment was successfully submitted." erscheint.
        driver.findElement(By.xpath("//*[@id=\"pay_saved_payees\"]")).click();
        WebElement meldung=driver.findElement(By.xpath("//*[@id=\"alert_content\"]/span"));

        if (meldung.getText().contains("The payment was successfully submitted.")) {
            System.out.println("TEST PASSED");
        }
        else System.out.println("TEST FAILED");
        /*

Predicate= önerme,tahmin DEUTSCH=Prädikat
  Predicate<String> paymentSuccess = text -> text.contains("The payment was successfully submitted.");
if (paymentSuccess.test(meldung.getText())) {
    System.out.println("TEST PASSED");
} else {
    System.out.println("TEST FAILED");
}
*/
      //  System.out.println("TEST PASSED "+ meldung.getText().contains("The payment was successfully submitted."));
       // System.out.println("TEST FAILED "+ meldung.getText().contains("The payment was successfully submitted."));
           driver.quit();
    }
    }

