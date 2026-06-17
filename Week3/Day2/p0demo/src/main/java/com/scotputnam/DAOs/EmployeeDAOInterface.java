package com.scotputnam.DAOs;

import com.scotputnam.models.Employee;

import java.util.ArrayList;

public interface EmployeeDAOInterface {

    // a method to get all employees
    ArrayList<Employee> getEmployees();

    // A method to insert a new employee
    Employee insertEmployee(Employee emp);
    // return what was inserted for user confirmation

    

}
