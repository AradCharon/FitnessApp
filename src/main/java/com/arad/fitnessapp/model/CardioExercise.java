package com.arad.fitnessapp.model;

import java.time.LocalDateTime;


/**
 * Cardio exercise.
 */
public class CardioExercise extends Exercise {


    private double distance;





    public CardioExercise(
            String name,
            int duration,
            double distance
    ) {

        super(
                name,
                duration
        );

        this.distance = distance;
    }







    public CardioExercise(
            int id,
            String name,
            int duration,
            double distance,
            LocalDateTime date
    ) {

        super(
                id,
                name,
                duration,
                date
        );

        this.distance = distance;
    }






    @Override
    public double calculateCalories() {

        return distance * 60;
    }






    @Override
    public String getType() {

        return "CARDIO";
    }






    public double getDistance() {

        return distance;
    }
}