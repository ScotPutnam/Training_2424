package com.scotputnam.exceptions;

import java.util.Scanner;

public class ExceptionHandling {
    public static void main(String[] args) {
        printDivision();
    }


    private static void printDivision() {

        Scanner scan = new Scanner(System.in);

        int x = Integer.parseInt(scan.nextLine());
        int y = Integer.parseInt(scan.nextLine());


        try {
            int result = x/y;
            System.out.println(result);
        } catch (ArithmeticException e){
            System.out.println("Arithmetic Error occured!");
        } catch (NumberFormatException n){
            n.printStackTrace();
        } finally {
            System.out.println("How'd it go?");
        }
    }
}
