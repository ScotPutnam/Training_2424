package com.scotputnam;

import com.scotputnam.DAOs.AuthDAO;
import com.scotputnam.DAOs.EmployeeDAO;
import com.scotputnam.controllers.EmployeeController;
import com.scotputnam.models.Employee;
import io.javalin.Javalin;

import java.util.ArrayList;

import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.get;

public class Launcher {
    public static void main(String[] args) {

        Employee e1 = new Employee("John", "Smith");
        System.out.println(e1);

        EmployeeDAO eDAO = new EmployeeDAO();

        eDAO.insertEmployee(e1);

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(e1);

        for(Employee e: employees){
            System.out.println(e);
        }

        EmployeeController ec = new EmployeeController();
        var app = Javalin.create(config -> {
            config.router.apiBuilder(() -> {
                path("/employees", () -> {
                    get(ec.getEmployeesHandler);
                    post(ec.insertEmployee);
                });
            });
        }).start(8080);

        AuthDAO ad = new AuthDAO();
        ad.login("John", "Smith");
    }
}