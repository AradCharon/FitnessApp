package classes;

public class StrengthExercise extends Exercise {

    private double weight;
    private int reps;

    public StrengthExercise(String name, int duration, double weight, int reps) {
        super(name, duration);
        this.weight = weight;
        this.reps = reps;
    }

    @Override
    public double calcCalories() {
        return weight * reps * 0.1;
    }

    @Override
    public String showInfo() {
        return "[Strength] " + name + " - " + duration + "min - " + weight + "kg - " + reps + "reps";
    }
}
