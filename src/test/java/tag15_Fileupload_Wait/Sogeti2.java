package tag15_Fileupload_Wait;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class Sogeti2 extends TestBase {
    @Test
    public void bewerbungSend() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sogeti.de/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Accept cookie banner
        WebElement cookieBanner = wait.until(ExpectedConditions.elementToBeClickable(By.className("acceptCookie")));
        cookieBanner.click();

        // Scroll down to "Jobs & Karriere" link
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement jobsLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Jobs & Karriere")));
        jobsLink.click();

        // Switch to jobs iframe
        WebElement jobsIframe = (WebElement) wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("jobylon-jobs-widget-iframe:jobylon-jobs-widget")));
        WebElement secondPageLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='ng-binding' and @ng-bind='n + 1'][text()='2']")));
        secondPageLink.click();
        driver.switchTo().defaultContent();

        // Click on job title link in iframe or top level browsing context
        try {
            WebElement jobIframe = (WebElement) wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.tagName("iframe")));
            WebElement jobTitleLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("job-176231")));
            jobTitleLink.click();
            driver.switchTo().defaultContent();
        } catch (NoSuchFrameException e) {
            WebElement jobTitleLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("job-176231")));
            jobTitleLink.click();
        }

        // Accept cookies
        try {
            WebElement consentButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='js_consent-primary__btn']")));
            consentButton.click();
        } catch (TimeoutException e) {
            // Consent button not found, continue without clicking
        }

        driver.quit();
    }

}
