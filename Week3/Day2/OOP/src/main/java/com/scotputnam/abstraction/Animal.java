package com.scotputnam.abstraction;

public abstract class Animal {
    String species;

    // Concrete method because it has implementation
    public void eat(){
        System.out.println("nom nom " + this.species + " is eating!");
    }

    abstract void makeSound();
}
