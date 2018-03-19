package jdbc_homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connector{

    private static final String CREATE_IF_NO_EXIST = "?createDatabaseIfNotExist=true";
    private static final String MYSQL_CONFIG = "&useSSL=false";
    private static final String DEFAULTH_USER = "test";
    private static final String DEFAULTH_PASS = "1234";
    private static final String DEFAULTH_database = "1234";


    private static Connection connection = null;

    /**
     * Generate a connection that we would use to connect to the database
     *
     * @param driver   - database driver
     * @param username - database username
     * @param password - database password
     * @param host     - database IP Address
     * @param port     - database connection port
     * @param dbName   - database name
     * @throws SQLException
     */
    public static void initConnection(String driver, String username,
                                      String password, String host,
                                      String port, String dbName) throws SQLException {
        Properties connectionProp = new Properties();
        connectionProp.put("user", username);
        connectionProp.put("password", password);
        connection = DriverManager.getConnection("jdbc:" + driver + "://" + host + ":"
                + port + "/" + dbName + CREATE_IF_NO_EXIST + MYSQL_CONFIG, connectionProp);
    }

    public static Connection getConnection() {
        return connection;
    }

    public static Connection getDefaulthConnection() throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", DEFAULTH_USER);
        props.setProperty("password", DEFAULTH_PASS);
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/MinionsDB"
                + CREATE_IF_NO_EXIST + MYSQL_CONFIG, props)   ;
    }

    public static void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
