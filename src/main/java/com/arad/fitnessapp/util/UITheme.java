package com.arad.fitnessapp.util;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;


/**
 * Application UI theme manager.
 *
 * Handles global Swing appearance settings.
 */
public class UITheme {


    private static final Color PRIMARY_COLOR =
            new Color(
                    52,
                    152,
                    219
            );


    private static final Color BACKGROUND_COLOR =
            new Color(
                    245,
                    247,
                    250
            );


    private static final Color SIDEBAR_COLOR =
            new Color(
                    34,
                    40,
                    49
            );


    private static final Color TEXT_COLOR =
            new Color(
                    45,
                    45,
                    45
            );




    /**
     * Initializes application look and feel.
     */
    public static void setup() {


        FlatLightLaf.setup();



        UIManager.put(
                "defaultFont",
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );



        UIManager.put(
                "Button.arc",
                12
        );


        UIManager.put(
                "Component.arc",
                10
        );


        UIManager.put(
                "TextComponent.arc",
                10
        );


        UIManager.put(
                "ScrollBar.width",
                12
        );


        UIManager.put(
                "Panel.background",
                BACKGROUND_COLOR
        );


        UIManager.put(
                "Button.background",
                PRIMARY_COLOR
        );


        UIManager.put(
                "Button.foreground",
                Color.WHITE
        );


        UIManager.put(
                "Label.foreground",
                TEXT_COLOR
        );
    }






    public static Color getPrimaryColor() {

        return PRIMARY_COLOR;
    }





    public static Color getBackgroundColor() {

        return BACKGROUND_COLOR;
    }





    public static Color getSidebarColor() {

        return SIDEBAR_COLOR;
    }





    public static Color getTextColor() {

        return TEXT_COLOR;
    }
}