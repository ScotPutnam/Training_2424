package com.scotputnam.Logging.QueueAndDeques;

import java.util.ArrayDeque;
import java.util.Deque;

public class dequeDemo {
    static void main(String[] args) {
        Deque<String> history = new ArrayDeque<>();

        // going to a page
        history.add("google");
        history.addFirst("Youtube");
        history.addLast("Github");
        System.out.println(history);

        // back button
        String currentPage = history.removeLast();
        System.out.println("Went back fron: " + currentPage);
        System.out.println("current history " + history);

        //

        Deque<String> stack = new ArrayDeque<>();

        // push
        stack.push("a");
        stack.push("b");
        stack.push("c");

        // peak
        System.out.println(stack.peek());

        // pop
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());


    }
}
