package com.arad.fitnessapp.ui;

import com.arad.fitnessapp.dao.ExerciseDAO;
import com.arad.fitnessapp.model.CardioExercise;
import com.arad.fitnessapp.model.Exercise;
import com.arad.fitnessapp.model.StrengthExercise;
import com.arad.fitnessapp.model.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;


/**
 * Exercise management panel.
 */
public class ExercisePanel extends JPanel {


    private final User user;


    private final ExerciseDAO exerciseDAO;


    private final DefaultListModel<Exercise> listModel;


    private final JList<Exercise> exerciseList;





    public ExercisePanel(User user) {


        this.user = user;


        exerciseDAO =
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
                        25,
                        25,
                        25,
                        25
                )
        );



        listModel =
                new DefaultListModel<>();


        exerciseList =
                new JList<>(
                        listModel
                );



        exerciseList.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        15
                )
        );



        add(
                createTopPanel(),
                BorderLayout.NORTH
        );


        add(
                new JScrollPane(
                        exerciseList
                ),
                BorderLayout.CENTER
        );


        add(
                createBottomPanel(),
                BorderLayout.SOUTH
        );



        loadExercises();
    }






    private JPanel createTopPanel() {


        JPanel panel =
                new JPanel(
                        new BorderLayout()
                );


        panel.setBackground(
                getBackground()
        );



        JLabel title =
                new JLabel(
                        "My Exercises"
                );


        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        28
                )
        );



        JButton addButton =
                new JButton(
                        "Add Exercise"
                );



        addButton.addActionListener(
                e -> addExercise()
        );



        panel.add(
                title,
                BorderLayout.WEST
        );


        panel.add(
                addButton,
                BorderLayout.EAST
        );



        return panel;
    }







    private JPanel createBottomPanel() {


        JPanel panel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT
                        )
                );


        panel.setBackground(
                getBackground()
        );



        JButton deleteButton =
                new JButton(
                        "Delete Selected"
                );



        deleteButton.addActionListener(
                e -> deleteExercise()
        );



        panel.add(
                deleteButton
        );


        return panel;
    }







    private void loadExercises() {


        listModel.clear();



        List<Exercise> exercises =
                exerciseDAO.findByUserId(
                        user.getId()
                );



        for (
                Exercise exercise :
                exercises
        ) {


            listModel.addElement(
                    exercise
            );
        }
    }








    private void addExercise() {


        String[] options =
                {
                        "Strength",
                        "Cardio"
                };



        String type =
                (String) JOptionPane.showInputDialog(
                        this,
                        "Exercise type",
                        "Add Exercise",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        options,
                        options[0]
                );



        if(type == null) {

            return;
        }



        try {


            String name =
                    JOptionPane.showInputDialog(
                            "Exercise name"
                    );



            int duration =
                    Integer.parseInt(
                            JOptionPane.showInputDialog(
                                    "Duration (minutes)"
                            )
                    );



            Exercise exercise;



            if(
                    type.equals("Strength")
            ) {


                double weight =
                        Double.parseDouble(
                                JOptionPane.showInputDialog(
                                        "Weight"
                                )
                        );


                int reps =
                        Integer.parseInt(
                                JOptionPane.showInputDialog(
                                        "Reps"
                                )
                        );



                exercise =
                        new StrengthExercise(
                                name,
                                duration,
                                weight,
                                reps
                        );


            } else {



                double distance =
                        Double.parseDouble(
                                JOptionPane.showInputDialog(
                                        "Distance (km)"
                                )
                        );



                exercise =
                        new CardioExercise(
                                name,
                                duration,
                                distance
                        );
            }



            exerciseDAO.save(
                    exercise,
                    user.getId()
            );


            loadExercises();



        } catch(Exception exception) {


            JOptionPane.showMessageDialog(
                    this,
                    "Invalid input"
            );
        }
    }








    private void deleteExercise() {


        Exercise selected =
                exerciseList.getSelectedValue();



        if(selected == null) {

            return;
        }



        exerciseDAO.delete(
                selected.getId()
        );


        loadExercises();
    }
}