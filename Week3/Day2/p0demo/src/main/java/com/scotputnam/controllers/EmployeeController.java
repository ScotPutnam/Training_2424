package com.scotputnam.controllers;

import com.scotputnam.DAOs.EmployeeDAO;
import com.scotputnam.models.Employee;
import io.javalin.http.Handler;
import io.javalin.http.HttpStatus;

import java.util.ArrayList;

public class EmployeeController {
    EmployeeDAO eDAO = new EmployeeDAO();

    public Handler getEmployeesHandler = (ctx -> {

        // ctx is the context object containing methods to process http requests

        // First we need an ArrayList of employees (from DAO)
        ArrayList<Employee> employees = eDAO.getEmployees();

        // use the .json() method to turn our Java into a JSON string
        ctx.json(employees);

        // HttpStatus has static enum fields
        ctx.status(HttpStatus.OK);
    });

    // This handler creates post request for inserting data to DB
    public Handler insertEmployee = (ctx -> {

        // we have json data coming in k:v, can convert to java with ctx.bodyAsClass()
        Employee newEmp = ctx.bodyAsClass(Employee.class);

        Employee returnedEmp = eDAO.insertEmployee(newEmp);
        // if insert was successful the returnedEmp will hold an emp object
        if(returnedEmp != null){
            ctx.status(HttpStatus.CREATED);
            ctx.json(returnedEmp);
        } else {
            ctx.status(HttpStatus.NOT_ACCEPTABLE);
        }
    });
}
