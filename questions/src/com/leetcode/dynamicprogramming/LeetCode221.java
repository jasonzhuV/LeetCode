package com.leetcode.dynamicprogramming;

public class LeetCode221 {

    public static void main(String[] args) {

        LeetCode221.Solution solution = new LeetCode221().new Solution();

        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

        System.out.println(-13 % 7);

        System.out.println(solution.maximalSquare(matrix));

    }

    class Solution {
        public int maximalSquare(char[][] matrix) {
            // row: m  column: n
            int m = matrix.length;
            int n = matrix[0].length;

            int[][] dp = new int[m][n];

            int max = 0;
            // init first row
            for (int i = 0; i < n; i++) {
                if (matrix[0][i] == '1') {
                    dp[0][i] = 1;
                    if(dp[0][i] > max) {
                        max = dp[0][i];
                    }
                }
            }
            // init first column
            for (int i = 0; i < m; i++) {
                if (matrix[i][0] == '1') {
                    dp[i][0] = 1;
                    if(dp[i][0] > max) {
                        max = dp[i][0];
                    }
                }
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {

                    if (matrix[i][j] == '0') {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]) + 1;
                    }

                    if(dp[i][j] > max) {
                        max = dp[i][j];
                    }
                }
            }

            return max * max;
        }
    }
}
