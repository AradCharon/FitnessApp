package classes;

public class CardioExercise extends Exercise {

    private double distance;

    public CardioExercise(String name, int duration, double distance) {
        super(name, duration);
        this.distance = distance;
    }

    @Override
    public double calcCalories() {
        return distance * 50;
    }

    @Override
    public String showInfo() {
        return "[Cardio] " + name + " - " + duration + "min - " + distance + "km";
    }
}
