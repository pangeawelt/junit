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







