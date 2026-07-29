package com.arad.fitnessapp.model;

import java.time.LocalDateTime;


/**
 * Strength training exercise.
 */
public class StrengthExercise extends Exercise {


    private double weight;

    private int reps;





    public StrengthExercise(
            String name,
            int duration,
            double weight,
            int reps
    ) {

        super(
                name,
                duration
        );

        this.weight = weight;
        this.reps = reps;
    }







    public StrengthExercise(
            int id,
            String name,
            int duration,
            double weight,
            int reps,
            LocalDateTime date
    ) {

        super(
                id,
                name,
                duration,
                date
        );

        this.weight = weight;
        this.reps = reps;
    }






    @Override
    public double calculateCalories() {

        return duration * 8;
    }





    @Override
    public String getType() {

        return "STRENGTH";
    }





    public double getWeight() {

        return weight;
    }



    public int getReps() {

        return reps;
    }
}