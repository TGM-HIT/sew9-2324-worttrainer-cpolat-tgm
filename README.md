# Worttrainer

## Projektübersicht
Der Worttrainer ist ein pädagogisches Tool, entwickelt, um Volksschulkinder in der Rechtschreibung zu trainieren. Kinder werden aufgefordert, das Wort zu einem gezeigten Bild einzutippen, welches dann mit der korrekten Schreibweise verglichen wird.

## Entwicklungsumgebung
- **Sprache**: Java 
- **Build-Tool**: Gradle

## Inhalt der Anwendung
### Kernfunktionen:
- **Bild-Wort-Paar**: Darstellung durch Klassen, die Wort-Bild-Paare speichern. 
- **Gültigkeitsprüfung**: Sichergestellt durch Checks gegen null-Werte oder ungültige URLs.
- **Auswahlmechanismus**: Zufällige oder gezielte Auswahl von Wort-Bild-Paaren.
- **Trainingssession**: Nutzer tippt das Wort zum Bild. Feedback bei richtiger oder falscher Antwort.
- **Statistik**: Aufzeichnung der Gesamtanzahl sowie der Anzahl richtiger und falscher Antworten.

### Persistenz:
- **Speicherformat**: JSON
- **Bibliotheken**: com.fasterxml.jackson
- **Integration**: MVC-Pattern

### Grafische Oberfläche:
- **Basis**: Nutzung von JOptionPane.
- **Ablauf**:
  - Laden persistierter Daten oder Erstellung eines neuen Worttrainers.
  - Auswahl und Anzeige eines Wortpaares, inklusive Statistik.
  - Eingabe des Wortes und Prüfung der Richtigkeit.
  - Persistierung des aktuellen Zustandes am Ende.

## Abschluss
Das Projekt dient der Vertiefung in Softwareentwicklungsprozesse und der praktischen Anwendung von Java unter Verwendung von Gradle. Es bietet die Möglichkeit, das Gelernte aus früheren Jahren zu integrieren und zu erweitern.
