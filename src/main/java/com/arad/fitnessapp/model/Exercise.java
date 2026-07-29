package com.arad.fitnessapp.model;

import java.time.LocalDateTime;


/**
 * Base exercise class.
 */
public abstract class Exercise {


    protected int id;

    protected String name;

    protected int duration;

    protected LocalDateTime date;





    public Exercise(
            String name,
            int duration
    ) {

        this(
                0,
                name,
                duration,
                LocalDateTime.now()
        );
    }






    public Exercise(
            int id,
            String name,
            int duration,
            LocalDateTime date
    ) {

        this.id = id;
        this.name = name;
        this.duration = duration;
        this.date = date;
    }






    public abstract double calculateCalories();


    public abstract String getType();






    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }




    public String getName() {
        return name;
    }




    public int getDuration() {
        return duration;
    }




    public LocalDateTime getDate() {
        return date;
    }





    @Override
    public String toString() {

        return name +
                " | " +
                getType() +
                " | " +
                duration +
                " min | " +
                String.format(
                        "%.0f kcal",
                        calculateCalories()
                );
    }
}