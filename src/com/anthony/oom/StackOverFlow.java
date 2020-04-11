package com.anthony.oom;

public class StackOverFlow {

    private Integer countSize = 0;


    public static void main(String[] args) {
        StackOverFlow stackOverFlow = new StackOverFlow();
        try {
            stackOverFlow.round();
        } catch (Throwable e) {
            System.out.println(stackOverFlow.countSize);
            throw e;
        }

    }

    private void round() {
        countSize++;
        round();
    }
}
