package com.arad.fitnessapp.ui.components;

import javax.swing.*;
import java.awt.*;


/**
 * Application footer.
 */
public class Footer extends JPanel {


    public Footer() {


        setLayout(
                new FlowLayout(
                        FlowLayout.CENTER
                )
        );


        setBackground(
                Color.WHITE
        );



        JLabel label =
                new JLabel(
                        "AradCharon"
                );


        label.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        12
                )
        );


        label.setForeground(
                Color.GRAY
        );



        add(
                label
        );
    }
}