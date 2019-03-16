## JDBC
JDBC to skrót od nazwy JAVA DATABASE CONNECTIVITY
jest API (Application Programming Interface), ściśle określony zestaw reguł i ich opisów, w jaki programy komunikują się między sobą.
JDBC stanowi pomost pomiędzy aplikacją i źródłem danych np. Bazą danych. 
Aby użyć źródła danych w aplikacji niezbędne jest użycie sterownika JDBC (JDBC driver).
I tak aby otrzymać dostęp do bazy danych SQLite niezbędny jest "sqlite JDBC driver". 
Sterownik(driver) jest to biblioteka JAVAy zawierająca klasy implementujące JDBC API
JDBC zawiera dwie paczki: 
java.sql (rdzeń JDBC/core JDBC) i javax.sql(optiona JDBC)
javax.sql jest wymagany do pracy z bazami danych na serwerach.

Używając sqlite do łączenia z baza danych nie wymgane jest aby baza utworzona była wcześniej. sqlite utworzy ją za nas.

Bazy danych wymagają odpowiednich informacji w formie stringów.

W celu połączenia się z bazą danych używamy DriverManager'a:

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\szerlag\\Desktop\\Programowanie\\Java z Udemy\\Bazy danych i Java\\Databases\\JDBCtest\\testjdbc.db");

        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage() );
        }

    }
}

Zaleca się aby pisać blok 'try' w nowym stylu, gdyż wtedy zasoby automatycznie zostają zamknięte po wykonaniu bloku: 

  ``` try (Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\szerlag\\Desktop\\Programowanie\\Projekty\\INTELIJ\\JDBClearn\\testJDBC.db");
             Statement statement = conn.createStatement()) {
            statement.execute("CREATE TABLE kontakty (imie text, nazwisko text, wiek integer)"); {  statement.execute("CREATE TABLE kontakty (imie text, nazwisko text, wiek integer)");}
catch(SQLException e) {} ```

CRUD = (Create Read Update Delete)

Wysyłanie zapytań: 
Statement statement = conn.createStatement();
statement.execute("CREATE TABLE IF NOT EXISTS kontakty" +
                    "   (imie text, nazwisko text, wiek integer)");


Pobieranie rezultatów z bazy danych: 
ResultSet results = statement.executeQuery("SELECT * FROM kontakty");

Otrzymywanie danych z odpowiedniej kolumny: 
results.getString("column_name"); 

Używanie instancji obiektów Statement nie jest dobrą praktyką i przy dużej liczbie zapytań może miec duży wpływ na wydajność naszej bazy danych.

W środowisku enterprise/przedsiębiorczym będziemy korzystać raczej z obiektów typu Prepared.

SQLInjection polega na zastosowaniu języka SQL w polu adresu, hasła, i użycia warunku, który zawsze jest prawdziwy np.  "1=1". Może to spowodować zwrócienie wszystkich wyników jakie utrzymywane są w bazie danych.
W tym przypadku bezpieczniejsze jest stosowanie metody PreparedStatement która dopuszcza tylko stosowanie literałów. 


Najważniejszą cechą PreparedStatement jest to iż możemy wypełnić ją parametrami unikając w ten sposób HARD Codingu. 
Miejsce w którym zostanie zaimplementowany parametr symobolizuje '?' 

Tworzenie obiektu PreparedStatement:
String updateString =
    "update " + dbName + ".COFFEES " +
    "set SALES = ? where COF_NAME = ?";
updateSales = con.prepareStatement(updateString);

Wypełnianie wartościami:
Schemat:
updateSales.setInt(1, e.getValue().intValue());
updateSales.setString(2, e.getKey());

Przykład:
updateSales.setInt(1, 100);
updateSales.setString(2, "French_Roast");
updateSales.executeUpdate();


Korzystanie z PreparedStatement: 
1. Deklaracja stałych wyrażeń SQL np:
 public static final String QUERY_ALBUMS_BY_ARTIST_START =
            "SELECT " + TABLE_ALBUMS + '.' + COLUMN_ALBUM_NAME + " FROM " + TABLE_ALBUMS +
                    " INNER JOIN " + TABLE_ARTISTS + " ON " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST +
                    " = " + TABLE_ARTISTS + "." + COLUMN_ARTIST_ID +
                    " WHERE " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + " = \"";
2. Stworzenie instancji PreparedStatement używając:
Connection.prepareStatement(sqlStmtString);
3. Wywołanie odpowiedniej metody metody set:
updateSales.setInt(1, e.getValue().intValue());
updateSales.setString(2, e.getKey());
4. Wywołanie wyrażenia używając metody PreparedStatement.execute();
5. Przetważamy resultaty w sposób ten sam jak korzystając z wyrażenia Statement

****************WAŻNE********************
TRANSACTIONS (TRANZAKCJE):
Tranzakcje to sekwencja poleceń SQL które są traktowane jako pojedyńcza jednostka. Jeżeli któreś z poleceń nie zostanie wykonane, poprzednie polecena zostaną cofnięte, będź teź niezapisane. Tak jakby to się nigdy nie wydarzyło. ;) 

Jeżeli mówimy o bazach danych to zazwyczaj używamy słowa "commit" niż "save/zapisać", odnosząc się do permanentnych zmian. 

Baza danych musi mieć następujące cechy: 
ACID – zbiór właściwości gwarantujących poprawne przetwarzanie transakcji w bazach danych. ACID jest skrótowcem od angielskich słów atomicity, consistency, isolation, durability, czyli niepodzielność[a], spójność, izolacja, trwałość[1].
https://pl.wikipedia.org/wiki/ACID -> Link do Wiki

1. Atomicity(niepodzielność/atomiczność) - jeżeli jedno polecenie nie zostanie wykonane, wszystkie polecenia zostają cofnięte. 
2. Consistency(spójność) - Przed rozpoczęciem tranzakcji baza danych posiada poprawny stan. Po zakońćzeniu tranzakcji baza danych jest wciąż w poprawnym stanie.
3. Isolation(izolacja) - Dopóki nie zostaną dokonane zmiany (zacommitowane), nie są widoczne dla innych połączeń. Tranzakcje nie mogą być zależne od siebie. 
4. Durability(trwałość) - Zmiany dokonane przez tranzakcje są permanentne. Jeżeli serwer pada zmiany dokonane przez tranzakcje sa wciąż w bazie danych po ponownym ich uruchomieniu. 

Korzystamy z tranzakcji tylko w przypadku dokonywania zmian w bazie danych. 
Jeżeli nie dokonujemy zmian nie potrzebujemy korzystać z tranzakcji. 
Za każdym razem gdy korzystamy z poleceń UPDATE, INSERT, DELETE powinna być dokonywana tranzakcja.

Pracując z sqlite następujące komendy służą do obsługiwania tranzakcji: 
1. BEGIN TRANSACTION - ręcznie rozpoczynamy tranzakcję
2. END TRANSACTION - ręcznie końćzymy tranzakcje. Commit zmian automatycznie kończy tranzakcję, z kolei END TRANSACTION powoduje Commit. Można uznać, że END TRANSACTION = COMMIT 
3. COMMIT Powoduje zapisanie zmian utworzonych przez tranzakcję
4. ROLLBACK - powoduje cofniecie nie zacommitowanych zmian i konczy tranzakcję. Należy zauważyć iż możemy cofnąc tylko zmiany mające miejsce od ostaniego COMMITu bądź ROLLBACKu. 

Zamykając połączenie przed dokonaniem commitu, zmiany zostają cofnięte.

!JEDNAK UŻYWAJĄC JDBC NIE KORZYSTAMY Z TRANZAKCJI-POWIĄZANYCH POLECANIAMI SQL, A UŻYWAMY OBIEKTU STATEMENT TO WYKONYWANIA ICH!

Aby dokonać tranzakcji przy pomocy JDBC musimy podążać z następującymi krokami: 
1. Wyłączamy default-owo ustawiony auto-commit-> Connection.setAutoCommit(false);
2. Uruchamiamy operacje SQL tworzące naszą tranzakcję
3. Jeżeli nie ma błędów wywołujemy Connection.commit();, jeżeli są błędy wywołujemy Connection.rollback();
4. Przywracamy defaultową wartośc auto-commit->  Connection.setAutoCommit(true); 

