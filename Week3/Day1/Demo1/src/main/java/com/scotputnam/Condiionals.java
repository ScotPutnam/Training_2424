package com.scotputnam;

import com.sun.source.tree.SwitchTree;

import java.util.Arrays;
import java.util.Scanner;

public class Condiionals {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        String input = scanner.nextLine();

//        boolean isEven = (num % 2 == 0);
//        while (num < 1000) {
//            System.out.println(num);
//        }

        int num = Integer.parseInt(input);
        while (num < 1000) {
            System.out.println("Enter a number above 1000: ");
            num = Integer.parseInt(scanner.nextLine());
        }
        System.out.println(num);
        scanner.close();

        do {
            System.out.println("Enter a number: ");
            num = Integer.parseInt(scanner.nextLine());
        } while (num < 1000); {
            System.out.println("Enter a number above 1000: ");
            num = Integer.parseInt(scanner.nextLine());
        };

        int[][] arr = Arrays.stream(new int[][]{{1,2,3},{4,5,6}}).toArray(int[][]::new);
        // enhanced for loop
        for (int[] i : arr){
            System.out.println("Array: " + Arrays.toString(i));
            for (int j : i) {
                System.out.println(j);
            }
        }
    }
}
