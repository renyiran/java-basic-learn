package com.anthony.singleton;

public class Singleton5 {
    private static volatile Singleton5 singleton5;

    private Singleton5() {

    }

    public static Singleton5 getInstance() {
        synchronized (Singleton4.class) {
            if (singleton5 == null) {
                singleton5 = new Singleton5(); // 由于singleton5参数加了volatile修饰 所以会禁止指令重排序
            }
        }
        return singleton5;
    }
}
