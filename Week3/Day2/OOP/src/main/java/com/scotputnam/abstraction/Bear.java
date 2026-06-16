package com.scotputnam.abstraction;

public class Bear extends Animal implements Herbivore, Carnivore{

    @Override
    public void eatPlant() {
        Herbivore.super.eatPlant();
    }

    @Override
    public void eatMeat() {
        System.out.println("Nummy Salmon");
    }

    @Override
    void makeSound() {
        System.out.println("Graaah");
    }
}
