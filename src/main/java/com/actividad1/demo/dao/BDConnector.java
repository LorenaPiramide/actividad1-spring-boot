package com.actividad1.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDConnector {
    private static Connection connection;

    public BDConnector() {
    }

    public static Connection getInstance() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                        "coches-prueba.cx0imquaojhi.us-east-1.rds.amazonaws.com",
                        "admin", "QTSiGwgBkgPb94");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}
