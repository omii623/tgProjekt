# Tesztjegyzőkönyv
## PhoTo Fotó nézegető/szerkesztőre

A PhoTo egy egyszerű és gyors fotómegjelenítő és szerkesztő alkalmazás Windows és Linux rendszerre.
Célunk az volt, hogy egy könnyen kezelhető fotónézegető programot építsünk fel. A PhoTo egyszerűsége csodálatra méltó.


> Ebben a szegmensben egy tesztelési folyamat elevenedik meg, hogy a felhasználó biztosan tudja, hogy amit kap, az úgy működik, ahogy annak kell.


## Funkciók tesztelése
* ###  Forgatás tesztelés
  - Lehetőséget biztosít a program a kép szögének megváltoztatására, hogy számunkra kedvező módon táruljon elénk a kívánt fotó.
  - Elérhető forgatási szögek: 
    - 90°
    - 180°
    - 270°
    - 360°

> 🟩 Forgatás testelése sikers

* ###  Tükrözés tesztelés
  - Különböző tükrözési metódusokra is lehetőségünk nyílik, ezek pedig: 
    -   vízszintes
    -   függőleges

> 🟩 Tükrözés testelése sikers

* ###  Filterek tesztelése
  - A programban lehetőségünk van különféle szűrők közül választani. Ide sorolhatjuk például a fekete-fehér filtert.   

> 🟩 Filterek testelése sikeres
> 🟥 nincs viszavonásra lehetőség

* ###  Fényerő változtatásának tesztelése
  - A kép fényerejét is változtathatjuk a program által, ami azt eredményezi majd, hogy világosabb, vagy sötétebb árnyalatú kép kerül megjelenítésre.

> 🟥 Fényerő változtatás még nem kész
  
* ###  Kép mentésének tesztelése
  - A kép lementhtő támogatott formátumok bármelyikére és tetszőleges helyre le is lehet menteni azt.

> 🟥 Megjelenik a felület de nem történik meg a mentés

* ###  Kép megnyitásának tesztelése
  - A kép megnyitásása a támogatott formátumokban képes. A megnyitást követően használhatók tetszőlegesen a funkciók.

> 🟩 Sikeresen meg lehet nyitni képet
> 🟩 javítva (hiba ha a mégsemre nyomunk)

## Támogatott formátumok tesztelése
   * .png 
   * .jpg

> 🟩 Sikeres teszt
 
## Technikai részletek tesztelése
A mappakezelés a következőképpen kerül megvalósításra: Meg van adva egy statikus útvonal, amibe a felhasználó belerakhatja a kívánt képeket, amiket aztán a programban használni szeretne. Ezen kiválasztott képeknek módosított vagy eredeti formáit tudja majd élvezni a programon belül.

> 🟩 A mappakezelés eltér a megadotttól, még szélesebb skálát kínál, bárhonnan lehet képet választani megnyitásra az open file menüponttal. 

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

> 🟥 Mentésre jelenleg nincs lehetőség, csak egy placebo metódus van. a save vagy save as menüpontra kattintva elhihetjük, hogy elmenti a file-t a rendszer. Természetesen ez mielőbbi javításra szorul. 


## Rendszerkövetelmények

Java 17 verziója.

* ### CPU 
  Intel® Core®2 Duo E6700 @ 2.6 GHz vagy jobb, AMD™ Athlon™64 X2 6000+ @ 3.0Ghz vagy jobb
* ### RAM
  2 GB
* ### OS
  Windows® 7 vagy Windows® 8 vagy Windows® 10 vagy Windows® 11 vagy Linux...
  
> 🟩 Sikeres tesztek Windows rendszereken
> 🟩 Sikeres tesztek Linux rendszereken


