# uek295-b-ram-asa

## Funktionen

* CRUD Methoden
* Bücher erstellen
* Orders erstellen
* Bücher und Orders updaten
* Orders filtern mit Parameter

## Endpoints

Endpoints | Pfad                  | Beschreibung
-------- | ---------------------- | --------
GET      | /book/{bookId}         | Ein spezifisches Buch aufrufen
GET      | /book/order/{orderId}  | Eine spezifische Order aufrufen
GET      | /book/order?           | Nach Order filtern Beispiel: ?status=Pending
POST     | /book/                 | Ein Book erstellen
POST     | /book/order            | Eine Order erstellen
PUT      | /book/{bookId}         | Ein Book updaten
PUT      | /book/order/{orderId}  | Eine Order updaten
DELETE   | /book/{bookId}         | Ein book löschen
DELETE   | /book/order/{orderId}  | Eine Order löschen

## Projekt aufsetzen

1. ```git clone https://github.com/Ramadan54/uek295-b-ram-asa.git``` in git BASH ausführen beim bevorzugten Pfad

2. Docker starten

3. ```docker run -d -p 5432:5432 -e POSTGRES_PASSWORD=postgres --name uek295db postgres``` in CMD ausführen

4. Auf Gradle klicken

![Auf Gradle klicken][gradle1]

5. Bootrun doppel klicken

![Bootrun klicken][gradle2]


[gradle1]: images/gradle1.png
[gradle2]: images/gradle2.png