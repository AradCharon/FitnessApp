import java.util.Scanner;
import classes.User;
import classes.StrengthExercise;
import classes.CardioExercise;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("         MY FITNESS APP");
        System.out.println("=================================");

        System.out.print("What's your name? ");
        String name = scanner.nextLine();
        User user = new User(name);

        while (true) {

            System.out.println("\n--- MENU ---");
            System.out.println("1. Add new exercise");
            System.out.println("2. Show all exercises");
            System.out.println("3. Statistics");
            System.out.println("4. Exit");

            System.out.print("Choose: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {

                System.out.println("\nExercise type:");
                System.out.println("1. Strength");
                System.out.println("2. Cardio");

                System.out.print("Choose: ");
                String t = scanner.nextLine();

                if (t.equals("1")) {

                    System.out.print("Exercise name: ");
                    String exName = scanner.nextLine();

                    System.out.print("Duration (minutes): ");
                    int duration = Integer.parseInt(scanner.nextLine());

                    System.out.print("Weight (kg): ");
                    double weight = Double.parseDouble(scanner.nextLine());

                    System.out.print("Number of reps: ");
                    int reps = Integer.parseInt(scanner.nextLine());

                    StrengthExercise ex = new StrengthExercise(exName, duration, weight, reps);
                    user.addExercise(ex);

                } else if (t.equals("2")) {

                    System.out.print("Exercise name: ");
                    String exName = scanner.nextLine();

                    System.out.print("Duration (minutes): ");
                    int duration = Integer.parseInt(scanner.nextLine());

                    System.out.print("Distance (km): ");
                    double distance = Double.parseDouble(scanner.nextLine());

                    CardioExercise ex = new CardioExercise(exName, duration, distance);
                    user.addExercise(ex);

                } else {
                    System.out.println("Invalid exercise type");
                }

            } else if (choice.equals("2")) {

                user.showExercises();

            } else if (choice.equals("3")) {

                System.out.println("\n" + user.getName() + "'s Statistics");
                System.out.println("Total exercises: " + user.getExerciseCount());
                System.out.println("Total time: " + user.totalDuration() + " minutes");

            } else if (choice.equals("4")) {

                System.out.println("Goodbye! Keep training!");
                break;

            } else {
                System.out.println("Invalid choice");
            }
        }

        scanner.close();
    }
}
