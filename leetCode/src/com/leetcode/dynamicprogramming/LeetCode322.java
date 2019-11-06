package com.leetcode.dynamicprogramming;

import java.util.Scanner;



public class LeetCode322 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String coinStr = scanner.nextLine();
        String[] coinArr = coinStr.split(",");
        int[] coins = new int[coinArr.length];
        int amount;
        for (int i = 0; i < coinArr.length; i++) {
            coins[i] = Integer.parseInt(coinArr[i]);
        }
        amount = scanner.nextInt();
        LeetCode322 leetCode322 = new LeetCode322();
        Solution solution = leetCode322.new Solution();
        System.out.println(solution.coinChange(coins, amount));
    }
    //递归 为了找思路
//    class Solution {
//        public int coinChange(int[] coins, int amount) {
//            return search(coins,amount);
//        }
//        public int search(int[] coins, int amount) {
//            int min = Integer.MAX_VALUE;
//            if(amount == 0) return 0;
//            else if(amount < 0) return Integer.MAX_VALUE;
//            for(int i = 0; i < coins.length; i++){
//                if(search(coins,amount - coins[i]) < min - 1)
//                    min = search(coins,amount - coins[i]) + 1;
//            }
//            return min;
//        }
//    }
    //动态规划

    /**
     * [186,419,83,408]
     * 6249
     */
    class Solution {
        public int coinChange(int[] coins, int amount) {
            if(amount == 0) return 0;
            int[] dp = new int[amount + 1];
            for(int i = 0; i <= amount; i++){
                dp[i] = Integer.MAX_VALUE;//初始用正无穷表示无解
            }
            for(int i = 0; i < coins.length; i++){
                if(coins[i] <= amount) dp[coins[i]] = 1;//金额为硬币面值时，用1个硬币即可
            }
            for(int i = 1; i <= amount; i++){
                if(dp[i] != Integer.MAX_VALUE) continue;//到i时i的值尚未得出，只能有命中硬币面值的情况，不做操作
                for(int j = 0; j < coins.length; j++){
                    //应为dp[Math.max(0,i - coins[j])] + 1  但是正无穷+1会超过 若dp[i]为MAX_VALUE -1后还是MAX_VALUE
                    //若dp[i]为MAX_VALUE不做操作
                    //若dp[Math.max(0,i - coins[j])]有值，将这个值赋给dp[i]
                    //若同是有值即是比较然后赋值
                    if(dp[Math.max(0,i - coins[j])] < dp[i] - 1){
                        dp[i] = dp[Math.max(0,i - coins[j])] + 1;//选出用不同硬币时，用量较小的一种
                    }
                }
            }
            if(dp[amount] == Integer.MAX_VALUE) return -1;//不能满足
            return dp[amount];
        }
    }
}