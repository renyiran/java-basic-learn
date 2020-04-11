package com.anthony.thread;

public class SynchronizedLearn2 {

    public static void main(String[] args) {

        //线程AA和BB都持有的是类锁 所以会同步  而线程CC持有的对象锁 所以不会和它们同步

        SynchronizedLearn2 synchronizedLearn2 = new SynchronizedLearn2();
        RunnableAA runnableAA = new RunnableAA();
        RunnableBB runnableBB = new RunnableBB();
        RunnableCC runnableCC = new RunnableCC(synchronizedLearn2);
        Thread threadAA = new Thread(runnableAA);
        threadAA.start();
        Thread threadBB = new Thread(runnableBB);
        threadBB.start();
        Thread threadCC = new Thread(runnableCC);
        threadCC.start();
    }


    public synchronized static void staticMethod1() throws InterruptedException {
        System.out.println("staticMethod1 start");
        Thread.sleep(1000);
        System.out.println("staticMethod1 end");
    }

    public static void staticMethod2() throws InterruptedException {
        synchronized (SynchronizedLearn2.class) {
            System.out.println("staticMethod2 start");
            Thread.sleep(1000);
            System.out.println("staticMethod2 end");
        }
    }

    public void method3() throws InterruptedException {
        synchronized (this) {
            System.out.println("method3 start");
            Thread.sleep(1000);
            System.out.println("method3 end");
        }
    }
}

class RunnableAA implements Runnable {

    @Override
    public void run() {
        try {
            SynchronizedLearn2.staticMethod1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class RunnableBB implements Runnable {

    @Override
    public void run() {
        try {
            SynchronizedLearn2.staticMethod2();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class RunnableCC implements Runnable {

    private SynchronizedLearn2 synchronizedLearn2;

    public RunnableCC(SynchronizedLearn2 synchronizedLearn2) {
        this.synchronizedLearn2 = synchronizedLearn2;
    }

    @Override
    public void run() {
        try {
            synchronizedLearn2.method3();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
