package tag17_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ScreenShot extends TestBase {
    /* für Documentation
        passed Test zu speichern
        rest Test Case wie viel Bug gibt.
        Windows + Shift + S

     * */

    @Test
    public void ScreenshotTest() throws IOException {

        driver.get("https://www.techproeducation.com");
        warte(2);

   String speicherDate=new SimpleDateFormat("_hh_mm_ss_dd.MM.yyyy").format(new Date());

   String screenPath= "test_Output/screenShot" + speicherDate+".png";

   //zuerst File wo es speichern soll, festlegen


   //TakeScreenshot Schnitstelle ein Objekt zu erzeugen
        TakesScreenshot ts=(TakesScreenshot) driver;//casting
        //Files.write() ist auch gleich APACHE
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(screenPath));


    }

    @Test
    public void ScreenshotTest2() {

        driver.get("https://www.amazon.com");
        warte(2);
        //zuerst File wo es speichern soll, festlegen
        String screenPath= "test_Output/screenShot.png";
    }
}
