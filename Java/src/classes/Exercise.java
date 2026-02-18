package classes;

import java.time.LocalDateTime;

public abstract class Exercise {

    protected String name;
    protected int duration;
    protected LocalDateTime date;

    public Exercise(String name, int duration) {
        this.name = name;
        this.duration = duration;
        this.date = LocalDateTime.now();
    }

    public abstract double calcCalories();

    public String showInfo() {
        return name + " - " + duration + " minutes";
    }

    public int getDuration() {
        return duration;
    }

    public String getName() {
        return name;
    }
}
