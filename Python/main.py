from classes.user import User
from classes.strength_exercise import StrengthExercise
from classes.cardio_exercise import CardioExercise

def main():
    print("="*40)
    print("         MY FITNESS APP")
    print("="*40)
    
    name = input("What's your name? ")
    user = User(name)
    
    while True:
        print("\n--- MENU ---")
        print("1. Add new exercise")
        print("2. Show all exercises")
        print("3. Statistics")
        print("4. Exit")
        
        choice = input("Choose: ")
        
        if choice == "1":
            print("\nExercise type:")
            print("1. Strength")
            print("2. Cardio")
            
            t = input("Choose: ")
            
            if t == "1":
                name = input("Exercise name (e.g., Squat): ")
                duration = int(input("Duration (minutes): "))
                weight = float(input("Weight (kg): "))
                reps = int(input("Number of reps: "))
                
                ex = StrengthExercise(name, duration, weight, reps)
                user.add_exercise(ex)
                
            elif t == "2":
                name = input("Exercise name (e.g., Running): ")
                duration = int(input("Duration (minutes): "))
                distance = float(input("Distance (km): "))
                
                ex = CardioExercise(name, duration, distance)
                user.add_exercise(ex)
            
            else:
                print("❌ Invalid exercise type")
        
        elif choice == "2":
            user.show_exercises()
        
        elif choice == "3":
            print("\n📊 " + user.name + "'s Statistics")
            print("Total exercises: " + str(len(user.exercises)))
            print("Total time: " + str(user.total_duration()) + " minutes")
        
        elif choice == "4":
            print("👋 Goodbye! Keep training!")
            break
        
        else:
            print("❌ Invalid choice. Please try again.")

main()