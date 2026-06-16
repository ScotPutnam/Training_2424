package com.scotputnam;

import com.scotputnam.models.Employee;

public class Launcher {
    public static void main(String[] args) {
        Employee e1 = new Employee("John", "Smith");
        System.out.println(e1.toString());
    }
}