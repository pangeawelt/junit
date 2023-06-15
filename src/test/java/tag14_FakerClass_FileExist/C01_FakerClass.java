package tag14_FakerClass_FileExist;

import com.github.javafaker.Faker;
import org.junit.Test;
import utilities.TestBase;

public class C01_FakerClass extends TestBase {
    @Test
    public void javaFakerTest() {
//1. Erstelle ein Objekt der Klasse Faker.
        Faker faker = new Faker();
//alternativ können wir mit der statischen Methode Faker.instance() beginnen
        Faker.instance(); //oder so ohne new schlüsselwort
//Gib den Vornamen aus:
        System.out.println(faker.name().firstName());
//Gib den Nachnamen aus:
        System.out.println(faker.name().lastName());
//Gib den Benutzernamen aus:
        System.out.println(faker.name().username());
//Gib einen witzigen Namen aus:
        System.out.println(faker.funnyName().name());
//Gib den Berufsnamen aus:
        System.out.println(faker.name().title());
//Gib den Stadtnamen aus:
        System.out.println(faker.address().city());
//Gib den Staatsnamen aus:
        System.out.println(faker.address().state());
//Gib die vollständige Adresse aus:
        System.out.println(faker.address().fullAddress());
//Gib die Handynummer aus:
        System.out.println(faker.phoneNumber().cellPhone());
//Gib die E-Mail-Adresse aus:
        System.out.println(faker.internet().emailAddress());
//Gib den Postleitzahl aus:
        System.out.println(faker.address().zipCode());
//Nimm eine zufällige 15-stellige Nummer:
        System.out.println(faker.number().digits(15));
//Gib mir eine Zahl zwischen 1 und 10000000
        System.out.println(faker.number().numberBetween(1, 10000000));
        System.out.println("faker.avatar() = " + faker.avatar());
//Ich mache das alles nur mit Java, ich brauche keinen Treiber dafür.
    }
}
