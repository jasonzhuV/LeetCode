package com.leetcode.dynamicprogramming;

/**
 * leetcode
 * 53
 * 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解
 */
public class LeetCode53 {
    public static void main(String[] args) {
        LeetCode53 leetCode53 = new LeetCode53();
        Solution solution = leetCode53.new Solution();
        int[] nums = new int[1];
        System.out.println(solution.maxSubArray(nums));
    }

    class Solution {
        public int maxSubArray(int[] nums) {
            return 0;
        }
    }
}
