package com.anthony.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalLearn {
    private ThreadLocal<String> strLocal = new ThreadLocal<>();

    private void set() {
        strLocal.set(Thread.currentThread().getName());
    }

    private String getString() {
        return strLocal.get();
    }

    public static void main(String[] args) {
        final ThreadLocalLearn test = new ThreadLocalLearn();
        test.set();
        System.out.println(test.getString());
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            threadPool.execute(()-> {
                    test.set();
                    System.out.println(test.getString());
            });
        }
        threadPool.shutdown();
    }
}
