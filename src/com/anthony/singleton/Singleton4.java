package com.anthony.singleton;

/**
 * 双检索版
 */
public class Singleton4 {
    private static Singleton4 singleton4;

    private Singleton4() {

    }

    public static Singleton4 getInstance() {
        if (singleton4 == null) {
            synchronized (Singleton4.class) {
                if (singleton4 == null) {
                    singleton4 = new Singleton4();  //由于指令重排序 所以这里可能会导致已经指向了对象(singleton4不为null) 但是还未完成初始化
                }
            }
        }
        return singleton4;
    }

}
