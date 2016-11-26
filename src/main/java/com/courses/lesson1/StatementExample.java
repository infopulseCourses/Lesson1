package com.courses.lesson1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Stepan
 */
public class StatementExample {

    public static void main(String[] args) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try {

            if (conn != null) {
                Statement st = conn.createStatement();

                String insertQuery = "INSERT INTO emp (name , surname) values ('Semen', 'Semenuch')";
                st.execute(insertQuery);
                String selectQuery = "SELECT * FROM EMP";
                ResultSet rs = st.executeQuery(selectQuery);
                while (rs.next()) {
                    System.out.println(rs.getString("name") + " " + rs.getString("surname"));
                }
                rs.close();
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
