package com.arad.fitnessapp;


import com.arad.fitnessapp.ui.LoginFrame;
import com.arad.fitnessapp.util.UITheme;

import javax.swing.*;



/**
 * Application entry point.
 */
public class Main {


    public static void main(
            String[] args
    ) {


        SwingUtilities.invokeLater(
                () -> {


                    UITheme.setup();


                    new LoginFrame();

                }
        );
    }
}