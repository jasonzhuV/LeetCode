package com.johnson;

import java.util.Arrays;

public class Johnson {

    /*
    2 1
    2 2
    3 5
    1 9
     */
    public static void main(String[] args) {

        int[] a = {2, 2, 3, 1};
        int[] b = {1, 2, 5, 9};
        int[] orderd = new int[a.length];

        flowShop(a, b, orderd);
    }

    public static void flowShop(int[] a, int[] b, int[] orderd) {
        int n = a.length;
        Element[] elements = new Element[n];
        for (int i = 0; i < n; i++) {
            int key = Math.min(a[i], b[i]);//找作业在两台机器上处理时间最小的那个作业处理时间
            boolean job = a[i] < b[i];
            elements[i] = new Element(key, i, job);
        }
        //将所有作业按照key进行从小到大排序
        Arrays.sort(elements, (o1, o2) -> {
            if (o1.key < o2.key) {
                return -1;
            } else if (o1.key > o2.key) {
                return 1;
            } else {
                return 0;
            }
        });
        int j = 0, k = n - 1;
        //将作业按照Johnson法则排序放入c中
        for (int i = 0; i < n; i++) {
            if (elements[i].job) orderd[j++] = elements[i].index;//如果ai<bi,将其作业序号放入执行顺序数组中（从头开始放）
            else orderd[k--] = elements[i].index;//否则ai>=bi 将作业放入执行顺序数组（从尾部）
        }
        int m1 = a[orderd[0]];//第一个作业在M1上的处理时间
        int m2 = m1 + b[orderd[0]];//第一个作业在M2上处理完所需时间
        for (int i = 1; i < n; i++) {
            m1 += a[orderd[i]];//第i个作业在机器M1上加工完成所需时间
            /*
            如果此作业在M1上加工完成时间(包含前面作业在M1上的所用时间和)大于上一个作业完成时间，
            则此作业所需时间为m1+b[orderd[i]]，否则为m2+b[orderd[i]]
            */
            m2 = m1 < m2 ? m2 + b[orderd[i]] : m1 + b[orderd[i]];

        }
        System.out.println("加工次序: ");
        for (int i : orderd) {
            System.out.println("零件 : " + (i+1));
        }
        System.out.println("最短耗时 : " + m2);
    }

    public static class Element {
        int key;
        int index;
        boolean job;

        private Element(int kk, int ii, boolean jj) {
            key = kk;
            index = ii;
            job = jj;
        }
    }
}