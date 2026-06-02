# classes and object in python

# Needs to be added for abstract classes & methods
from abc import ABC, abstractmethod

# Class syntax: class keyword, (pascal_case)ClassName as well as dunder method(instance vars here), then methods
class MyNewClass:

    # python only has one constructor, can set default param values, first arg is always 'self'
    # class variables are defined in __init__ method
    def __init__(self, age = 0, name = "default name"): # dunder method uses __method__(): format
        self.name = name
        self.age = age
    
    def my_new_function(this): # first param is a reference to self in class methods
        return "this is my class function"

    def __str__(self):
        return f"my name is {self.name}"

    # the __repr__ method will create a clone of the class
    def __repr__(self):
        return f"MyNewClass(self, {self.age}, {self.name})"

my_class = MyNewClass(name="Scot")
print(my_class)
print(my_class.__repr__())

# abstract classes in python. Make a class abstract by addding ABC inside parantheses

class MyAbstractClass(ABC):
    # class variable, accessed by calling class itself, not instantiated
    class_count = 0

    # class methods, takes class as arg, can interact with and change state of class
    @classmethod
    def print_class_count(cls):
        return cls.class_count
    
    # abs methods have no body, must be defined by implementing class
    @abstractmethod
    def to_be_determined(self):
        pass # passes block

    # static methods are similar to class methods, called by class itself
    @staticmethod
    def static_method():
        return "This is my static method, does not interact with the state of the class"

# MyAbstractClass.class_count=MyAbstractClass.class_count+1
# print(MyAbstractClass.class_count)

class MyInheritsAbstractClass(MyAbstractClass):

    def __init__(self):
        print("I inherited from the abstract class")
        MyAbstractClass.class_count = MyAbstractClass.class_count+1

    def to_be_determined(self):
        return "I have defined this methods behavior"

class AlsoInheritsAbstractClass(MyAbstractClass):

    def __init__(self):
        print("I also inherited from the abstract class")
        MyAbstractClass.class_count = MyAbstractClass.class_count+1

    def to_be_determined(self):
        return "Also defining this abstract methods behavior"



# MyAbstractClass.class_count = MyAbstractClass.class_count+1
# print(MyAbstractClass.class_count)

my_new_class = MyInheritsAbstractClass()
print(my_new_class.to_be_determined())

class InheritedConstructor():
    def __init__(self,name):
        self.name=name
        print("The parent constructor was called")

class Inheritsconstructor(InheritedConstructor):
    def __init__(self,age=24,name="Scot"):
        super().__init__(name)
        self.age = age
        print("The child class constructor was called")

ci = Inheritsconstructor()
ci = Inheritsconstructor(24, "Scot")
print(ci.name)
print(ci.age)

print(type(str))
