package com.revature.models;

public class Employee {

    public Employee(int employee_id, String first_name, String last_name) {
        this.employee_id = employee_id;
        this.first_name = first_name;
        this.last_name = last_name;
    }
    
    private int employee_id;
    private String first_name;
    private String last_name;
    
}
