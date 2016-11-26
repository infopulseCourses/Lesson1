package com.courses.lesson1;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Stepan
 */

public class Batch {
    public static void main(String[] args) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try {

            if (conn != null) {
                Statement st = conn.createStatement();
                String query = "INSERT INTO emp (name, surname) VALUES ('Julia','Ivanova')";
                String query1 = "INSERT INTO emp (name, surname) VALUES ('Oksana','Ok')";
                st.addBatch(query);
                st.addBatch(query1);
                int[] res = st.executeBatch();
                for (int re : res) {
                    System.out.println(re);
                    System.out.println("Success = " + (re == Statement.SUCCESS_NO_INFO));
                    System.out.println("Failed = " + (re == Statement.EXECUTE_FAILED));
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
