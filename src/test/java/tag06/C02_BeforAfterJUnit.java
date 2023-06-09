package tag06;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C02_BeforAfterJUnit {

    //jede @Test führt  aus
    @Before
    public void setUp(){
        System.out.println("Vor der jeder Test sollte man  ausführen");
    }

    @After
    public void tearDown(){
        System.out.println("Nach dem jeder Test, führt er aus\".");
    }

    @Test
    public void test01(){
        System.out.println(" Name der erste Methode");
    }

    @Test
    public void test02(){
        System.out.println(" Name der zweite Methode");
    }
}
