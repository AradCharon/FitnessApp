package com.arad.fitnessapp.ui;


import com.arad.fitnessapp.dao.ExerciseDAO;
import com.arad.fitnessapp.model.Exercise;
import com.arad.fitnessapp.model.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;



/**
 * Dashboard panel.
 *
 * Shows user statistics and recent activities.
 */
public class DashboardPanel extends JPanel {


    private final User user;


    private final ExerciseDAO exerciseDAO;


    private JLabel exerciseCountLabel;

    private JLabel calorieLabel;

    private JPanel recentPanel;





    public DashboardPanel(
            User user
    ) {


        this.user = user;


        this.exerciseDAO =
                new ExerciseDAO();



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
                createHeader(),
                BorderLayout.NORTH
        );


        add(
                createContent(),
                BorderLayout.CENTER
        );


        refreshData();
    }








    private JPanel createHeader() {


        JPanel panel =
                new JPanel(
                        new BorderLayout()
                );


        panel.setBackground(
                getBackground()
        );


        JLabel title =
                new JLabel(
                        "Welcome, "
                                +
                                user.getName()
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








    private JPanel createContent() {


        JPanel main =
                new JPanel(
                        new BorderLayout(
                                20,
                                20
                        )
                );


        main.setBackground(
                getBackground()
        );



        main.add(
                createStatistics(),
                BorderLayout.NORTH
        );



        recentPanel =
                new JPanel();



        recentPanel.setLayout(
                new BoxLayout(
                        recentPanel,
                        BoxLayout.Y_AXIS
                )
        );


        recentPanel.setBackground(
                Color.WHITE
        );


        recentPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        20,
                        20,
                        20,
                        20
                )
        );



        JScrollPane scroll =
                new JScrollPane(
                        recentPanel
                );


        main.add(
                scroll,
                BorderLayout.CENTER
        );



        return main;
    }








    private JPanel createStatistics() {


        JPanel panel =
                new JPanel(
                        new GridLayout(
                                1,
                                2,
                                20,
                                20
                        )
                );


        panel.setBackground(
                getBackground()
        );



        exerciseCountLabel =
                createCard(
                        "Exercises",
                        "0"
                );



        calorieLabel =
                createCard(
                        "Calories",
                        "0"
                );



        panel.add(
                exerciseCountLabel.getParent()
        );


        panel.add(
                calorieLabel.getParent()
        );



        return panel;
    }








    private JLabel createCard(
            String title,
            String value
    ) {


        JPanel card =
                new JPanel(
                        new BorderLayout()
                );


        card.setBackground(
                Color.WHITE
        );


        card.setBorder(
                BorderFactory.createEmptyBorder(
                        20,
                        20,
                        20,
                        20
                )
        );



        JLabel titleLabel =
                new JLabel(
                        title
                );


        titleLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        16
                )
        );



        JLabel valueLabel =
                new JLabel(
                        value
                );


        valueLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        30
                )
        );



        card.add(
                titleLabel,
                BorderLayout.NORTH
        );


        card.add(
                valueLabel,
                BorderLayout.CENTER
        );



        JPanel wrapper =
                new JPanel(
                        new BorderLayout()
                );


        wrapper.setBackground(
                getBackground()
        );


        wrapper.add(
                card
        );



        return valueLabel;
    }








    /**
     * Loads dashboard data from database.
     */
    public void refreshData() {



        List<Exercise> exercises =
                exerciseDAO.findByUserId(
                        user.getId()
                );



        int count =
                exercises.size();



        double calories =
                exercises.stream()
                        .mapToDouble(
                                Exercise::calculateCalories
                        )
                        .sum();




        if(exerciseCountLabel != null) {


            exerciseCountLabel.setText(
                    String.valueOf(count)
            );
        }




        if(calorieLabel != null) {


            calorieLabel.setText(
                    String.format(
                            "%.0f",
                            calories
                    )
            );
        }




        if(recentPanel != null) {


            recentPanel.removeAll();



            JLabel title =
                    new JLabel(
                            "Recent Activities"
                    );


            title.setFont(
                    new Font(
                            "Segoe UI",
                            Font.BOLD,
                            18
                    )
            );


            recentPanel.add(
                    title
            );


            recentPanel.add(
                    Box.createVerticalStrut(
                            15
                    )
            );




            if(exercises.isEmpty()) {


                recentPanel.add(
                        new JLabel(
                                "No exercises yet"
                        )
                );


            } else {



                int start =
                        Math.max(
                                0,
                                exercises.size() - 5
                        );



                for(
                        int i = exercises.size() - 1;
                        i >= start;
                        i--
                ) {



                    recentPanel.add(
                            new JLabel(
                                    exercises.get(i)
                                            .toString()
                            )
                    );



                    recentPanel.add(
                            Box.createVerticalStrut(
                                    8
                            )
                    );
                }
            }



            recentPanel.revalidate();

            recentPanel.repaint();
        }
    }
}