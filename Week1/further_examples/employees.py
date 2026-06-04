import abc
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
emp = Employee("Scot", "65000")

print(emp.name)
print(emp._salary)

emp_id = emp.get_employee_id()
print(emp_id)