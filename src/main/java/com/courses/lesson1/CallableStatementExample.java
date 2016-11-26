package com.courses.lesson1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

/**
 * @author Stepan
 */
public class CallableStatementExample {

    public static void main(String[] args) throws SQLException {
        Connection conn = ConnectionManager.getConnection();

        try {

            if (conn != null) {
                String sql = "{call getnamebyid(?,?)}";
                CallableStatement cs = conn.prepareCall(sql);
                cs.setInt(1, 1);
                cs.registerOutParameter(2, Types.VARCHAR);
                cs.execute();

                String name = cs.getString(2);
                System.out.println("Name = " + name);
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
