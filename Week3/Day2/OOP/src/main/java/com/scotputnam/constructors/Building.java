package com.scotputnam.constructors;

public class Building {

    int area;
    int walls;

    // Constructor - a special method designated for initializing objects

    // With no explicit constructor, a default constructor is called

    // Else to explicitly define a default constructor; syntax below


    public Building() {
        int area;
        int walls;
    }

    // overloading is changing the number or type of parameters
    public Building(int area) {
        area = this.area;
        System.out.println("Making a new building with this area: " + area);
        System.out.println(this);
    }

    public Building(int value, boolean forWalls) {
        if (forWalls) {
            walls = value;
        } else {
            area = value;
        }
    }

    @Override
    public String toString(){
        return "Area: " + this.area + " || " + "Walls: " + this.walls;
    }

}
