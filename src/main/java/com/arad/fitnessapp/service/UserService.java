package com.arad.fitnessapp.service;

import com.arad.fitnessapp.dao.UserDAO;
import com.arad.fitnessapp.model.User;

/**
 * Service layer for user-related operations.
 *
 * Handles communication between UI and UserDAO.
 */
public class UserService {

    private final UserDAO userDAO;

    /**
     * Creates user service.
     */
    public UserService() {
        this.userDAO = new UserDAO();
    }

    /**
     * Loads a user by id.
     *
     * @param userId user identifier
     * @return user or null if not found
     */
    public User loadUser(int userId) {
        return userDAO.findById(userId);
    }

    /**
     * Creates a default user.
     *
     * This method is only used for the first application launch
     * when the database does not contain any users.
     *
     * @return created user
     */
    public User createDefaultUser() {

        User user = new User(
                "guest",
                "123456",
                "Guest",
                20,
                175.0,
                70.0
        );

        userDAO.save(user);

        return user;
    }

    /**
     * Updates user profile.
     *
     * @param user user object
     */
    public void updateUser(User user) {
        userDAO.update(user);
    }
}