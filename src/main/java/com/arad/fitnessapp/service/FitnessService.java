package com.arad.fitnessapp.service;

import com.arad.fitnessapp.dao.ExerciseDAO;
import com.arad.fitnessapp.dao.UserDAO;
import com.arad.fitnessapp.model.Exercise;
import com.arad.fitnessapp.model.User;

import java.util.List;

/**
 * Service layer for fitness application.
 *
 * Coordinates communication between UI
 * and database access layer.
 */
public class FitnessService {


    private final UserDAO userDAO;

    private final ExerciseDAO exerciseDAO;



    /**
     * Creates fitness service instance.
     */
    public FitnessService() {

        this.userDAO =
                new UserDAO();

        this.exerciseDAO =
                new ExerciseDAO();
    }





    /**
     * Creates a new user.
     *
     * @param user user object
     * @return saved user id
     */
    public int createUser(
            User user
    ) {

        validateUser(
                user
        );


        return userDAO.save(
                user
        );
    }





    /**
     * Loads user from database.
     *
     * @param id user id
     * @return user object
     */
    public User getUser(
            int id
    ) {

        return userDAO.findById(
                id
        );
    }





    /**
     * Updates user information.
     *
     * @param user updated user
     */
    public void updateUser(
            User user
    ) {

        validateUser(
                user
        );


        userDAO.update(
                user
        );
    }





    /**
     * Adds new exercise for user.
     *
     * @param user owner user
     * @param exercise exercise object
     */
    public void addExercise(
            User user,
            Exercise exercise
    ) {


        validateExercise(
                exercise
        );


        exerciseDAO.save(
                exercise,
                user.getId()
        );


        user.addExercise(
                exercise
        );
    }





    /**
     * Loads user's exercises.
     *
     * @param user user
     * @return list of exercises
     */
    public List<Exercise> getExercises(
            User user
    ) {


        List<Exercise> exercises =
                exerciseDAO.findByUserId(
                        user.getId()
                );


        user.getExercises()
                .clear();


        user.getExercises()
                .addAll(
                        exercises
                );


        return exercises;
    }





    /**
     * Calculates total burned calories.
     */
    public double calculateTotalCalories(
            User user
    ) {


        double total = 0;



        for (Exercise exercise :
                user.getExercises()) {


            total +=
                    exercise.calculateCalories();
        }



        return total;
    }





    /**
     * Calculates total workout duration.
     */
    public int calculateTotalDuration(
            User user
    ) {


        int total = 0;



        for (Exercise exercise :
                user.getExercises()) {


            total +=
                    exercise.getDuration();
        }



        return total;
    }





    /**
     * Validates user information.
     */
    private void validateUser(
            User user
    ) {


        if (user == null) {

            throw new IllegalArgumentException(
                    "User cannot be null"
            );
        }


        if (user.getName() == null ||
                user.getName().isBlank()) {


            throw new IllegalArgumentException(
                    "User name is required"
            );
        }


        if (user.getAge() <= 0) {

            throw new IllegalArgumentException(
                    "Invalid age"
            );
        }


        if (user.getHeight() <= 0 ||
                user.getWeight() <= 0) {


            throw new IllegalArgumentException(
                    "Invalid body information"
            );
        }
    }





    /**
     * Validates exercise information.
     */
    private void validateExercise(
            Exercise exercise
    ) {


        if (exercise == null) {

            throw new IllegalArgumentException(
                    "Exercise cannot be null"
            );
        }


        if (exercise.getName() == null ||
                exercise.getName().isBlank()) {


            throw new IllegalArgumentException(
                    "Exercise name is required"
            );
        }


        if (exercise.getDuration() <= 0) {

            throw new IllegalArgumentException(
                    "Duration must be positive"
            );
        }
    }
}