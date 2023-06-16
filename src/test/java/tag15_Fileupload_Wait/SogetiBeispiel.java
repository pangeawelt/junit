package tag15_Fileupload_Wait;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class SogetiBeispiel extends TestBase {

    @Test
    public void bewerbungSend() throws InterruptedException {
        driver.get("https://www.sogeti.de/");

        driver.findElement(By.xpath("//*[@class='acceptCookie']")).click();

        Actions aktionen = new Actions(driver);
        aktionen.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.END).perform();

        String xpath = "//a[contains(@href, '/jobs--karriere/offene-stellen/') and text()='Jobs & Karriere']";
        driver.findElement(By.xpath(xpath)).click();

        aktionen.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));

        // iframe
        driver.switchTo().frame("jobylon-jobs-widget-iframe:jobylon-jobs-widget");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='ng-binding' and @ng-bind='n + 1'][text()='2']")))
                .click();

        driver.switchTo().defaultContent();

        // Switch to the iframe (if it exists)
        if (driver.findElements(By.tagName("iframe")).size() > 0) {
            WebElement iframe = driver.findElement(By.tagName("iframe"));
            driver.switchTo().frame(iframe);
            // Locate the element inside the iframe using an XPath expression
            String elementXPath = "//*[@id='job-176231']";
            WebElement element = driver.findElement(By.xpath(elementXPath));
            // Click the element
            element.click();
            // Switch back to the top level browsing context
            driver.switchTo().defaultContent();
        } else {
            // If there is no iframe, locate the element in the top level browsing context
            String elementXPath = "//*[@id='job-176231']";
            WebElement element = driver.findElement(By.xpath(elementXPath));
            // Click the element
            element.click();
        }


        warte(3);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("///*[@id='js_consent-primary__btn']")))
                .click();


    }
}
