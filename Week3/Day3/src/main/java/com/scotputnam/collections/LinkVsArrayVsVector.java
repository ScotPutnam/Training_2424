package com.scotputnam.collections;

import java.util.List;
import java.util.Scanner;

public class LinkVsArrayVsVector {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose list type: (1) ArrayList (2) LinkedList (3) Vector (0) exit");
        int number = Integer.parseInt(sc.nextLine());

        while(number != 0){
            System.out.println("Adding to end: \n");

            // Adding to end
            List<Object> things = ListFactory.getList(number);
            long start = System.nanoTime();
            for (int i = 0; i < 100000; i++){
                things.addLast(new Object());
            }
            long end = System.nanoTime();
            System.out.println("Added to end: " + (end-start)/1_000_000 + "ms");

            System.out.println("\nChoose list type: (1) ArrayList (2) LinkedList (3) Vector (0) exit");
            number = Integer.parseInt(sc.nextLine());

            start = System.nanoTime();
            for (Object o: things){

            }
            end = System.nanoTime();
            System.out.println("Time to iterate: " + (end-start)/1_000_000 + "ms");
        }
        number = 1;
        while(number != 0){
            System.out.println("Adding to front: \n");
            // Adding to end
            List<Object> things = ListFactory.getList(number);
            long start = System.nanoTime();
            for (int i = 0; i < 100000; i++){
                things.addFirst(new Object());
            }
            long end = System.nanoTime();
            System.out.println("Added to front: " + (end-start)/1_000_000 + "ms");

            System.out.println("\nChoose list type: (1) ArrayList (2) LinkedList (3) Vector (0) exit");
            number = Integer.parseInt(sc.nextLine());

            start = System.nanoTime();
            for (Object o: things){
                int i = 0;
                things.get(i);
                i++;
            }
            end = System.nanoTime();
            System.out.println("Time to iterate (index access): " + (end-start)/1_000_000 + "ms");

            start = System.nanoTime();
            for (Object o: things){

            }
            end = System.nanoTime();
            System.out.println("Time to iterate (for each) : " + (end-start)/1_000_000 + "ms");

            

        }

        sc.close();
    }
}
