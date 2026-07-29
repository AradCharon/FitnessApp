package com.arad.fitnessapp.dao;

import com.arad.fitnessapp.database.DatabaseConnection;
import com.arad.fitnessapp.model.User;
import com.arad.fitnessapp.util.PasswordUtil;

import java.sql.*;

/**
 * Data access object for User entity.
 *
 * Handles user related database operations.
 */
public class UserDAO {


    /**
     * Saves a new user into database.
     *
     * @param user user object
     * @return generated user id
     */
    public int save(
            User user
    ) {


        String sql =
                """
                INSERT INTO users
                (
                    username,
                    password,
                    name,
                    age,
                    height,
                    weight
                )
                VALUES
                (?, ?, ?, ?, ?, ?)
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


            statement.setString(
                    1,
                    user.getUsername()
            );


            /*
             * Password is stored as BCrypt hash.
             * Plain password is never saved in database.
             */
            statement.setString(
                    2,
                    PasswordUtil.hashPassword(
                            user.getPassword()
                    )
            );


            statement.setString(
                    3,
                    user.getName()
            );


            statement.setInt(
                    4,
                    user.getAge()
            );


            statement.setDouble(
                    5,
                    user.getHeight()
            );


            statement.setDouble(
                    6,
                    user.getWeight()
            );


            statement.executeUpdate();


            ResultSet keys =
                    statement.getGeneratedKeys();


            if (keys.next()) {

                user.setId(
                        keys.getInt(1)
                );

                return user.getId();
            }


        } catch (SQLException exception) {

            throw new RuntimeException(
                    "Failed to save user",
                    exception
            );
        }


        return -1;
    }





    /**
     * Finds user by id.
     *
     * @param id user id
     * @return user object or null
     */
    public User findById(
            int id
    ) {


        String sql =
                """
                SELECT *
                FROM users
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
                    id
            );


            ResultSet result =
                    statement.executeQuery();


            if (result.next()) {

                return mapUser(
                        result
                );
            }


        } catch (SQLException exception) {

            throw new RuntimeException(
                    "Failed to find user",
                    exception
            );
        }


        return null;
    }





    /**
     * Finds user by username.
     *
     * Used for authentication.
     *
     * @param username username
     * @return user object or null
     */
    public User findByUsername(
            String username
    ) {


        String sql =
                """
                SELECT *
                FROM users
                WHERE username = ?
                """;


        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {


            statement.setString(
                    1,
                    username
            );


            ResultSet result =
                    statement.executeQuery();


            if (result.next()) {

                return mapUser(
                        result
                );
            }


        } catch (SQLException exception) {

            throw new RuntimeException(
                    "Failed to find user by username",
                    exception
            );
        }


        return null;
    }





    /**
     * Updates user profile.
     *
     * @param user user object
     */
    public void update(
            User user
    ) {


        String sql =
                """
                UPDATE users
                SET
                    name = ?,
                    age = ?,
                    height = ?,
                    weight = ?
                WHERE id = ?
                """;


        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {


            statement.setString(
                    1,
                    user.getName()
            );


            statement.setInt(
                    2,
                    user.getAge()
            );


            statement.setDouble(
                    3,
                    user.getHeight()
            );


            statement.setDouble(
                    4,
                    user.getWeight()
            );


            statement.setInt(
                    5,
                    user.getId()
            );


            statement.executeUpdate();


        } catch (SQLException exception) {

            throw new RuntimeException(
                    "Failed to update user",
                    exception
            );
        }
    }





    /**
     * Converts database row to User object.
     */
    private User mapUser(
            ResultSet result
    ) throws SQLException {


        return new User(
                result.getInt("id"),
                result.getString("username"),
                result.getString("password"),
                result.getString("name"),
                result.getInt("age"),
                result.getDouble("height"),
                result.getDouble("weight"),
                result.getTimestamp("created_at")
                        .toLocalDateTime()
        );
    }
}