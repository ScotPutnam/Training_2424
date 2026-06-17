package com.scotputnam.exceptions;

public class Casino {
    public static void main(String[] args) {
        double luck = Math.random();
        System.out.println(luck);

        try {
            gamba(luck);
        }
        catch (LostMoneyException l) {
            System.out.println(l.getMessage());
            l.printStackTrace();
        }
    }
    public static void gamba(double number) throws LostMoneyException{
       if (number > 0.5) {
            System.out.println("Here's a couple of bones, you won!");
       }
       else throw new LostMoneyException("Please gamble responsibly!");

    }
}
