                                          JUNIT


JUnit ist ein Framework für Java, das speziell zum Schreiben und Ausführen von automatisierten Tests für Java-Anwendungen entwickelt wurde. Es ermöglicht Entwicklern, Testfälle zu definieren, die die erwartete Funktionalität der Anwendung prüfen und sicherstellen sollen, dass Änderungen im Quellcode keine unerwarteten Ergebnisse haben. JUnit bietet eine Vielzahl von Annotationen und APIs, mit denen Entwickler Testmethoden schreiben können, um Daten zu initialisieren, Aktionen auszuführen und die erwarteten Ergebnisse zu testen. Durch die Verwendung von JUnit können Entwickler schnell Feedback darüber erhalten, ob ihre Änderungen funktionieren oder nicht, was zur Verbesserung der Codequalität beitragen kann.

Es gibt mehrere wichtige Annotationen in JUnit, die Entwickler verwenden können, um Testmethoden zu definieren und Konfigurationen für Tests festzulegen. Einige der wichtigsten Annotationen sind:

@Test: Diese Annotation kennzeichnet eine Methoden als Testmethode, die ausgeführt werden soll.

@Before: Diese Annotation kennzeichnet eine Methode, die vor jeder Testmethode ausgeführt wird, um die erforderlichen Ressourcen oder Datenbereitstellungen vorzunehmen.

@After: Diese Annotation kennzeichnet eine Methode, die nach jeder Testmethode ausgeführt wird, um bereinigende Aktionen durchzuführen, wie z.B. das Freigeben von Ressourcen.

@BeforeClass: Diese Annotation kennzeichnet eine Methode, die einmalig vor dem Start aller Testmethoden in einer Testklasse ausgeführt wird, um globale Konfigurationsaufgaben durchzuführen.

@AfterClass: Diese Annotation kennzeichnet eine Methode, die einmalig nach Abschluss aller Testmethoden in einer Testklasse ausgeführt wird, um globale Aufräumarbeiten durchzuführen.

Diese Annotationen helfen bei der Strukturierung und Ausführung von Tests und ermöglichen es Entwicklern, Tests zu schreiben, die einfach zu verstehen und zu warten sind.

DRY=DONT REPEAT YOURSELF

WET= WRITE EVERTHING TWICE


===========

##Dropdown

Select select = new Select(DropdownElement);

##Iframe

driver.switchTo().frame(iframeElement);
driver.switchTo().parentFrame(); //parent Iframe gibt zurück
driver.switchTo().newWindow(WindowType.WINDOW);

##WindowHandle

driver.getWindowHandle();
driver.getWindowHandles();

#öffnet neu Webseite im TAB

driver.get("https://www.amazon.com");

##Allerts
Simple Alert
Confirmation Alert
Prompt Alert

accept( ) => Dasselbe wie das Klicken auf OK bei einer Meldung.
driver.switchTo( ).alert( ).accept( );

dismiss() => Entspricht dem Klicken auf Abbrechen bei einer Warnmeldung.
driver.switchTo( ).alert( ).dismiss();

●getText() => Zum Abrufen der Nachricht in einer Meldung.
driver.switchTo( ).alert( ).getText();

●sendKeys("Text") => So senden Sie Text an das Textfeld der Warnmeldung
driver.switchTo( ).alert( ).sendKeys("Text");

##Authentication
Basic Authentication is an authentication method used on web servers

##Cookies

WEBSEITE->RECHTKLICK->UNTERSUCHEN->APP->COOKIES

driver.manage().addCookie();;
driver.manage().getCookies();
driver.manage().deleteAllCookies();
driver.manage().getCookieNamed();

Was ist ein Cookie?
Cookies sind Informationsdateien, 
die vorübergehend im Browser angelegt werden.
Cookies werden vorübergehend auf unserem Computer gespeichert.
Cookies können eine Vielzahl von Informationen enthalten, 
darunter auch persönliche Daten.  
Websites können nur auf Informationen zugreifen, 
die Sie autorisiert haben.  
Diese Websites können nicht auf Informationen zugreifen,
die Sie nicht angegeben haben,
oder andere Dateien auf Ihrem Computer einsehen


##ActionsClass
        Actions aktionen = new Actions(driver);
        WebElement feld = driver.findElement(By.id("hot-spot"));
        aktionen.contextClick(feld).perform();
        actions.dragAndDrop(dragSource,dropTarget).perform();
        actions.clickAndHold(dragSource).moveToElement(dropTarget).release().perform();
        actions.clickAndHold(dragSource).moveByOffset(84,28).release().perform();

//Verschiebt Webelement an die gewünschte Koordinate

/*Mit Aktionen Klasse I Maus und Tastatur werden Operationen durchgeführt.
2 Tipp ;
##Mausbasierte Aktionen:
Doppelklick, Rechtsklick, klicken und halten, ziehen und ablegen, über ein Element bewegen usw., scrollen.
##Tastatur-basierte Aktionen:
Umschalt-, Strg- und Alt-Tasten.
Actions hat viele nützliche Maus- und Tastaturfunktionen*/



