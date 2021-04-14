package JDBC.PostgreSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {
    public static void main(String[] args) {
        String driver = "postgresql";
        String dbAddress = "localhost";
        String dbName = "financas";
        String user = "postgres";
        String password = "170495";

        String urlConnection = "jdbc:" +
                driver + "://" +
                dbAddress + "/" +
                dbName;

        try (Connection conn = DriverManager.getConnection(urlConnection, user, password)) {
            System.out.println("Conectado.");
        } catch (SQLException e) {
            System.out.println("Não conectado.");
            e.printStackTrace();
        }
    }
}
