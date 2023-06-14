package tag12_ActionClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Actions04 extends TestBase {

    @Test
    public void actions() {
        //https://jqueryui.com/droppable/ adresine gidin
        driver.get("https://jqueryui.com/droppable/");

        //"Drag me to my target" element wird  "Drop here" verschoben.
        driver.switchTo().frame(0);

        WebElement dragSource = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropTarget = driver.findElement(By.xpath("//*[@id='droppable']"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragSource,dropTarget).perform();
        //Source(drag)  source target

    }


    @Test
    public void actions2() {
        //https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");


        driver.switchTo().frame(0);

        WebElement dragSource = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropTarget = driver.findElement(By.xpath("//*[@id='droppable']"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(dragSource).//Webelement halt Maus.basili tut
                moveToElement(dropTarget).
                release().//lasst frei
                perform();
    }

    @Test
    public void actions3() {
        driver.get("https://jqueryui.com/droppable/");

        driver.switchTo().frame(0);

        WebElement dragSource = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropTarget = driver.findElement(By.xpath("//*[@id='droppable']"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(dragSource).
                moveByOffset(84,28).
                release().perform();
        //Verschiebt Webelement an die gewünschte Koordinate  release().perform();



    }



}
