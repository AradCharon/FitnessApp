class User:

    def __init__(self, name):
        self.name = name
        self.exercises = []

    def add_exercise(self, exercise):
        self.exercises.append(exercise)
        print("✅ Exercise '" + exercise.name + "' added successfully")

    def show_exercises(self):
        if not self.exercises:
            print("❌ No exercises found")
            return
        
        print("\n📋 " + self.name + "'s Exercises:")
        total_cal = 0
        
        for i, ex in enumerate(self.exercises, 1):
            cal = ex.calc_calories()
            total_cal = total_cal + cal
            print(str(i) + ". " + ex.show_info() + " - Calories: " + str(int(cal)))
        
        print("🔥 Total Calories: " + str(int(total_cal)))

    def total_duration(self):
        total = 0
        for ex in self.exercises:
            total = total + ex.duration
        return total