package com.anthony.singleton;

/**
 * 线程安全
 */
public class Singleton3 {
    private static Singleton3 singleton3;

    private Singleton3() {

    }

    public synchronized static Singleton3 getInstance() {
        if (singleton3 == null) {
            singleton3 = new Singleton3();
        }
        return singleton3;
    }
}
