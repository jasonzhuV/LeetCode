package com.leetcode.dynamicprogramming;

import java.util.Scanner;

public class LeetCode70 {

    public static void main(String[] args) {
        LeetCode70 leetCode70 = new LeetCode70();
        Solution solution = leetCode70.new Solution();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(solution.climbStairs(n));
    }

    class Solution {
        public int climbStairs(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            if(n == 1) return dp[1];
            dp[2] = 2;
            for(int i = 3; i <= n; i++){
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }
}
