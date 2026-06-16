package Week2.Day3.com.example.demo;

// Fully qualified import
import java.util.Scanner;


public class Demo {

    public Demo(){
        System.out.println("Hello, i'm a constructor");        
    }
    
    public static void main(String ... args){
        // Scanner sc = new Scanner(System.in);
        
        // constructs instance of class
        Demo demo = new Demo();
        
        int sum = sum(1,3,5,6,7);
        System.out.println(demo.sayHello("Hello") + sum);

        // sc.close();
    }

    // public static int sum(int num1, int num2){
    //     return (num1 + num2);
    // }
    // public static int sum(int num1, int num2, int num3){
    //     return (num1 + num2 + num3);
    // }

    // var args
    public static int sum(int ...num){
        
        int total = 0;
        for(int n:num){
            total += n;
        }

        return total;
    }

    public String sayHello(String name){
        return "Hello " + name;
    }


}
