package com.scotputnam;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        // prints alphabet

//        for (int c = 'a'; c <= (int) 'z'; c++){
//            System.out.println((char) c);
//
//        }
        String s  = "Fa";
        
        String digits = "12345";

        List<Integer> digit_list = new ArrayList<>();

        for (char c : digits.toCharArray()){
            System.out.println((int) c);
        }

    }
}
