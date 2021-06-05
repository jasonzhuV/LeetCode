package com.leetcode.dynamicprogramming;


import java.util.Arrays;

public class LeetCode621 {

    public static void main(String[] args) {

        Solution solution = new LeetCode621().new Solution();

        System.out.println(solution.leastInterval("AAABBB".toCharArray(), 2));

    }


    /*
    A A A B B B
    A B * A B * A B
     */
    class Solution {
        public int leastInterval(char[] tasks, int n) {



            int[] taskCount_Index = new int[255];
            int groupNum = 0;

            for (char task : tasks) {
                if (taskCount_Index[task]==0){
                    groupNum++;
                }
                taskCount_Index[task]++;
            }
            int[] orderByNum = new int[groupNum];
            int i = 0;

            for (int taskCount : taskCount_Index) {
                if (taskCount != 0) {
                    orderByNum[i++] = taskCount;
                }
            }

            Arrays.sort(orderByNum);

            return 0;
        }
    }

}
