# PhoTo
## Fotó nézegető/szerkesztő

A PhoTo egy egyszerű és gyors fotómegjelenítő és szerkesztő alkalmazás Windows és Linux rendszerre.
Célunk az volt, hogy egy könnyen kezelhető fotónézegető programot építsünk fel. A PhoTo egyszerűsége csodálatra méltó.

## Funkciók
* ###  Forgatás
  - Lehetőséget biztosít a program a kép szögének megváltoztatására, hogy számunkra kedvező módon táruljon elénk a kívánt fotó.
  - Elérhető forgatási szögek: 
    - 90°
    - 180°
    - 270°
    - 360°
* ###  Tükrözés
  - Különböző tükrözési metódusokra is lehetőségünk nyílik, ezek pedig: 
    -   vízszintes
    -   függőleges
* ###  Filterek
  - A programban lehetőségünk van különféle szűrők közül választani. Ide sorolhatjuk például a fekete-fehér filtert.   
* ###  Fényerő változtatása
  - A kép fényerejét is változtathatjuk a program által, ami azt eredményezi majd, hogy világosabb, vagy sötétebb árnyalatú kép kerül megjelenítésre.
* ###  Kép mentése
  - A kép lementhtő támogatott formátumok bármelyikére és tetszőleges helyre le is lehet menteni azt.
* ###  Kép megnyitása
  - A kép megnyitásása a támogatott formátumokban képes. A megnyitást követően használhatók tetszőlegesen a funkciók.
 
## Támogatott formátumok
   * .png 
   * .jpg
 
## Technikai részletek
 Az alkalmazás Java nyelven íródik, amely lehetővé teszi, hogy mind Windows, mind Linux operációs rendszereken is
 gond nélkül működjön a program. Ezen felül további bővítési lehetőségeket kínál.


A mappakezelés a következőképpen kerül megvalósításra: Meg van adva egy statikus útvonal, amibe a felhasználó belerakhatja a kívánt képeket, amiket aztán a programban használni szeretne. Ezen kiválasztott képeknek módosított vagy eredeti formáit tudja majd élvezni a programon belül.

## Használat

A program egy egyszerű és átlátható UI-al, azaz felhasználói felülettel rendelkezik. A Menü bal felülről nyitható le, amivel a főbb filekezelési funkciók válnak elérhetővé, beleértve:
  * A megnyitást
  * A mentést
  * A mentés másként-et.
  
 A transzformálási funkciók az adott kép körül fognak elhelyezkedni, a gyors elérés érdekében. Ezek legfőképpen bizonyos ikonokkal kerülnek megvalósításra. Ezek közé tartoznak:
  * Forgatás
  * Tükrözés
  * Filterek
  
A kép módosítása után lehetőség van elvetni a változtatásokat, ebben az esetben az eredeti file kerül megtartásra, nem íródik felül.
Ez biztosítja, hogy csak azon változtatások mehessenek végbe, amelyek tényleg kívánatosak a felhasználó által.


## Rendszerkövetelmények

Java 17 verziója.

* ### CPU 
  Intel® Core®2 Duo E6700 @ 2.6 GHz vagy jobb, AMD™ Athlon™64 X2 6000+ @ 3.0Ghz vagy jobb
* ### RAM
  2 GB
* ### OS
  Windows® 7 vagy Windows® 8 vagy Windows® 10 vagy Windows® 11 vagy Linux...


