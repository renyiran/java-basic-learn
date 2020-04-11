package com.anthony.singleton;

/**
 * 静态内部类
 */
public class Singleton6 {
    private static class Singleton6Holder{
        private static final Singleton6 singleton6= new Singleton6();
    }
    private Singleton6(){

    }
    public static Singleton6 getInstance(){
        //静态内部类只有在第一次调用的时候会初始化 且只会初始化一次
        return Singleton6Holder.singleton6;
    }
}
