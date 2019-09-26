package com.leetcode.recursion;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 1 <= k <= len(nums) <= 16
 * 0 < nums[i] < 10000
 */
public class LeetCode698 {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        int k = 4;
        LeetCode698 leetCode698 = new LeetCode698();
        System.out.println(leetCode698.canPartitionKSubsets(nums, k));
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int max = 0;
        int sum = 0;
        int ave = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            sum += nums[i];
        }
        //总和不能被k整除
        if (sum % k != 0) {
            return false;
        }
        ave = sum / k;
        //集合最大值大于平均值
        if (ave < max) {
            return false;
        }
        Arrays.sort(nums);
        List<Integer> list = new ArrayList();
        for (int i = nums.length - 1; i >= 0; i--) {
            list.add(nums[i]);
        }
        return (check(list, 0, k, ave));
    }

    public boolean check(List<Integer> list, int addSum, int count, int target) {
        //终止条件
        if (count == 0) {
            return true;
        }
        for (int i = 0; i < list.size(); i++) {
            if (addSum + list.get(i) == target) {
                int temp = list.remove(i);
                if (check(list, 0, count - 1, target)) {
                    return true;
                } else {
                    list.add(i, temp);
                }
            }
            if (addSum + list.get(i) < target) {
                int temp = list.remove(i);
                if (check(list, addSum + temp, count, target)) {
                    return true;
                } else {
                    list.add(i, temp);
                }
            }
        }
        return false;
    }
}
