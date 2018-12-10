.help pomoc

keywords w SQLu nie s� wra�liwe na wielko�� liter.
s�owa kluczowe w SQLu oddzielamy �rednikiem ';' 

Najwa�niejsze komendy w SQLu:
SELECT - wyodr�bnia dane z bazy
UPDATE - aktualizuje dane w bazie
DELETE - usuwa dane z bazy
INSERT INTO - dodaje nowe dane do bazy
CREATE DATABASE - tworzy nowa baze danych
ALTER DATABASE - modyfikuje baze danych
CREATE TABLE - tworzy tabele
ALTER TABLE - modyfikuje tabele
DROP TABLE - usuwa tabele
CREATE INDEX - tworzy indexy (klucze do wyszukiwania) (search keys)
DROP INDEX - usuwa indexy

SELECT:
wyberanie danych z poszczeg�lnych kolumn:
SELECT column1, column2, ...
FROM table_name;

wybieranie wszystkich danych:
SELECT * FROM table_name; 

wybieranie nie powtarzaj�cych si� warto�ci:
SELECT DISTINCT column1, column2, ...
FROM table_name;

Wynikiem jest liczba r�zni�cych si� record�w:
SELECT COUNT(DISTINCT Country) FROM Customers;

Wyodr�bnianie record�w spe�niaj�cych okre�lone warunki:
SELECT column1, column2, ...
FROM table_name
WHERE condition;

OPERATORY do zastosowania w "condition":
=	Equal
<>	Not equal. Note: In some versions of SQL this operator may be written as !=
>	Greater than
<	Less than
>=	Greater than or equal
<=	Less than or equal
BETWEEN	Between an inclusive range
LIKE	Search for a pattern
IN	To specify multiple possible values for a column

OPERATORY LOGICZNE:
NOT odpowiednik !, AND odpowiednik &&, OR odpowiednik || 

KOLEJNO��:
SELECT column1, column2, ...
FROM table_name
ORDER BY column1, column2, ... ASC|DESC; 
//ASC dla rosn�cych -> domy�lny
//DESC dla malej�cych -> trzeba go u�y�

SELECT * FROM Customers
ORDER BY Country ASC, CustomerName DESC;
//rosn�ce dla Country, 
//malej�ce dla CustomerName

INSERT INTO:
Dodawanie warto�ci do bazy w okre�lone kolumny:
INSERT INTO table_name (column1, column2, column3, ...)
VALUES (value1, value2, value3, ...);

Dodawanie do wszystkich kolumn:
INSERT INTO table_name
VALUES (value1, value2, value3, ...);

*Rekord zostaje dodany na koniec tabeli

NULL Value:
aby odnale�� rekordy posiadaj�ce NULL w okre�lonej kolumnie:
SELECT column_names
FROM table_name
WHERE column_name IS NULL;

aby odnale�� rekordy nie posiadaj�ce NULL w okre�lonych kolumnach:
SELECT column_names
FROM table_name
WHERE column_name IS NOT NULL;

aktualizowanie stanu dla rekord�w spe�niaj�cych okre�lony warunek:
UPDATE table_name
SET column1 = value1, column2 = value2, ...
WHERE condition;

UPDATE Customers
SET ContactName = 'Alfred Schmidt', City= 'Frankfurt'
WHERE CustomerID = 1;

dla wszystkich rekord�w (tutaj nale�y uwa�a� na cz�sto niechcian� podmian�): 
UPDATE Customers
SET ContactName='Juan';

usuwanie rekord�w:
DELETE FROM table_name
WHERE condition;

usuni�cie wszystkich rekord�w: 
DELETE FROM table_name; lub DELETE * FROM table_name;

zwr�cenie wybranej cz�ci rekord�w z TOPu(G�rnej cz�ci tabeli/pocz�tku):
SQL Server: 
SELECT TOP number|percent column_name(s)
FROM table_name
WHERE condition;

MySQL:
SELECT column_name(s)
FROM table_name
WHERE condition
LIMIT number;

Oracle:
SELECT column_name(s)
FROM table_name
WHERE ROWNUM <= number;

przyk�ady
Wyb�r trzech rekord�w z pocz�tku listy spe�niaj�cych warunek: 
SELECT TOP 3 * FROM Customers
WHERE Country='Germany';

SELECT * FROM Customers
WHERE Country='Germany'
LIMIT 3;

SELECT * FROM Customers
WHERE Country='Germany' AND ROWNUM <= 3; //gdzie ROWNUM oznacza liczb� wierszy\

wybieranie najmniejszej/najwi�kszej warto�ci z tabeli: 

SELECT MIN(column_name)
FROM table_name
WHERE condition;

SELECT MAX(column_name)
FROM table_name
WHERE condition;

SELECT MAX(Price) AS LargestPrice 
FROM Products;

SELECT MIN(Price) AS SmallestPrice
FROM Products;

DZIA�ANIA KT�RE MO�EMY WYKONA� POS�UGUJ�� SI� SQLem : 
wyznaczenie ilo�ci: 
SELECT COUNT(ProductID)
FROM Products;

wyznaczenie �redniej warto�ci:
SELECT AVG(Price)
FROM Products;

wyznaczenie sumy:
SELECT SUM(Quantity)
FROM OrderDetails;

*************operator LIKE***********************
% - The percent sign represents zero, one, or multiple characters
_ - The underscore represents a single character\

SELECT column1, column2, ...
FROM table_name
WHERE columnN LIKE pattern;

WHERE CustomerName LIKE 'a%'	znajduje warto�ci zaczynaj�ce si� od "a"
WHERE CustomerName LIKE '%a'	znajduje warto�ci ko�cz�ce si� na "a"
WHERE CustomerName LIKE '%or%'	znajduje warto�ci "or" b�d�ce na dowolnej pozycji
WHERE CustomerName LIKE '_r%'	znajduje warto�ci "r" b�d�ce na drugim miejscu
WHERE CustomerName LIKE 'a_%_%'	znajduje warto�ci posiadaj�ce a na pierwszy miejscu "a" i posiadaj�ce przynajmniej 3 znaki d�ugo�ci
WHERE ContactName LIKE 'a%o'	znajduje warto�ci posiadaj�ce "a" na pocz�tku i "o" nma ko�cu

SELECT * FROM Customers
WHERE CustomerName LIKE '%a';

[charlist] - znaki od kt�rych np mo�e si� zaczyna� dana poszukiwana warto��: 
SELECT * FROM Customers
WHERE City LIKE '[bsp]%';

[a-z] - przedzia� znak�w:
SELECT * FROM Customers
WHERE City LIKE '[a-c]%';

SELECT * FROM Customers
WHERE City LIKE '[!bsp]%'; lub SELECT * FROM Customers
                               WHERE City NOT LIKE '[bsp]%';

Operator IN pozwalaj�cy na okre�lenie kilku warto�ci w operatorze WHERE,  odpowiednik OR: 

SELECT column_name(s)					SELECT column_name(s)					
FROM table_name					lub 	FROM table_name						
WHERE column_name IN (value1, value2, ...);		WHERE column_name IN (SELECT STATEMENT);

Zastosowanie: 

SELECT * FROM Customers
WHERE Country IN ('Germany', 'France', 'UK');

SELECT * FROM Customers
WHERE Country IN (SELECT Country FROM Suppliers);

Operator BETWEEN pozwalaj�cy nam okre�li� odpowiedni przedzia� warto�ci: 

SELECT column_name(s)
FROM table_name
WHERE column_name BETWEEN value1 AND value2;

Zastosowanie:

SELECT * FROM Products
WHERE Price BETWEEN 10 AND 20;

Operator AS tworz�cy ALIAS, czyli tymczasow� nazw� u�atwiaj�c� czytelno�� tabeli:
Nadanie aliasu kolumnom:
SELECT column_name AS alias_name
FROM table_name;

Nadanie aliasu tabeli: 
SELECT column_name(s)
FROM table_name AS alias_name;

Zastosowanie:
SELECT CustomerID AS ID, CustomerName AS Customer
FROM Customers;

DZIA�ANAI NA ZBIORACH: 

Cz�� wsp�lna zbioru A n B:

SELECT Orders.OrderID, Customers.CustomerName, Orders.OrderDate
FROM Orders
INNER JOIN Customers ON Orders.CustomerID=Customers.CustomerID;


(INNER) JOIN: Returns records that have matching values in both tables
SELECT column_name(s)
FROM table1
INNER JOIN table2 ON table1.column_name = table2.column_name;
przyk�ad:
SELECT Orders.OrderID, Customers.CustomerName
FROM Orders
INNER JOIN Customers ON Orders.CustomerID = Customers.CustomerID;
po��czenie trzech tabeli:
SELECT Orders.OrderID, Customers.CustomerName, Shippers.ShipperName
FROM ((Orders
INNER JOIN Customers ON Orders.CustomerID = Customers.CustomerID)
INNER JOIN Shippers ON Orders.ShipperID = Shippers.ShipperID);

A u (A n B) (LEFT JOIN): 
SELECT column_name(s)
FROM table1
LEFT JOIN table2 ON table1.column_name = table2.column_name;

przyk�ad:
SELECT Customers.CustomerName, Orders.OrderID
FROM Customers
LEFT JOIN Orders ON Customers.CustomerID = Orders.CustomerID
ORDER BY Customers.CustomerName;

B u (A n B) (RIGHT JOIN):
SELECT column_name(s)
FROM table1
RIGHT JOIN table2 ON table1.column_name = table2.column_name;

przyk�ad:
SELECT Orders.OrderID, Employees.LastName, Employees.FirstName
FROM Orders
RIGHT JOIN Employees ON Orders.EmployeeID = Employees.EmployeeID
ORDER BY Orders.OrderID;

A u B (FULL JOIN):
SELECT column_name(s)
FROM table1
FULL OUTER JOIN table2 ON table1.column_name = table2.column_name;

przyk�ad:
SELECT Customers.CustomerName, Orders.OrderID
FROM Customers
FULL OUTER JOIN Orders ON Customers.CustomerID=Orders.CustomerID
ORDER BY Customers.CustomerName;

SELF JOIN:
SELECT A.CustomerName AS CustomerName1, B.CustomerName AS CustomerName2, A.City
FROM Customers A, Customers B
WHERE A.CustomerID <> B.CustomerID
AND A.City = B.City 
ORDER BY A.City;

SELECT A.CustomerName AS CustomerName1, B.CustomerName AS CustomerName2, A.City
FROM Customers A, Customers B
WHERE A.CustomerID <> B.CustomerID
AND A.City = B.City 
ORDER BY A.City;

SUMA OKRE�LONYCH KOLUMN(*bez duplikat�w):
SELECT column_name(s) FROM table1
UNION
SELECT column_name(s) FROM table2;

przyk�ad:
SELECT City FROM Customers
UNION
SELECT City FROM Suppliers
ORDER BY City;

SUMA OKRE�LONYCH KOLUMN Z DUPLIKATAMI:
SELECT column_name(s) FROM table1
UNION ALL
SELECT column_name(s) FROM table2;

przyk�ad:

SELECT City FROM Customers
UNION ALL
SELECT City FROM Suppliers
ORDER BY City;

Funkcja GROUP BY(funkcja grupowania): 

SELECT column_name(s)
FROM table_name
WHERE condition
GROUP BY column_name(s)
ORDER BY column_name(s);


przyk�ad:

SELECT COUNT(CustomerID), Country
FROM Customers
GROUP BY Country
ORDER BY COUNT(CustomerID) DESC;

HAVING u�ywamy z tego powodu i� WHERE nie mo�na stosowac wraz z funkcjami agerguj�cymi exp: (AVG(), COUNT()): 

SELECT column_name(s)
FROM table_name
WHERE condition
GROUP BY column_name(s)
HAVING condition
ORDER BY column_name(s);

przyk�ad:

SELECT COUNT(CustomerID), Country
FROM Customers
GROUP BY Country
HAVING COUNT(CustomerID) > 5;

Operacja EXIST, sprawdza czy istanieje rekord spe�niaj�cy dany warunek:
SELECT column_name(s)
FROM table_name
WHERE EXISTS
(SELECT column_name FROM table_name WHERE condition);

zstosowanie:
SELECT SupplierName
FROM Suppliers
WHERE EXISTS (SELECT ProductName FROM Products WHERE SupplierId = Suppliers.supplierId AND Price < 20);

OPERATORY ANY i ALL: 
SELECT column_name(s)
FROM table_name
WHERE column_name operator ANY //gdzie operator to: =, <>, !=, >, >=, <, or <=
(SELECT column_name FROM table_name WHERE condition);

SELECT column_name(s)
FROM table_name
WHERE column_name operator ALL //gdzie operator to: =, <>, !=, >, >=, <, or <=
(SELECT column_name FROM table_name WHERE condition);

Komenda SELECT INTO pozwala na skopiowanie danych z jednej tabeli do tabeli nowej:
skopiowanie wszystkich kolumn
SELECT *
INTO newtable [IN externaldb]
FROM oldtable
WHERE condition;

b�d� tylko wybrane kolumny: 
SELECT column1, column2, column3, ...
INTO newtable [IN externaldb]
FROM oldtable
WHERE condition;

utworzenie Backup'u w obecnej bazie danych:
SELECT * INTO CustomersBackup2017
FROM Customers;

Utworzenie Backup'u w nowej bazie danych:
SELECT * INTO CustomersBackup2017 IN 'Backup.mdb'
FROM Customers;

wybrane kolumny:
SELECT CustomerName, ContactName INTO CustomersBackup2017
FROM Customers;

wybrane kolumny z warunku WHERE:
SELECT * INTO CustomersGermany
FROM Customers
WHERE Country = 'Germany';

wybranie danych z wi�cej ni� jednej tabeli: 
SELECT Customers.CustomerName, Orders.OrderID
INTO CustomersOrderBackup2017
FROM Customers
LEFT JOIN Orders ON Customers.CustomerID = Orders.CustomerID;

PRO TIP: 
Przy pomocy odpowiedniego zapytania mo�emy utworzy� now� tabel� o schemacie starej, aczkolwiek nie zawieraj�c� danych: 
SELECT * INTO newtable
FROM oldtable
WHERE 1 = 0;

INSERT INTO SELECT:

INSERT INTO table2
SELECT * FROM table1
WHERE condition;

INSERT INTO table2 (column1, column2, column3, ...)
SELECT column1, column2, column3, ...
FROM table1
WHERE condition;
 
przyk�ady:

INSERT INTO Customers (CustomerName, City, Country)
SELECT SupplierName, City, Country FROM Suppliers;

INSERT INTO Customers (CustomerName, City, Country)
SELECT SupplierName, City, Country FROM Suppliers
WHERE Country='Germany';

rozwi�zywanie problem�w z miejscami o warto�ci NULL:
MySQL:
SELECT ProductName, UnitPrice * (UnitsInStock + IFNULL(UnitsOnOrder, 0))
FROM Products

SQL Server:
SELECT ProductName, UnitPrice * (UnitsInStock + ISNULL(UnitsOnOrder, 0))
FROM Products

MS Access:
SELECT ProductName, UnitPrice * (UnitsInStock + IIF(IsNull(UnitsOnOrder), 0, UnitsOnOrder))
FROM Products

Oracle:
SELECT ProductName, UnitPrice * (UnitsInStock + NVL(UnitsOnOrder, 0))
FROM Products

!!WA�NE!! tworzenie procedur w j�zyku SQL:
tworzenie:
CREATE PROCEDURE procedure_name
AS
sql_statement
GO;
egzekwowanie:
EXEC procedure_name;

przyk�ad:
CREATE PROCEDURE SelectAllCustomers
AS
SELECT * FROM Customers
GO;

EXEC SelectAllCustomers;

KOMENTARZE:
jednowierszowe:
--Select all:
SELECT * FROM Customers;
wielowierszowe:
/*SELECT * FROM Customers;
SELECT * FROM Products;
SELECT * FROM Orders;
SELECT * FROM Categories;*/
SELECT * FROM Suppliers;

od TIMA:
tworzenie widok�w, pozwala niekiedy zabezpieczy� informacje przed niechcianym dost�pem
CREATE VIEW view_name
AS SELECT columns
FROM tables