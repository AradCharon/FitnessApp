from classes.exercise import Exercise

class CardioExercise(Exercise):

    def __init__(self, name, duration, distance):
        super().__init__(name, duration)
        self.distance = distance
    
    def calc_calories(self):
        return self.distance * 50

    def show_info(self):
        return "[Cardio] " + self.name + " - " + str(self.duration) + "min - " + str(self.distance) + "km"