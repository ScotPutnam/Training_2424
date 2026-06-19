package com.scotputnam.Logging.QueueAndDeques;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityDeque {
    static void main() {
        Queue<Task> tasks = new PriorityQueue<>();

        tasks.add(new Task("Fix prod. bug", 1));
        tasks.add(new Task("Write docs", 5));
        tasks.add(new Task("Update website", 3));

        while (!tasks.isEmpty()){
            System.out.println(tasks.poll());
        }

    }
}
