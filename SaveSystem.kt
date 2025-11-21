import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

class SaveSystem {

    //url specifies the database file location
    // Create a connection to the database
    //connection object is an active link between kotlin app and a database

    public val connection: Connection = DriverManager.getConnection("jdbc:sqlite:test.db")
    fun establishConnection() {
        // SQLite connection string
        connection.use { conn ->
            println("Connection to SQLite has been established.")
        }
    }


    fun createTable() {

        //statement object lets you send SQL commands to database and retrieve
        val statement: Statement = connection.createStatement()

        // Create a new table
        statement.execute("""
            CREATE TABLE IF NOT EXISTS Events
            (id INTEGER PRIMARY KEY
            name TEXT, email TEXT, time TEXT,
            FOREIGN KEY (venueID) REFERENCES Venues(vID)) ON DELETE CASCADE
        """");
        //if an event is deleted, all associated venues via vID are also deleted

        statement.execute("""
            CREATE TABLE IF NOT EXISTS Venues
            (vID INTEGER PRIMARY KEY
            vName TEXT, address TEXT, capacity TEXT)"
        """");
    }


    fun insertData(eventString: String, venueString: String) {

        eventString.split("|||")

        val id = eventString[0].toString().toInt()
        val name = eventString[1]
        val email = eventString[2]
        val time = eventString[3]

        venueString.split("|||")
        val venueID = venueString[0].toString().toInt()
        val venueName = venueString[1]
        val address = venueString[2]
        val capacity = venueString[3]

        // Insert data into the table
        val statement: Statement = connection.createStatement()

        statement.execute("""
            INSERT INTO Events
            (id, name, email, time, venueID)
            VALUES ($id, $name, $email, $time, $venueID) 
        """);

        statement.execute("""
            INSERT INTO Events
            (vID, vName, address, capacity)
            VALUES ($venueID, $venueName, $address, $capacity) 
        """);


        println("Table created and data inserted.")


        fun queryUsers(connection: Connection) {
            val statement: Statement = connection.createStatement()

            //resultset holds data returned from query
            val resultSet: ResultSet = statement.executeQuery("SELECT * FROM person")
        }
    }
}
