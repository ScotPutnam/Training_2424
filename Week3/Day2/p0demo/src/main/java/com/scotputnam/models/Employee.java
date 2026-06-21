package com.scotputnam.models;

public class Employee {

    private int employee_id;
    private String first_name;
    private String last_name;

    /* Employee will have a role object */
    // private int role_id
    private Role role;

    // makes inserts easier
    private int role_id_fk;


    public Employee() {
    }

    public Employee(String first_name, String last_name, Role role) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.role = role;
    }

    public Employee(String last_name, String first_name) {
        this.last_name = last_name;
        this.first_name = first_name;
    }

    public Employee(Role role, String last_name, String first_name, int employee_id) {

        this.role = role;
        this.last_name = last_name;
        this.first_name = first_name;
        this.employee_id = employee_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getRole_id_fk() {
        return role_id_fk;
    }

    public void setRole_id_fk(int role_id_fk) {
        this.role_id_fk = role_id_fk;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "last_name='" + last_name + '\'' +
                ", first_name='" + first_name + '\'' +
                ", employee_id=" + employee_id +
                ", role=" + role +
                '}';
    }
}
