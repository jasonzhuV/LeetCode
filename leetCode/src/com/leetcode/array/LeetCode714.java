package com.leetcode.array;

import java.util.Scanner;

public class LeetCode714 {
    public static void main(String[] args) {
        LeetCode714 leetCode714 = new LeetCode714();
        Solution solution = leetCode714.new Solution();
        Scanner scan = new Scanner(System.in);
        //int[] prices = {1, 3, 2, 8, 4, 9};
        int[] prices = {1};
        int fee = 2;
        System.out.println(solution.maxProfit(prices, fee));
    }
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            int len = prices.length;
            int[][] dp = new int[2][len];
            //dp[0][i] 表示第i天不持有能获得的最大收益
            //dp[1][i] 表示第i天持  有能获得的最大收益
            dp[0][0] = 0;
            dp[1][0] = -prices[0];
            for (int i = 1; i < len; i++) {
                dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1] + prices[i] - fee);
                dp[1][i] = Math.max(dp[1][i - 1], dp[0][i - 1] - prices[i]);
            }
            return dp[0][len - 1];
        }
    }
}
