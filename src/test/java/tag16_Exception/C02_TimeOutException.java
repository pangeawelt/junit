package tag16_Exception;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_TimeOutException extends TestBase {
    @Test
    public void TimeOutExceptionTest1() {

        driver.get("https://techproeducation.com");
        warte(5);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //visibleWait(By.id("Yanlis Locate"),15);//org.openqa.selenium.TimeoutException:

        /*
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@type='ssearch']")));
         */

    }
}
