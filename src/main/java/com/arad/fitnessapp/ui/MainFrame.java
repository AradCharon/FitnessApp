package com.arad.fitnessapp.ui;


import com.arad.fitnessapp.model.User;
import com.arad.fitnessapp.ui.components.Footer;
import com.arad.fitnessapp.ui.components.SidebarButton;

import javax.swing.*;
import java.awt.*;



/**
 * Main application window.
 *
 * Responsible for application layout
 * and navigation between different panels.
 */
public class MainFrame extends JFrame {


    private final CardLayout cardLayout;

    private final JPanel contentPanel;


    private final SidebarButton dashboardButton;

    private final SidebarButton exerciseButton;

    private final SidebarButton profileButton;



    private final DashboardPanel dashboardPanel;

    private final ExercisePanel exercisePanel;

    private final ProfilePanel profilePanel;



    private final User currentUser;





    public MainFrame(
            User user
    ) {


        currentUser =
                user;



        setTitle(
                "FitnessApp"
        );



        setSize(
                1200,
                750
        );



        setMinimumSize(
                new Dimension(
                        1000,
                        650
                )
        );



        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );



        setLocationRelativeTo(null);



        setLayout(
                new BorderLayout()
        );





        cardLayout =
                new CardLayout();




        contentPanel =
                new JPanel(
                        cardLayout
                );



        contentPanel.setBackground(
                new Color(
                        245,
                        247,
                        250
                )
        );





        dashboardButton =
                new SidebarButton(
                        "Dashboard"
                );



        exerciseButton =
                new SidebarButton(
                        "Exercises"
                );



        profileButton =
                new SidebarButton(
                        "Profile"
                );






        dashboardPanel =
                new DashboardPanel(
                        user
                );



        exercisePanel =
                new ExercisePanel(
                        user
                );



        profilePanel =
                new ProfilePanel(
                        user
                );





        contentPanel.add(
                dashboardPanel,
                "DASHBOARD"
        );



        contentPanel.add(
                exercisePanel,
                "EXERCISES"
        );



        contentPanel.add(
                profilePanel,
                "PROFILE"
        );





        configureNavigation();





        add(
                createSidebar(),
                BorderLayout.WEST
        );



        add(
                createHeader(),
                BorderLayout.NORTH
        );



        add(
                contentPanel,
                BorderLayout.CENTER
        );



        add(
                new Footer(),
                BorderLayout.SOUTH
        );





        showDashboard();



        setVisible(true);
    }







    private void configureNavigation() {


        dashboardButton.addActionListener(
                e -> showDashboard()
        );



        exerciseButton.addActionListener(
                e -> showExercises()
        );



        profileButton.addActionListener(
                e -> showProfile()
        );
    }








    private JPanel createSidebar() {


        JPanel sidebar =
                new JPanel();



        sidebar.setPreferredSize(
                new Dimension(
                        220,
                        0
                )
        );



        sidebar.setBackground(
                new Color(
                        34,
                        40,
                        49
                )
        );



        sidebar.setLayout(
                new BoxLayout(
                        sidebar,
                        BoxLayout.Y_AXIS
                )
        );





        JLabel logo =
                new JLabel(
                        "FitnessApp"
                );



        logo.setForeground(
                Color.WHITE
        );



        logo.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        24
                )
        );



        logo.setBorder(
                BorderFactory.createEmptyBorder(
                        30,
                        20,
                        40,
                        10
                )
        );



        sidebar.add(
                logo
        );



        sidebar.add(
                dashboardButton
        );



        sidebar.add(
                Box.createVerticalStrut(
                        10
                )
        );



        sidebar.add(
                exerciseButton
        );



        sidebar.add(
                Box.createVerticalStrut(
                        10
                )
        );



        sidebar.add(
                profileButton
        );



        return sidebar;
    }









    private JPanel createHeader() {


        JPanel header =
                new JPanel(
                        new BorderLayout()
                );



        header.setPreferredSize(
                new Dimension(
                        0,
                        70
                )
        );



        header.setBackground(
                Color.WHITE
        );





        JLabel title =
                new JLabel(
                        "Fitness Dashboard"
                );



        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        22
                )
        );



        title.setBorder(
                BorderFactory.createEmptyBorder(
                        0,
                        30,
                        0,
                        0
                )
        );





        JPanel rightPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT,
                                20,
                                20
                        )
                );



        rightPanel.setBackground(
                Color.WHITE
        );





        JLabel userLabel =
                new JLabel(
                        "Welcome, "
                                +
                                currentUser.getName()
                );



        userLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        16
                )
        );





        JButton logoutButton =
                new JButton(
                        "Logout"
                );



        logoutButton.addActionListener(
                e -> logout()
        );





        rightPanel.add(
                userLabel
        );



        rightPanel.add(
                logoutButton
        );





        header.add(
                title,
                BorderLayout.WEST
        );



        header.add(
                rightPanel,
                BorderLayout.EAST
        );



        return header;
    }








    private void logout() {


        dispose();



        new LoginFrame();
    }









    private void showDashboard() {


        cardLayout.show(
                contentPanel,
                "DASHBOARD"
        );



        dashboardPanel.refreshData();



        setActiveButton(
                dashboardButton
        );
    }








    private void showExercises() {


        cardLayout.show(
                contentPanel,
                "EXERCISES"
        );



        setActiveButton(
                exerciseButton
        );
    }








    private void showProfile() {


        cardLayout.show(
                contentPanel,
                "PROFILE"
        );



        setActiveButton(
                profileButton
        );
    }









    private void setActiveButton(
            SidebarButton activeButton
    ) {


        dashboardButton.setActive(
                activeButton == dashboardButton
        );



        exerciseButton.setActive(
                activeButton == exerciseButton
        );



        profileButton.setActive(
                activeButton == profileButton
        );
    }
}