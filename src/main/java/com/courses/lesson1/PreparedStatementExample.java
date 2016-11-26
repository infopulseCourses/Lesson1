package com.courses.lesson1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Stepan
 */
public class PreparedStatementExample {

    public static void main(String[] args) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try {
            if (conn != null) {
                conn.setAutoCommit(false);
                String sql = "INSERT INTO emp (name, surname) VALUES (?,?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1,"Kolia");
                ps.setString(2,"Ivanov");
                ps.execute();
                conn.commit();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(conn != null) {
                conn.close();
            }
        }
    }
}
