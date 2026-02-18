from abc import ABC, abstractmethod
from datetime import datetime

class Exercise(ABC):
    
    def __init__(self, name, duration):
        self.name = name           
        self.duration = duration   
        self.date = datetime.now()  
    
    @abstractmethod
    def calc_calories(self):
        pass
    
    def show_info(self):
        return self.name + " - " + str(self.duration) + " minutes"