package com.arad.fitnessapp.util;

import org.mindrot.jbcrypt.BCrypt;

public final class PasswordUtil {


    private PasswordUtil() {

    }


    public static String hashPassword(
            String password
    ) {

        return BCrypt.hashpw(
                password,
                BCrypt.gensalt(12)
        );
    }



    public static boolean verifyPassword(
            String password,
            String hashedPassword
    ) {

        return BCrypt.checkpw(
                password,
                hashedPassword
        );
    }
}