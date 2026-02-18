package classes;

import java.util.ArrayList;

public class User {

    private String name;
    private ArrayList<Exercise> exercises;

    public User(String name) {
        this.name = name;
        exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
        System.out.println("Exercise '" + exercise.getName() + "' added successfully");
    }

    public void showExercises() {
        if (exercises.isEmpty()) {
            System.out.println("No exercises found");
            return;
        }

        System.out.println("\n" + name + "'s Exercises:");
        double totalCal = 0;

        for (int i = 0; i < exercises.size(); i++) {
            Exercise ex = exercises.get(i);
            double cal = ex.calcCalories();
            totalCal += cal;
            System.out.println((i + 1) + ". " + ex.showInfo() + " - Calories: " + (int) cal);
        }

        System.out.println("Total Calories: " + (int) totalCal);
    }

    public int totalDuration() {
        int total = 0;
        for (Exercise ex : exercises) {
            total += ex.getDuration();
        }
        return total;
    }

    public String getName() {
        return name;
    }

    public int getExerciseCount() {
        return exercises.size();
    }
}
