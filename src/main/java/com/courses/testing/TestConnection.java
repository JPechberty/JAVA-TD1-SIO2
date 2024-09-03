package com.courses.testing;

import com.courses.tools.DataSourceProvider;
import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        Connection conn = null;

        try {
            MysqlDataSource dataSource = (MysqlDataSource) DataSourceProvider.getDataSourceInstance();
            conn = dataSource.getConnection();
            System.out.println("Connection successfully established !");

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }finally {
            try {
                if (conn!=null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
}
