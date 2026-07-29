package com.arad.fitnessapp.util;

/**
 * Application-wide constant values.
 *
 * Keeping constants in one place improves maintainability
 * and prevents duplicated values across the project.
 */
public final class Constants {


    private Constants() {

        // Prevent object creation.
    }



    // Application information

    public static final String APP_NAME =
            "FitnessApp";


    public static final String APP_VERSION =
            "1.0.0";



    // Database configuration

    public static final String DATABASE_NAME =
            "fitness_app";


    public static final String DATABASE_URL =
            "jdbc:mysql://localhost:3306/"
                    + DATABASE_NAME;



    // UI configuration

    public static final int WINDOW_WIDTH =
            1200;


    public static final int WINDOW_HEIGHT =
            750;



    // Exercise types

    public static final String EXERCISE_STRENGTH =
            "STRENGTH";


    public static final String EXERCISE_CARDIO =
            "CARDIO";
}