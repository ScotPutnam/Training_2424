from abc import ABC, abstractmethod
class Employee(ABC):
    """ Demonstrates encapsulation in Python:
        _ single underscore marks var as protected
        __ double underscore marks var as private
    """
    __id__counter = 1000
    def __init__(self, name, salary):
        self.name = name
        self._salary = salary     
        Employee.__id__counter += 1
        self.__employee_id = Employee.__id__counter

    def get_employee_id(self):
        return self.__employee_id

    @abstractmethod
    def calculate_pay(self):
        pass

    def display_info(self):
        print(f"Name: {self.name}\nSalary: {self._salary}\nID: {self.__employee_id}")



class SalariedEmployee(Employee):
    def calculate_pay(self):
        return self._salary

class HourlyEmployee(Employee):
    def __init__(self, name, hourly_rate, hours_worked):
        self.hours_worked = hours_worked
        super().__init__(name, hourly_rate)
        

    def calculate_pay(self):
        return hours_worked * hourly_rate

    def display_info(self):
        print(f"Name: {self.name}\nSalary: {self.calculate_pay}\nID: {self.__employee_id}")
        pass

    def get_employee_id(self):
        return __employee_id

emp = SalariedEmployee("Scot", "65000")
emp2 = HourlyEmployee("Scot", 8, 40)


print(emp.display_info())
# print(emp2.display_info())
