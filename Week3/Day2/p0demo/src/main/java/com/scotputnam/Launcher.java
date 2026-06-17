package com.scotputnam;

import com.scotputnam.DAOs.EmployeeDAO;
import com.scotputnam.models.Employee;

import java.util.ArrayList;

public class Launcher {
    public static void main(String[] args) {

        Employee e1 = new Employee("John", "Smith");
        System.out.println(e1.toString());

        EmployeeDAO eDAO = new EmployeeDAO();

        eDAO.insertEmployee(e1);

        ArrayList<Employee> employees = new ArrayList<>();

    }
}