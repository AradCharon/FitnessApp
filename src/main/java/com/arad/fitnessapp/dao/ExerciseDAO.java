package com.arad.fitnessapp.dao;

import com.arad.fitnessapp.database.DatabaseConnection;
import com.arad.fitnessapp.model.CardioExercise;
import com.arad.fitnessapp.model.Exercise;
import com.arad.fitnessapp.model.StrengthExercise;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


/**
 * Data Access Object for Exercise entity.
 *
 * Handles CRUD operations for exercises table.
 */
public class ExerciseDAO {


    /**
     * Saves a new exercise for a user.
     *
     * @param exercise exercise object
     * @param userId owner user id
     * @return generated exercise id
     */
    public int save(
            Exercise exercise,
            int userId
    ) {


        String sql =
                """
                INSERT INTO exercises
                (
                    user_id,
                    name,
                    type,
                    duration,
                    calories,
                    weight,
                    reps,
                    distance
                )
                VALUES
                (?, ?, ?, ?, ?, ?, ?, ?)
                """;



        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(
                                sql,
                                Statement.RETURN_GENERATED_KEYS
                        )
        ) {



            statement.setInt(
                    1,
                    userId
            );


            statement.setString(
                    2,
                    exercise.getName()
            );


            statement.setString(
                    3,
                    exercise.getType()
            );


            statement.setInt(
                    4,
                    exercise.getDuration()
            );


            statement.setDouble(
                    5,
                    exercise.calculateCalories()
            );



            if (exercise instanceof StrengthExercise strength) {


                statement.setDouble(
                        6,
                        strength.getWeight()
                );


                statement.setInt(
                        7,
                        strength.getReps()
                );


                statement.setNull(
                        8,
                        Types.DOUBLE
                );


            } else if (exercise instanceof CardioExercise cardio) {


                statement.setNull(
                        6,
                        Types.DOUBLE
                );


                statement.setNull(
                        7,
                        Types.INTEGER
                );


                statement.setDouble(
                        8,
                        cardio.getDistance()
                );

            } else {


                throw new IllegalArgumentException(
                        "Unknown exercise type"
                );
            }



            statement.executeUpdate();



            ResultSet keys =
                    statement.getGeneratedKeys();



            if (keys.next()) {


                int id =
                        keys.getInt(1);


                exercise.setId(
                        id
                );


                return id;
            }



        } catch (SQLException exception) {


            throw new RuntimeException(
                    "Failed to save exercise",
                    exception
            );
        }



        return -1;
    }







    /**
     * Finds all exercises of a user.
     */
    public List<Exercise> findByUserId(
            int userId
    ) {


        List<Exercise> exercises =
                new ArrayList<>();



        String sql =
                """
                SELECT *
                FROM exercises
                WHERE user_id = ?
                ORDER BY date DESC
                """;



        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {



            statement.setInt(
                    1,
                    userId
            );



            ResultSet result =
                    statement.executeQuery();



            while (result.next()) {


                exercises.add(
                        mapExercise(
                                result
                        )
                );
            }



        } catch (SQLException exception) {


            throw new RuntimeException(
                    "Failed to load exercises",
                    exception
            );
        }



        return exercises;
    }








    /**
     * Counts user's exercises.
     */
    public int countByUserId(
            int userId
    ) {


        String sql =
                """
                SELECT COUNT(*)
                FROM exercises
                WHERE user_id = ?
                """;



        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {



            statement.setInt(
                    1,
                    userId
            );



            ResultSet result =
                    statement.executeQuery();



            if(result.next()) {

                return result.getInt(1);
            }



        } catch(SQLException exception) {


            throw new RuntimeException(
                    "Failed to count exercises",
                    exception
            );
        }



        return 0;
    }







    /**
     * Calculates total burned calories.
     */
    public double totalCaloriesByUserId(
            int userId
    ) {


        String sql =
                """
                SELECT COALESCE(SUM(calories),0)
                FROM exercises
                WHERE user_id = ?
                """;



        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {



            statement.setInt(
                    1,
                    userId
            );



            ResultSet result =
                    statement.executeQuery();



            if(result.next()) {

                return result.getDouble(1);
            }



        } catch(SQLException exception) {


            throw new RuntimeException(
                    "Failed to calculate calories",
                    exception
            );
        }



        return 0;
    }








    /**
     * Converts database row into Exercise object.
     */
    private Exercise mapExercise(
            ResultSet result
    ) throws SQLException {


        int id =
                result.getInt("id");


        String name =
                result.getString("name");


        int duration =
                result.getInt("duration");


        String type =
                result.getString("type");



        Timestamp timestamp =
                result.getTimestamp("date");



        LocalDateTime date =
                timestamp != null
                        ? timestamp.toLocalDateTime()
                        : LocalDateTime.now();




        if(type.equals("STRENGTH")) {


            return new StrengthExercise(
                    id,
                    name,
                    duration,
                    result.getDouble("weight"),
                    result.getInt("reps"),
                    date
            );


        } else {


            return new CardioExercise(
                    id,
                    name,
                    duration,
                    result.getDouble("distance"),
                    date
            );
        }
    }








    /**
     * Deletes an exercise.
     */
    public void delete(
            int exerciseId
    ) {


        String sql =
                """
                DELETE FROM exercises
                WHERE id = ?
                """;



        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {



            statement.setInt(
                    1,
                    exerciseId
            );



            statement.executeUpdate();



        } catch(SQLException exception) {


            throw new RuntimeException(
                    "Failed to delete exercise",
                    exception
            );
        }
    }
}