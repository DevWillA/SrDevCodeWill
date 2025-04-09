package com.willdev;

import java.util.concurrent.ConcurrentLinkedDeque;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        var queue = new ConcurrentLinkedDeque<>();

        Runnable prod = () -> {
            for (int i = 0; i < 100; i++) {
                queue.add("Mensaje " + (i + i) + " desde " + Thread.currentThread().getName());

            }
        };

        Runnable cons = () -> {
            while (queue.size() > 0) {
                var msg = queue.poll();
                System.out.println(msg);

            }

            System.out.println("Queue size: " + queue.size());
            System.out.println("Queue is empty");
        };

        var prod1 = new Thread(prod);
        var prod2 = new Thread(prod);
        var cons1 = new Thread(cons);

        prod1.start();
        prod2.start();

        Thread.sleep(1000); // Wait for producers to finish
        cons1.start();

        prod1.join();
        prod2.join();
        
        cons1.join();
    }
}