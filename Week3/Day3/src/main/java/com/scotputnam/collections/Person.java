package com.scotputnam.collections;

public class Person {

    String name;
    int height;
    int age;

    public Person(String name, int height, int age) {
        this.name = name;
        this.height = height;
        this.age = age;
    }

    public Person(){
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", age=" + age +
                '}';
    }
}
