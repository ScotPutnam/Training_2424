package com.scotputnam.polymorphism;

public class Child extends Parent{

    public void play() {
        System.out.println("Playing on the playground");
    }

    @Override
    public void work() {
        super.work();
    }
}
