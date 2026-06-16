package com.scotputnam.encapsulation2;

import com.scotputnam.encapsulation.Employee;

public class SalariedEmployee {
    public static void main(String[] args) {
        Employee Alice = new Employee();
        Alice.setPassword("unsafe");
        String password = Alice.getPassword();
    }
}
