package com.arad.fitnessapp.ui.components;

import javax.swing.*;
import java.awt.*;

/**
 * Custom rounded button component.
 *
 * Used throughout the application UI.
 */
public class RoundedButton extends JButton {


    private final Color backgroundColor;



    public RoundedButton(String text) {

        super(text);

        this.backgroundColor =
                new Color(46, 204, 113);


        initialize();
    }



    private void initialize() {


        setForeground(Color.WHITE);

        setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );


        setFocusPainted(false);

        setBorderPainted(false);


        setContentAreaFilled(false);


        setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );
    }



    @Override
    protected void paintComponent(Graphics graphics) {


        Graphics2D g2 =
                (Graphics2D) graphics;


        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );


        g2.setColor(
                backgroundColor
        );


        g2.fillRoundRect(
                0,
                0,
                getWidth(),
                getHeight(),
                20,
                20
        );


        super.paintComponent(graphics);
    }
}