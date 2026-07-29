package com.arad.fitnessapp.ui.components;

import javax.swing.*;
import java.awt.*;

/**
 * Custom button used in application sidebar navigation.
 */
public class SidebarButton extends JButton {


    private boolean active;



    public SidebarButton(String text) {

        super(text);

        this.active = false;

        initialize();
    }



    private void initialize() {


        setHorizontalAlignment(
                SwingConstants.LEFT
        );


        setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );


        setForeground(
                Color.WHITE
        );


        setBackground(
                new Color(34, 40, 49)
        );


        setBorder(
                BorderFactory.createEmptyBorder(
                        15,
                        20,
                        15,
                        20
                )
        );


        setFocusPainted(false);


        setBorderPainted(false);


        setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );
    }



    /**
     * Changes button selected state.
     */
    public void setActive(boolean active) {

        this.active = active;

        repaint();
    }



    @Override
    protected void paintComponent(Graphics graphics) {


        Graphics2D g2 =
                (Graphics2D) graphics;


        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );


        if (active) {

            g2.setColor(
                    new Color(
                            46,
                            204,
                            113
                    )
            );

        } else {

            g2.setColor(
                    new Color(
                            34,
                            40,
                            49
                    )
            );
        }



        g2.fillRoundRect(
                5,
                5,
                getWidth() - 10,
                getHeight() - 10,
                15,
                15
        );


        super.paintComponent(graphics);
    }
}