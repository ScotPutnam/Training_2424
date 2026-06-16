package com.scotputnam.encapsulation2;

import com.scotputnam.encapsulation.Employee;

public class DemoEmployee extends Employee{
    public DemoEmployee(String username, String password, String email, int age) {
        super(username, password, email, age);
    }

    public DemoEmployee() {

    }

    public void updatePassword (String newPassword){
        setPassword(newPassword);
    }
}
