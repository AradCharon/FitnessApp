package com.arad.fitnessapp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Handles MySQL database connection.
 */
public class DatabaseConnection {


    private static final String URL =
            "jdbc:mysql://localhost:3306/fitness_app";


    private static final String USER =
            "root";


    private static final String PASSWORD =
            "1385Arad1385";



    /**
     * Creates database connection.
     *
     * @return active connection
     */
    public static Connection getConnection()
            throws SQLException {


        return DriverManager.getConnection(
                URL,
                USER,
                PASSWORD
        );
    }
}