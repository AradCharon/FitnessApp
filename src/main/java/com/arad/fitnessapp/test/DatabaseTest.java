package com.arad.fitnessapp.test;

import com.arad.fitnessapp.database.DatabaseConnection;

import java.sql.Connection;

/**
 * Simple test class for verifying MySQL connection.
 */
public class DatabaseTest {

    public static void main(String[] args) {

        try (Connection connection =
                     DatabaseConnection.getConnection()) {

            if (connection != null) {

                System.out.println(
                        "Database connection successful!"
                );
            }

        } catch (Exception exception) {

            System.err.println(
                    "Database connection failed!"
            );

            exception.printStackTrace();
        }
    }
}