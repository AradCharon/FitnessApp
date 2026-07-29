package com.arad.fitnessapp.service;

import com.arad.fitnessapp.dao.UserDAO;
import com.arad.fitnessapp.model.User;
import com.arad.fitnessapp.util.PasswordUtil;

/**
 * Service layer for authentication operations.
 *
 * Handles login verification and user authentication.
 */
public class AuthService {


    private final UserDAO userDAO;



    /**
     * Creates authentication service.
     */
    public AuthService() {

        userDAO = new UserDAO();
    }





    /**
     * Authenticates user with username and password.
     *
     * @param username username
     * @param password plain password entered by user
     * @return authenticated user or null
     */
    public User login(
            String username,
            String password
    ) {


        User user =
                userDAO.findByUsername(
                        username
                );


        if (user == null) {

            return null;
        }



        boolean passwordMatches =
                PasswordUtil.verifyPassword(
                        password,
                        user.getPassword()
                );



        if (passwordMatches) {

            return user;
        }



        return null;
    }





    /**
     * Registers a new user.
     *
     * @param user user object
     * @return created user id
     */
    public int register(
            User user
    ) {

        return userDAO.save(
                user
        );
    }
}