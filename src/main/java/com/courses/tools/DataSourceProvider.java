package com.courses.tools;


import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;

public class DataSourceProvider {
    private static MysqlDataSource instance;

    public static DataSource getDataSourceInstance() {
        if (instance == null) {
            instance = new MysqlDataSource();
            instance.setServerName("localhost");
            instance.setPort(3306);
            instance.setDatabaseName("app_db");
            instance.setUser("root");
            instance.setPassword("root");
        }
        return instance;
    }
}
