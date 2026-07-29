package com.arad.fitnessapp.util;

/**
 * Utility class responsible for validating user inputs.
 *
 * This class contains reusable validation methods
 * used throughout the application.
 */
public final class Validator {


    private Validator() {

        // Prevent object creation.
    }



    /**
     * Checks whether a text value is empty.
     *
     * @param value input text
     * @return true if value is empty or null
     */
    public static boolean isEmpty(String value) {

        return value == null
                || value.trim().isEmpty();
    }



    /**
     * Validates a person's age.
     *
     * @param age person's age
     * @return true if age is reasonable
     */
    public static boolean isValidAge(int age) {

        return age >= 1
                && age <= 120;
    }



    /**
     * Validates height value.
     *
     * @param height height in centimeters
     * @return true if height is valid
     */
    public static boolean isValidHeight(double height) {

        return height >= 50
                && height <= 250;
    }



    /**
     * Validates weight value.
     *
     * @param weight weight in kilograms
     * @return true if weight is valid
     */
    public static boolean isValidWeight(double weight) {

        return weight >= 10
                && weight <= 300;
    }



    /**
     * Validates exercise duration.
     *
     * @param duration duration in minutes
     * @return true if duration is positive
     */
    public static boolean isValidDuration(int duration) {

        return duration > 0
                && duration <= 1440;
    }



    /**
     * Validates numeric values.
     *
     * @param value numeric text
     * @return true if text can be converted to number
     */
    public static boolean isNumeric(String value) {

        if (isEmpty(value)) {

            return false;
        }


        try {

            Double.parseDouble(value);

            return true;

        } catch (NumberFormatException exception) {

            return false;
        }
    }
}