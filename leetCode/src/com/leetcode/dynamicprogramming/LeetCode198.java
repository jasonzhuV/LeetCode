package com.leetcode.dynamicprogramming;

import java.util.Scanner;

public class LeetCode198 {
    public static void main(String[] args) {
        LeetCode198 leetCode198 = new LeetCode198();
        Scanner scanner = new Scanner(System.in);
        //String[] tempArray = temp.split("\\s+");
        String[] tempArray = scanner.nextLine().split(",");
        int[] nums = new int[tempArray.length];
        for (int i = 0; i < tempArray.length; i++) {
            nums[i] = Integer.parseInt(tempArray[i]);
        }
        LeetCode198.Solution solution = leetCode198.new Solution();
        System.out.println(solution.rob(nums));
    }

    class Solution {
        public int rob(int[] nums) {
            int n = nums.length;
            if (n <= 1) return n == 0 ? 0 : nums[0];
            int[] dp = new int[n];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < n; i++) {
                dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
            }
            return dp[n - 1];
        }
    }
}
/**
 * dp[i]=max{dp[i-1],nums[i]+dp[i-2]}
 * 是否抢了第i个，抢了第i个第i-1个就不能抢，没抢第i个第i-1个就可以抢，所以抢和不抢第i个有两种情况，选两种情况的较大值
 * <p>
 * public int rob(int[] nums) {
 * int n = nums.length;
 * if (n <= 1) return n == 0 ? 0 : nums[0];
 * int[] memo = new int[n];
 * memo[0] = nums[0];
 * memo[1] = Math.max(nums[0], nums[1]);
 * for (int i = 2; i < n; i++)
 * memo[i] = Math.max(memo[i - 1], nums[i] + memo[i - 2]);
 * return memo[n - 1];
 * }
 */
