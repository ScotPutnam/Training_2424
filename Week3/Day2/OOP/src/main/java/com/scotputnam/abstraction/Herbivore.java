package com.scotputnam.abstraction;

public interface Herbivore {
    // by default all methods have to be abstract/public in an interface
    // therefore methods don't need public/abstract keywords

    int number = 12;
    // as of Java 8  we can have concrete methods within interfaces with 'default' keyword
    default void eatPlant(){
        System.out.println("Eats plant. Nummy");
    }

}
