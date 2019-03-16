Zmienne, typy danych i operatory
1 Wykład : 

typy danych: 
int => najbardziej popularny typ całkowity
float => single precision pol. jedno miejsce po przecinku
double => double precision pol. dwa miejsca po przecinku 
byte => do -128 do 127 :) zajmuje mniej miejsca w pamięci 
Short
Long 
char => znaki
boolean > true v false 

short shortTotal = (short) .... - sposób na konwertowanie wszystkich wyrazów na dany typ
long longTotal = 5000L - jeżeli zapisujemy typ long zwykliśmy dawać "L" na końcu liczby
float myFloat = 5f - dla float'a zwyklismy dawac f na koncu
double myDouble = 5d - dla double zwyklismy dawac d na koncu

*
int przy działaniach typu 5/3 zwraca liczbę 1, gdyż jest i wartość całkowita z dzielenia
float przy działaniu typu 5/3 zwraca liczbe 1,6666666 tzn, otrzymamy 7 liczb po przecinku
float 4 bajty (32 bity) 
double przy działaniu typu 5/3 zwaraca liczbe,16666666666666667 tzn, otrzymamy 16 liczb po przecinku
double 8 bajtów (64 bity) 
obecnie typem poza int-em najpopularniejszym jest typ double. Najpowszechniej stosowany w nowoczesnej architekturze 64 bitowej
i zarazem najszybciej "pracujący". Typ float obecnie jest rzadko stosowany. 
*
typ char - typ do zapisywania znaków. Może zawierać 2 bajty = 16 bitów -> 16 znaków
sposób zapisu: 
np: char myChar = 'A'; 
!znaki możemy również zapisywać przy pomocy kodu UNICODE!
dla przzykładu:
© -> char copyright = '\u00A9';
 
typ boolean - typ logiczny, pozwalający zapisać tylko dwie wartości albo true / false
 
*
String - 9 typ zmiennych. Może składać się z 8 znaków. 
pamiętajmy, że:
String myString = "10" ;
int myInt = "10";
myString = myString + myInt; 
wynik tego działania będzie wynosił "1010", int zostanie przekonwerterowawany na String.
*
Operatory zwykłe stosowanie w Javie:

+ plus
- minus
* mnożenie
/ dzielenie
% reszta często zwana "modułem"
i++ postinkrementacja (po wykonanym kodzie zwiększ wartość o 1)
++i preinkrementacja (przed wykonaniem zwiększ wartość o 1)

Operatory skrócone +=

! wynik += 2; taki zapis oznacza wynik = wynik + 2 ! 

!wszystkie operatory możemy zapisać w takiej postaci!

= - nadaje nam wartość zmiennej
== - służy do sprawdzania wartości !pamiętaj informatyku młody dwa znaki equals powodem częstego błędu!
!= - nierówność
> - nierówności 
>= - większe, bądź równe 
Przydatne linki:
http://cs.bilkent.edu.tr/~guvenir/courses/CS101/op_precedence.html
http://docs.oracle.com/javase/tutorial/java/nutsandbolts/opsummary.html

&& - operator logiczny "AND"
|| - operator logiczny "OR"

Operator logiczny ?
przykład
ZmiennaNie = ZmiennaTAK ? true : false - oznacza, jeżeli zmienna TAK ma wartość true ZmiennaNIE ma wartość true,  jeżeli zmienna TAK ma wartość false nadaj wartość false 

dodatkowo: 
 składnia "if" 
if ( zmienna == wartość )
	//kod ; 


