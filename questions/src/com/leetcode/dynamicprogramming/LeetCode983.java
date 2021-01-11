package com.leetcode.dynamicprogramming;

import java.util.Scanner;

/**
 * 动态规划核心：当前日子的总花费应该是 Min(前一次的总花费加1天的花费，
 * 一周内距离该天最早的那天的总花费加一周的花费，
 * 一个月内距离该天最早的那天的总花费加一个月的花费)。
 * 保证每一次出行都是花费最少，最后返回最后一次出行的花费。
 * public int mincostTickets(int[] days, int[] costs) {
 * int weeks = 0, months = 0;
 * int[] dp = new int[days.length + 1];
 * for (int i = 0; i < days.length; i++) {
 * while (days[weeks] < days[i] - 6)
 * weeks++;
 * while (days[months] < days[i] - 29)
 * months++;
 * dp[i + 1] = Math.min(Math.min(dp[i] + costs[0], dp[weeks] + costs[1]), dp[months] + costs[2]);
 * <p>
 * }
 * return dp[days.length];
 * }
 * <p>
 * 是一个简单的动态规划问题。我们定义函数f(i) f(i)f(i)表示第i天的最低消费，那么
 * f(i)=f(i−1)  if i not in days
 * else f(i)=min(f(i−1)+costs[0],f(i−7)+costs[1],f(i−30)+costs[i−30])
 */
//下标要到当前值，dp数组要加一
public class LeetCode983 {
    public static void main(String[] args) {
        LeetCode983 leetCode983 = new LeetCode983();
        Solution solution983 = leetCode983.new Solution();
        Scanner scanner = new Scanner(System.in);
        //String daysString = scanner.nextLine();
        //String costsString = scanner.nextLine();
        //String daysString = "1,4,6,7,8,20";
        String daysString = "1,2,3,4,5,6,7,8,9,10,30,31";
        String costsString = "2,7,15";
        String[] daysArr = daysString.split(",");
        String[] costsArr = costsString.split(",");
        int[] days = new int[daysArr.length];
        int[] costs = new int[costsArr.length];
        for (int i = 0; i < daysArr.length; i++) {
            days[i] = Integer.parseInt(daysArr[i]);
        }
        for (int i = 0; i < costsArr.length; i++) {
            costs[i] = Integer.parseInt(costsArr[i]);
        }
        System.out.println(solution983.mincostTickets(days, costs));
    }

    class Solution {
        public int mincostTickets(int[] days, int[] costs) {
            int n = days.length;
            int[] dp = new int[days[n - 1] + 1];
            dp[0] = 0;
            int j = 0;
            for (int i = 1; i <= days[n - 1] && j < n; i++) {
                if (i != days[j]) {
                    dp[i] = dp[i - 1];
                    continue;
                }
                dp[i] = Math.min(Math.min(dp[Math.max(0, i - 1)] + costs[0], dp[Math.max(0, i - 7)] + costs[1]), dp[Math.max(0, i - 30)] + costs[2]);
                j++;
            }
            return dp[days[n - 1]];
        }
    }
}
