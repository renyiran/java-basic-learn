package com.anthony.box;

import java.util.ArrayList;
import java.util.List;

public class TTest {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(2);
        System.out.println(list1.indexOf(2));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list1 = new ArrayList<>();
        for (int i : nums1) {
            list1.add(i);
        }
        List<Integer> list2 = new ArrayList<>();
        for (int i : nums2) {
            if (list1.contains(i)) {
                list2.add(i);
                list1.remove(list1.indexOf(i));
            }
        }

        int[] nums3 = new int[list2.size()];
        for (int i = 0; i < list2.size(); i++) {
            nums3[i] = list2.get(i);
        }
        return nums3;
    }
}
