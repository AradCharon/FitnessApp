from classes.exercise import Exercise

class StrengthExercise(Exercise):
    
    def __init__(self, name, duration, weight, reps):
        super().__init__(name, duration)
        self.weight = weight
        self.reps = reps

    def calc_calories(self):
        return self.weight * self.reps * 0.1

    def show_info(self):
        return "[Strength] " + self.name + " - " + str(self.duration) + "min - " + str(self.weight) + "kg - " + str(self.reps) + "reps"