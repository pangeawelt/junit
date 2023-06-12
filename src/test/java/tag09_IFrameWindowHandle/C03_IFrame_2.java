package tag09_IFrameWindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_IFrame_2 extends TestBase {

    @Test
    public void iframe()  {
        //➢	sucht https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        //➢
        String actualText1 = driver.findElement(By.xpath("//p[text()='An iframe with a thin black border:']")).getText();
        Assert.assertTrue(actualText1.contains("black border"));

        //➢
        driver.switchTo().frame(0); //--> wenn iframe hätte und nicht wechseln wirft NoSuchElementException
        /*
        Wenn es zwei iframes gäbe und ich zum 2. Frame wechseln wollte, müsste ich Index 1 nehmen
        zb:
            <body>
	            <iframe id="outerIframe" src="https://www.w3schools.com"> --> driver.switchTo().frame("outerIframe");
		            <iframe id="innerIframe" src="https://www.google.com"></iframe> -->wenn nochmal Iframe hätte,  driver.switchTo().frame("innerIframe");
	            </iframe>
            </body>

         */
        String actualText2 = driver.findElement(By.xpath("//*[text()='Applications lists']")).getText();
        Assert.assertEquals(actualText2,"Applications lists");

        //➢
        driver.switchTo().defaultContent();
        WebElement poveredByText = driver.findElement(By.xpath("//*[text()='Povered By']"));
        Assert.assertTrue(poveredByText.getText().contains("Povered By"));
    }
}
