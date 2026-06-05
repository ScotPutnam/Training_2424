class Car:
    def __init__(self, speed=0):
        self.speed = speed
        self.odometer = 0
        self.time = 0
        print(__name__)
    
    def say_state(self):
        print(f"I'm going {self.speed} mph!")
    
    def accelerate(self):
        self.speed += 5

    def brake(self):
        if self.speed < 5:
            self.speed = 0
        else:
            self.speed -= 5
        
    def step(self):
        self.odometer += self.speed
        self.time += 1

print(dir())
# acts as main
if __name__ == "__main__":
    my_car = Car()
    print("I'm a car")

    while True:
        action = input("What do you want to do: (a)ccelerate (b)rake (o)dometer (q)uit: ")
        if action not in "aboq":
            print("huh?")
        elif action == "a":
            my_car.accelerate()
            my_car.step()
            my_car.say_state()
            print("Vroom")
            
        elif action == "b":
            my_car.brake()
            my_car.step()
            my_car.say_state()
            print("Screeeech")

        elif action == "o":
            my_car.say_state()
        elif action == "q":
            break
