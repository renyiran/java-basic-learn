package com.anthony.thread;

public class SynchronizedLearn1 {
    public static void main(String[] args) {
        HasSelfPrivateNum hasSelfPrivateNumA = new HasSelfPrivateNum();
        HasSelfPrivateNum hasSelfPrivateNumB = new HasSelfPrivateNum();
        //分别使用两个对象
        RunnableA runnableA = new RunnableA(hasSelfPrivateNumA);
        RunnableB runnableB = new RunnableB(hasSelfPrivateNumB);
        Thread threadA = new Thread(runnableA);
        threadA.start();
        Thread threadB = new Thread(runnableB);
        threadB.start();
    }

}

class HasSelfPrivateNum {
    private int num = 0;

    //持有的锁为this  由于两个线程持有的不是同一个对象 所以并没有拦截到
    synchronized public void add(String username) {
         System.out.println("ASDHOASJDIO");
        try {
            Thread.sleep(2000);
            if (username.equals("A")) {
                num = 100;
                System.out.println("AAAAAAAAAAAAA");
                Thread.sleep(2000);
            } else {
                num = 200;
                System.out.println("BBBBBBBBBBBBB");
            }
            System.out.println(username + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class RunnableA implements Runnable {

    private HasSelfPrivateNum hasSelfPrivateNum;

    public RunnableA(HasSelfPrivateNum hasSelfPrivateNum) {
        this.hasSelfPrivateNum = hasSelfPrivateNum;
    }

    @Override
    public void run() {
        hasSelfPrivateNum.add("A");
    }
}

class RunnableB implements Runnable {

    private HasSelfPrivateNum hasSelfPrivateNum;

    public RunnableB(HasSelfPrivateNum hasSelfPrivateNum) {
        this.hasSelfPrivateNum = hasSelfPrivateNum;
    }

    @Override
    public void run() {
        hasSelfPrivateNum.add("B");
    }
}