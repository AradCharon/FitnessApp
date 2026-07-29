package com.arad.fitnessapp.ui;


import com.arad.fitnessapp.model.User;
import com.arad.fitnessapp.service.AuthService;
import com.arad.fitnessapp.ui.components.Footer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;



/**
 * Register window.
 *
 * Creates new user account.
 */
public class RegisterFrame extends JFrame {


    private final JTextField usernameField;

    private final JPasswordField passwordField;

    private final JTextField nameField;

    private final JTextField ageField;

    private final JTextField heightField;

    private final JTextField weightField;


    private final AuthService authService;





    public RegisterFrame() {


        authService =
                new AuthService();



        setTitle(
                "FitnessApp - Register"
        );



        setSize(
                500,
                750
        );



        setLocationRelativeTo(null);



        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );



        setLayout(
                new BorderLayout()
        );



        getContentPane()
                .setBackground(
                        new Color(
                                245,
                                247,
                                250
                        )
                );





        JPanel card =
                new JPanel();



        card.setLayout(
                new BoxLayout(
                        card,
                        BoxLayout.Y_AXIS
                )
        );



        card.setBackground(
                Color.WHITE
        );



        card.setBorder(
                new EmptyBorder(
                        35,
                        50,
                        35,
                        50
                )
        );



        card.setPreferredSize(
                new Dimension(
                        380,
                        600
                )
        );






        JLabel title =
                new JLabel(
                        "Create Account"
                );



        title.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );



        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        28
                )
        );





        JLabel subtitle =
                new JLabel(
                        "Join FitnessApp"
                );



        subtitle.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );



        subtitle.setForeground(
                Color.GRAY
        );



        subtitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        16
                )
        );






        usernameField =
                createTextField();



        passwordField =
                createPasswordField();



        nameField =
                createTextField();



        ageField =
                createTextField();



        heightField =
                createTextField();



        weightField =
                createTextField();






        JButton registerButton =
                createButton(
                        "Register"
                );



        JButton backButton =
                createButton(
                        "Back to Login"
                );







        card.add(
                title
        );


        card.add(
                Box.createVerticalStrut(
                        10
                )
        );



        card.add(
                subtitle
        );



        card.add(
                Box.createVerticalStrut(
                        25
                )
        );



        addInput(
                card,
                "Username",
                usernameField
        );


        addInput(
                card,
                "Password",
                passwordField
        );


        addInput(
                card,
                "Name",
                nameField
        );


        addInput(
                card,
                "Age",
                ageField
        );


        addInput(
                card,
                "Height (cm)",
                heightField
        );


        addInput(
                card,
                "Weight (kg)",
                weightField
        );



        card.add(
                Box.createVerticalStrut(
                        20
                )
        );



        card.add(
                registerButton
        );



        card.add(
                Box.createVerticalStrut(
                        10
                )
        );



        card.add(
                backButton
        );






        add(
                card,
                BorderLayout.CENTER
        );



        add(
                new Footer(),
                BorderLayout.SOUTH
        );







        registerButton.addActionListener(
                e -> register()
        );



        backButton.addActionListener(
                e -> dispose()
        );



        setVisible(true);
    }









    private void addInput(
            JPanel panel,
            String labelText,
            JComponent field
    ) {


        JLabel label =
                new JLabel(
                        labelText
                );



        label.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );



        label.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );



        panel.add(
                label
        );



        panel.add(
                Box.createVerticalStrut(
                        5
                )
        );



        panel.add(
                field
        );



        panel.add(
                Box.createVerticalStrut(
                        12
                )
        );
    }









    private JTextField createTextField() {


        JTextField field =
                new JTextField();



        field.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        35
                )
        );



        field.setHorizontalAlignment(
                JTextField.CENTER
        );



        return field;
    }









    private JPasswordField createPasswordField() {


        JPasswordField field =
                new JPasswordField();



        field.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        35
                )
        );



        field.setHorizontalAlignment(
                JTextField.CENTER
        );



        return field;
    }









    private JButton createButton(
            String text
    ) {


        JButton button =
                new JButton(
                        text
                );



        button.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );



        button.setMaximumSize(
                new Dimension(
                        250,
                        40
                )
        );



        button.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );



        return button;
    }









    private void register() {


        try {


            String username =
                    usernameField.getText();



            String password =
                    new String(
                            passwordField.getPassword()
                    );



            String name =
                    nameField.getText();



            int age =
                    Integer.parseInt(
                            ageField.getText()
                    );



            double height =
                    Double.parseDouble(
                            heightField.getText()
                    );



            double weight =
                    Double.parseDouble(
                            weightField.getText()
                    );





            User user =
                    new User(
                            username,
                            password,
                            name,
                            age,
                            height,
                            weight
                    );



            int result =
                    authService.register(
                            user
                    );



            if(result > 0) {


                JOptionPane.showMessageDialog(
                        this,
                        "Account created successfully"
                );



                dispose();


            } else {


                JOptionPane.showMessageDialog(
                        this,
                        "Registration failed",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }



        } catch(Exception exception) {


            JOptionPane.showMessageDialog(
                    this,
                    "Please enter valid information",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}