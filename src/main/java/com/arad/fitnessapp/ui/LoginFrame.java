package com.arad.fitnessapp.ui;


import com.arad.fitnessapp.model.User;
import com.arad.fitnessapp.service.AuthService;
import com.arad.fitnessapp.ui.components.Footer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;



/**
 * Login window.
 *
 * Handles user authentication.
 */
public class LoginFrame extends JFrame {


    private final JTextField usernameField;

    private final JPasswordField passwordField;

    private final AuthService authService;




    public LoginFrame() {


        authService =
                new AuthService();



        setTitle(
                "FitnessApp - Login"
        );


        setSize(
                500,
                650
        );


        setLocationRelativeTo(null);


        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
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
                        40,
                        50,
                        40,
                        50
                )
        );



        card.setPreferredSize(
                new Dimension(
                        380,
                        500
                )
        );




        JLabel title =
                new JLabel(
                        "FitnessApp"
                );


        title.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        32
                )
        );




        JLabel subtitle =
                new JLabel(
                        "Welcome back"
                );


        subtitle.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        subtitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        16
                )
        );


        subtitle.setForeground(
                Color.GRAY
        );




        usernameField =
                createTextField();



        passwordField =
                createPasswordField();




        JLabel usernameLabel =
                createLabel(
                        "Username"
                );



        JLabel passwordLabel =
                createLabel(
                        "Password"
                );





        JButton loginButton =
                createButton(
                        "Login"
                );



        JButton registerButton =
                createButton(
                        "Create Account"
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
                        35
                )
        );



        card.add(
                usernameLabel
        );


        card.add(
                Box.createVerticalStrut(
                        5
                )
        );


        card.add(
                usernameField
        );


        card.add(
                Box.createVerticalStrut(
                        20
                )
        );



        card.add(
                passwordLabel
        );


        card.add(
                Box.createVerticalStrut(
                        5
                )
        );


        card.add(
                passwordField
        );


        card.add(
                Box.createVerticalStrut(
                        35
                )
        );



        card.add(
                loginButton
        );


        card.add(
                Box.createVerticalStrut(
                        15
                )
        );


        card.add(
                registerButton
        );




        add(
                card,
                BorderLayout.CENTER
        );



        add(
                new Footer(),
                BorderLayout.SOUTH
        );





        loginButton.addActionListener(
                e -> login()
        );



        registerButton.addActionListener(
                e -> openRegister()
        );



        setVisible(true);
    }







    private JTextField createTextField() {


        JTextField field =
                new JTextField();



        field.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        40
                )
        );



        field.setHorizontalAlignment(
                JTextField.CENTER
        );



        field.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        15
                )
        );


        return field;
    }







    private JPasswordField createPasswordField() {


        JPasswordField field =
                new JPasswordField();



        field.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        40
                )
        );



        field.setHorizontalAlignment(
                JTextField.CENTER
        );



        field.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        15
                )
        );


        return field;
    }







    private JLabel createLabel(
            String text
    ) {


        JLabel label =
                new JLabel(
                        text
                );



        label.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );



        label.setHorizontalAlignment(
                SwingConstants.CENTER
        );



        label.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );


        return label;
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








    private void login() {


        String username =
                usernameField.getText();



        String password =
                new String(
                        passwordField.getPassword()
                );



        User user =
                authService.login(
                        username,
                        password
                );



        if(user != null) {


            dispose();


            new MainFrame(
                    user
            );


        } else {


            JOptionPane.showMessageDialog(
                    this,
                    "Invalid username or password",
                    "Login Failed",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }








    private void openRegister() {


        new RegisterFrame();

    }
}