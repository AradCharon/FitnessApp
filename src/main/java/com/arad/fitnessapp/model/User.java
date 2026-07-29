package com.arad.fitnessapp.model;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


/**
 * User entity.
 */
public class User {


    private int id;


    private String username;


    private String password;


    private String name;


    private int age;


    private double height;


    private double weight;


    private LocalDateTime createdAt;



    private final List<Exercise> exercises =
            new ArrayList<>();





    /**
     * Full constructor.
     */
    public User(
            int id,
            String username,
            String password,
            String name,
            int age,
            double height,
            double weight,
            LocalDateTime createdAt
    ) {


        this.id = id;

        this.username = username;

        this.password = password;

        this.name = name;

        this.age = age;

        this.height = height;

        this.weight = weight;

        this.createdAt = createdAt;
    }







    /**
     * Constructor for creating new user.
     */
    public User(
            String username,
            String password,
            String name,
            int age,
            double height,
            double weight
    ) {


        this(
                0,
                username,
                password,
                name,
                age,
                height,
                weight,
                LocalDateTime.now()
        );
    }







    public int getId() {

        return id;
    }



    public void setId(
            int id
    ) {

        this.id = id;
    }







    public String getUsername() {

        return username;
    }







    public String getPassword() {

        return password;
    }



    public void setPassword(
            String password
    ) {

        this.password = password;
    }







    public String getName() {

        return name;
    }



    public void setName(
            String name
    ) {

        this.name = name;
    }







    public int getAge() {

        return age;
    }



    public void setAge(
            int age
    ) {

        this.age = age;
    }







    public double getHeight() {

        return height;
    }



    public void setHeight(
            double height
    ) {

        this.height = height;
    }







    public double getWeight() {

        return weight;
    }



    public void setWeight(
            double weight
    ) {

        this.weight = weight;
    }







    public LocalDateTime getCreatedAt() {

        return createdAt;
    }







    /**
     * Adds exercise to user's local list.
     *
     * Note:
     * Database storage is handled by ExerciseDAO.
     */
    public void addExercise(
            Exercise exercise
    ) {

        exercises.add(
                exercise
        );
    }







    /**
     * Returns user's exercises.
     */
    public List<Exercise> getExercises() {

        return exercises;
    }







    @Override
    public String toString() {

        return name +
                " (" +
                username +
                ")";
    }
}