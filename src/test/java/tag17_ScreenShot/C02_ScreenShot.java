package tag17_ScreenShot;

import org.junit.Test;
import utilities.TestBase;

public class C02_ScreenShot extends TestBase {

    @Test
    public void screenShot() {
        String webseitePath = "https://www.amazon.com";
        driver.get(webseitePath);
        ganzesSeitenbild();

    }
}
