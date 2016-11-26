package com.courses.lesson1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Stepan
 */
class ConnectionManager {

    /**
     * Provide your username, password and DB url to get connection object successfully
     * @return Connection object for you database
     * @throws SQLException
     */
    static Connection getConnection() throws SQLException {

        Properties connectionProps = new Properties();
        connectionProps.put("user", "postgres");
        connectionProps.put("password", "1q2w3e4r");

        return DriverManager.getConnection("jdbc:postgresql://localhost", connectionProps);
    }
}
