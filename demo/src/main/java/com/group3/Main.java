package com.group3;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Integer> temp = new ArrayList<>();

        for (int i = 0; i < 100; i++){
            temp.add(i);
        }

        System.out.println(temp.size());

    }
}