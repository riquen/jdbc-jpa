package JDBC.MySQL;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private ConnectionFactory() {
        throw new UnsupportedOperationException();
    }

    public static Connection getConnection() {
        Connection conn = null;

        try (InputStream input = ConnectionFactory.class.getClassLoader().getResourceAsStream("connection.properties")) {
            Properties prop = new Properties();
            prop.load(input);

            String driver = prop.getProperty("jdbc.driver");
            String dbAddress = prop.getProperty("db.address");
            String dbName = prop.getProperty("db.name");
            String user = prop.getProperty("db.user.login");
            String password = prop.getProperty("db.user.password");

            String urlConnection = "jdbc:" +
                    driver + "://" +
                    dbAddress + "/" +
                    dbName;

            try {
                conn = DriverManager.getConnection(urlConnection, user, password);
            } catch (SQLException e) {
                System.out.println("Não conectado.");
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            System.out.println("Arquivos de propriedades não carregados.");
        }
        return conn;
    }
}
