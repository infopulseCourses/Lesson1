package com.courses.lesson1;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

/**
 * @author Stepan
 */
public class Transaction {

    public static void main(String[] args) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        String query = "INSERT INTO emp (name, surname) VALUES ('Roman1','Romanenko1')";
        String query1 = "INSERT INTO emp (name, surname) VALUES ('Andrey','OK')";

        try {

            if (conn != null) {
                conn.setAutoCommit(false);
                Statement st = conn.createStatement();
                Savepoint s = null;
                try {
                    s = conn.setSavepoint();
                    st.execute(query);
                    st.execute(query1);
                } catch (SQLException e) {
                    System.out.println("Rollback");
                    conn.rollback(s);
                } finally {
                    conn.commit();
                    conn.close();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }
}
