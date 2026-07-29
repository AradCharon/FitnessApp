package com.arad.fitnessapp.ui.components;

import javax.swing.*;
import java.awt.*;

/**
 * Card component used for displaying statistics.
 */
public class StatCard extends JPanel {


    private final JLabel titleLabel;

    private final JLabel valueLabel;



    public StatCard(
            String title,
            String value
    ) {


        setLayout(
                new BorderLayout()
        );


        setPreferredSize(
                new Dimension(
                        200,
                        120
                )
        );


        setBackground(
                Color.WHITE
        );


        setBorder(
                BorderFactory.createEmptyBorder(
                        20,
                        20,
                        20,
                        20
                )
        );



        titleLabel =
                new JLabel(
                        title
                );


        titleLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );



        valueLabel =
                new JLabel(
                        value
                );


        valueLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        28
                )
        );



        add(
                titleLabel,
                BorderLayout.NORTH
        );


        add(
                valueLabel,
                BorderLayout.CENTER
        );
    }



    public void setValue(
            String value
    ) {

        valueLabel.setText(
                value
        );
    }
}