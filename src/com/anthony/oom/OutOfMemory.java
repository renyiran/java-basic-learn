package com.anthony.oom;

import java.util.ArrayList;
import java.util.List;

public class OutOfMemory {

    //outofmemory分为两种
    //1.栈内存溢出 即没有足够的空间为该线程分配栈空间（-Xss设置的内存大小）
    //2.堆内存溢出 堆占用超过了最大值(-Xmx置的内存大小)


    public static void main(String[] args) {
//        List<OutOfMemory> list = new ArrayList<>();
//        while (true) {
//            list.add(new OutOfMemory());
//        }
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
        String str3 = new String("SSS") + new String("NNXX");
        System.out.println(str3.intern() == str3);

        System.out.println("---------");

        Integer a1 = 2000;
        Integer a2 = Integer.valueOf(2000);
        System.out.println(a1 == a2);
    }
}
