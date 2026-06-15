package com.scotputnam;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        System.out.print("Hello and welcome!\n");

        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }

        for (int[] i : new int[][]{{10, 20, 30, 40, 50}, {10,30,20,10}}){
            for (int j : i) {
                System.out.println(j);
            }
        }

        int[] numRange  = IntStream.range(1,100).toArray();
        IntStream st = Arrays.stream(numRange);
        st.forEach(s -> System.out.print(s + " "));


        System.out.println(FibbSequence.fib(8));
    }
}