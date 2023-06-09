package tag06;

import org.junit.*;

public class C03_BeforClassAfterClass {

    //BeforeClass und AfterClass sollte man mit STATIC festlegen.
    @BeforeClass
    public static void setUp(){
        System.out.println("@BeforeClass ; Nur einmal fürht erste aus");
        System.out.println("-----------------");

    }
    @AfterClass
    public static void tearDown(){
        System.out.println("@AfterClass ; Nur einmail fürht am Ende aus");
        System.out.println("-----------------");

    }

    @Before
    public void setUp1(){
        System.out.println("=================");
        System.out.println("@Before ; jeder TESt fürht aus");
        System.out.println("-----------------");

    }
    @After
    public void tearDown01(){
        System.out.println("@After ; Nach der jeder TEST fürht aus");
        System.out.println("-----------------");

    }

    @Test
    public void test01(){
        System.out.println("Erste TEST");
        System.out.println("================");

    }
    @Test
    public void test02(){
        System.out.println("Zweite TEST");
        System.out.println("================");

    }
    @Test
    public void test03(){
        System.out.println("Dritte TEST");
        System.out.println("================");

    }


}
