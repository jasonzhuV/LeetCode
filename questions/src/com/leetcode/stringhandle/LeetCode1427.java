package com.leetcode.stringhandle;

import com.leetcode.dynamicprogramming.LeetCode221;

public class LeetCode1427 {
    
    public static void main(String[] args) {

        LeetCode1427.Solution solution = new LeetCode1427().new Solution();

        String s = "abcdefg";

       int[][] shift = {{1,1},{1,1},{0,2},{1,3}};

        System.out.println(solution.stringShift(s, shift));



    }


    /*
    输入：s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
    输出："efgabcd"
     */
    class Solution {
        public String stringShift(String s, int[][] shift) {
            int left = 0;
            for (int i = 0; i < shift.length; i++) {
                if (shift[i][0] == 0) {
                    left += shift[i][1];
                } else {
                    left -= shift[i][1];
                }
            }
            left %= s.length();

            if (left < 0) left += s.length();
            StringBuffer sb1 = new StringBuffer(s.substring(0, left)).reverse();
            StringBuffer sb2 = new StringBuffer(s.substring(left)).reverse();
            return sb1.append(sb2).reverse().toString();
        }
    }

}
