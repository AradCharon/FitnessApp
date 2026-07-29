package com.arad.fitnessapp.ui;

import com.arad.fitnessapp.dao.UserDAO;
import com.arad.fitnessapp.model.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


/**
 * User profile management panel.
 */
public class ProfilePanel extends JPanel {


    private final User user;


    private final UserDAO userDAO;



    private JTextField nameField;

    private JTextField ageField;

    private JTextField heightField;

    private JTextField weightField;





    public ProfilePanel(
            User user
    ) {


        this.user = user;


        userDAO =
                new UserDAO();



        setLayout(
                new BorderLayout()
        );


        setBackground(
                new Color(
                        245,
                        247,
                        250
                )
        );


        setBorder(
                new EmptyBorder(
                        30,
                        30,
                        30,
                        30
                )
        );



        add(
                createTitle(),
                BorderLayout.NORTH
        );



        add(
                createForm(),
                BorderLayout.CENTER
        );
    }







    private JPanel createTitle() {


        JPanel panel =
                new JPanel(
                        new BorderLayout()
                );


        panel.setBackground(
                getBackground()
        );


        JLabel title =
                new JLabel(
                        "Profile Settings"
                );


        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        28
                )
        );



        panel.add(
                title,
                BorderLayout.WEST
        );


        return panel;
    }








    private JPanel createForm() {


        JPanel container =
                new JPanel(
                        new GridBagLayout()
                );


        container.setBackground(
                Color.WHITE
        );


        container.setBorder(
                BorderFactory.createEmptyBorder(
                        30,
                        50,
                        30,
                        50
                )
        );



        GridBagConstraints gbc =
                new GridBagConstraints();



        gbc.insets =
                new Insets(
                        10,
                        10,
                        10,
                        10
                );


        gbc.fill =
                GridBagConstraints.HORIZONTAL;



        nameField =
                new JTextField(
                        user.getName()
                );


        ageField =
                new JTextField(
                        String.valueOf(
                                user.getAge()
                        )
                );


        heightField =
                new JTextField(
                        String.valueOf(
                                user.getHeight()
                        )
                );


        weightField =
                new JTextField(
                        String.valueOf(
                                user.getWeight()
                        )
                );



        addRow(
                container,
                gbc,
                0,
                "Name",
                nameField
        );


        addRow(
                container,
                gbc,
                1,
                "Age",
                ageField
        );


        addRow(
                container,
                gbc,
                2,
                "Height",
                heightField
        );


        addRow(
                container,
                gbc,
                3,
                "Weight",
                weightField
        );



        JButton saveButton =
                new JButton(
                        "Save Changes"
                );



        saveButton.addActionListener(
                e -> saveChanges()
        );



        gbc.gridx = 1;

        gbc.gridy = 4;



        container.add(
                saveButton,
                gbc
        );



        return container;
    }








    private void addRow(
            JPanel panel,
            GridBagConstraints gbc,
            int row,
            String label,
            JTextField field
    ) {


        gbc.gridx = 0;

        gbc.gridy = row;



        panel.add(
                new JLabel(label),
                gbc
        );



        gbc.gridx = 1;



        panel.add(
                field,
                gbc
        );
    }









    private void saveChanges() {


        try {


            user.setName(
                    nameField.getText()
            );


            user.setAge(
                    Integer.parseInt(
                            ageField.getText()
                    )
            );


            user.setHeight(
                    Double.parseDouble(
                            heightField.getText()
                    )
            );


            user.setWeight(
                    Double.parseDouble(
                            weightField.getText()
                    )
            );



            userDAO.update(
                    user
            );



            JOptionPane.showMessageDialog(
                    this,
                    "Profile updated successfully"
            );



        } catch(Exception exception) {


            JOptionPane.showMessageDialog(
                    this,
                    "Invalid information",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}