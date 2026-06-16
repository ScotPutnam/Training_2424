package com.scotputnam;

import com.scotputnam.constructors.Building;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Building constructionZone = new Building(5);
        System.out.println(constructionZone.toString());

    }
}