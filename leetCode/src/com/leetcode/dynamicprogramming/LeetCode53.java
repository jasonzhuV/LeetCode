package com.leetcode.dynamicprogramming;

/**
 * leetcode
 * 53
 * 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解
 */

import java.util.Scanner;

/**
 * 思路
 * 没有动态规划思路
 * 暴力遍历 二次循环 选出最大值 不可取，动态规划方程写的也不对
 */
public class LeetCode53 {
    public static void main(String[] args) {
        LeetCode53 leetCode53 = new LeetCode53();
        Solution solution = leetCode53.new Solution();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputArr = input.split(",");
        int[] nums = new int[inputArr.length];
        for(int i = 0; i < inputArr.length; i++){
            nums[i] = Integer.parseInt(inputArr[i]);
        }
        System.out.println(solution.maxSubArray(nums));
    }

    class Solution {
        public int maxSubArray(int[] nums) {
            int max;
            int n = nums.length;
            int[] dp = new int[n];
            dp[0] = nums[0];
            max = dp[0];
            for(int i = 1; i < n; i++){
                dp[i] = Math.max(dp[i-1] + nums[i],nums[i]);
                if(dp[i] > max){
                    max = dp[i];
                }
            }
            return max;
        }
    }




//    class Solution {
//        public int maxSubArray(int[] nums) {
//            int n = nums.length;
//            int max = nums[0];
//            int tempMax = 0;
//            for (int i = 0; i < n; i++) {
//                for(int j = i; j < n; j++){
//                    for(int k = i; k <= j; k++){
//                        tempMax += nums[k];
//                    }
//                    if(tempMax > max){
//                        max = tempMax;
//                    }
//                    tempMax = 0;
//                }
//            }
//            return max;
//        }
//    }
}


/**
 public int maxSubArray(int[] nums) {
 if(nums.length == 1){
 return nums[0];
 }
 int realMax = nums[0];
 int currMax = nums[0];
 for(int i = 1;i < nums.length;i++){
 if(currMax + nums[i] > nums[i]){
 currMax += nums[i];
 }else{
 currMax = nums[i];
 }
 if(currMax > realMax){
 realMax = currMax;
 }
 }
 return realMax;
 }





 分治算法，时间100%

 public int maxSubArray(int[] nums) {
 return divide(nums, 0, nums.length-1);
 }

 //分治算法
 private int divide(int[] nums, int left, int right){
 if(left == right) return nums[left];
 if(left == right - 1){
 int max;
 max = Math.max(nums[left], nums[right]);
 max = Math.max(max, nums[left] + nums[right]);
 return max;
 }

 int mid  = (left + right) >> 1;
 int lSum = divide(nums, left, mid - 1);
 int rSum = divide(nums, mid + 1, right);

 int max = nums[mid];
 int sum = max;
 for(int i = mid - 1; i >= left; i--){
 sum += nums[i];
 max = Math.max(max, sum);
 }

 sum = max;
 for(int j = mid + 1; j <= right; j++){
 sum += nums[j];
 max = Math.max(max, sum);
 }

 max = Math.max(max, lSum);
 max = Math.max(max, rSum);
 return max;
 }





 1.C++ 2.动态规划

 class Solution {
 public:
 int maxSubArray(vector<int>& nums) {
 //dp
 //1.状态定义 F(i)表示下标为i时连续数组的最大和
 //2.状态转移方程 F(i) = max(F(i-1)+nums[i],nums[i]);
 //3.初始状态 F(0) = nums[0];
 //4.返回值 F(nums.size()-1)

 //code
 if(nums.empty()) return 0;

 vector<int> v(nums);
 int maxNum = nums[0];
 for(int i = 1;i < nums.size();++i){
 v[i] = max(v[i-1]+nums[i],nums[i]);

 if(maxNum < v[i])
 maxNum = v[i];
 }

 return maxNum;
 }
 };






 int maxSubArray(int* nums, int numsSize) {
 if (numsSize == 0) {
 return 0;
 }

 // 一段一段的子数列的和
 int sum = nums[0];
 int res = nums[0];
 // 动态规划的题
 for (int i = 1; i < numsSize; i++) {
 if (sum > 0) {
 // 前面累加的增长 > 0 那就加上我自己再看看
 sum +=nums[i];
 } else {
 // 前面累加的增长 < 0  前面的所有累加的增长都白干了，那就从这一次开始看后面的吧
 sum = nums[i];
 }
 // sum就等于从前面某一天到今天的增长
 if (sum > res) {
 res = sum;
 }
 }

 return res;
 }

 */