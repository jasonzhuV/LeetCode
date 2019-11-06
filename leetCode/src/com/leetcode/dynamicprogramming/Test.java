package com.leetcode.dynamicprogramming;

import java.util.Scanner;

public class Test {
    static int n;
    static int[] w = new int[4];
    static int[] v = new int[4];
    static int W;
    static int[][] f = new int[4][5];
    public static void main(String[] args) {
        Test test = new Test();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for(int i = 0; i < n; i++){
            w[i] = scanner.nextInt();
            for(int j = 0; j < 5; j++){
                f[i][j] = Integer.MIN_VALUE;
            }
        }
        for(int i = 0; i < n; i++){
            v[i] = scanner.nextInt();
        }
        W = scanner.nextInt();
        System.out.println(test.search(0,0));
    }
//    public int search(int idx,int S){
//        if(S > W){
//            return Integer.MIN_VALUE;
//        }
//        if(idx >= n){
//            return 0;
//        }
//        return Math.max(search(idx + 1, S + w[idx]) + v[idx], search(idx + 1, S));
//    }

    int search(int idx, int S){
        if(S > W){
            return Integer.MIN_VALUE;
        }
        if(idx >= n){
            return 0;
        }
        if(f[idx][S] >= 0){
            return f[idx][S];
        }
        f[idx][S] = Math.max(search(idx + 1,S + w[idx]) + v[idx],search(idx + 1,S));
        return f[idx][S];
    }

}
