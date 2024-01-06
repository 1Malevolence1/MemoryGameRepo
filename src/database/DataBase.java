package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

abstract public class DataBase {
    protected static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                Config.getProperty(Config.DB_URL),
                Config.getProperty(Config.DB_LOGIN),
                Config.getProperty(Config.DB_PASSWORD));
    }
}
