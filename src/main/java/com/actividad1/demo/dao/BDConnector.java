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
                        "jdbc:mysql://coches-prueba.cx0imquaojhi.us-east-1.rds.amazonaws.com:3306/Actividad1",
                        "admin", "QTSiGwgBkgPb94");
                System.out.println("Conexión correcta");
            } catch (SQLException e) {
                System.out.println("Conexión fallida.");
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}
