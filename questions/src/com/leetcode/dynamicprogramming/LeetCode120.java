package com.leetcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 我在做这题的时候想到了按照三角形从上到下进行动态规划
 * 但是有一个问题，就是下一个dp[i]算出来的时候，在接下来的计算中还要使用dp[i]，就形成了覆盖，我想到了消除覆盖的影响
 * 参考别人做法后，发现可以按三角形从下向上的方式进行动态规划
 */

public class LeetCode120 {
    public static void main(String[] args) {
        LeetCode120 leetCode120 = new LeetCode120();
        Scanner scanner = new Scanner(System.in);
        String s;
        String[] tempArr;
        List<Integer> listLine;
        List<List<Integer>> triangle = new ArrayList<>();

        while(!(s = scanner.nextLine()).equals("")){
            tempArr = s.split(",");
            listLine = new ArrayList<>();
            for(int i = 0; i < tempArr.length; i++){
                listLine.add(Integer.parseInt(tempArr[i]));
            }
            triangle.add(listLine);
        }
        Solution solution = leetCode120.new Solution();
        System.out.println(solution.minimumTotal(triangle));
        System.out.println(solution.noInit());
    }

    class Solution {
        public int noInit(){
            int[][] dp = new int[3][3];
            dp[2][2] = Math.min(dp[0][0],dp[0][1]) + 2;
            System.out.println(dp[2][2]);
            return 0;
        }


        public int minimumTotal(List<List<Integer>> triangle) {
            List<Integer> dp = new ArrayList<>();
            int result;
            dp.add(triangle.get(0).get(0));
            for(int i = 1; i < triangle.size(); i++){
                for(int j = 0; j < triangle.get(i).size(); j++){
                    if(j == 0){
                        dp.add(0,dp.get(j) + triangle.get(i).get(j));
                    }else if(j == triangle.get(i).size() - 1){
                        dp.add(j,dp.get(j) + triangle.get(i).get(j));
                        dp.remove(j + 1);
                    }else {
                        dp.add(j,Math.min(triangle.get(i).get(j) + dp.get(j), triangle.get(i).get(j) + dp.get(j + 1)));
                        dp.remove(j + 1);
                    }
                }
            }
            result = dp.get(0);
            for(int i = 0; i < dp.size();i ++){
                if(dp.get(i) < result){
                    result = dp.get(i);
                }
            }
            return result;
        }
    }
}
    /**
     * 解法1 二维数组进行求解
     * @param triangle
     * @return
     */
//    public int minimumTotal(List<List<Integer>> triangle) {
//        if (triangle == null || triangle.size() == 0){
//            return 0;
//        }
//        // 加1可以不用初始化最后一层
//        int[][] dp = new int[triangle.size()+1][triangle.size()+1];
//
//        for (int i = triangle.size()-1; i>=0; i--){
//            List<Integer> curTr = triangle.get(i);
//            for(int j = 0 ; j< curTr.size(); j++){
//                dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + curTr.get(j);
//            }
//        }
//        return dp[0][0];
//    }

    /**
     * 解法2 一维数组进行求解
     * @param triangle
     * @return
     */
//    public int minimumTotal(List<List<Integer>> triangle) {
//        if (triangle == null || triangle.size() == 0){
//            return 0;
//        }
//        // 只需要记录每一层的最小值即可
//        int[] dp = new int[triangle.size()+1];
//
//        for (int i = triangle.size() - 1; i >= 0; i--) {
//            List<Integer> curTr = triangle.get(i);
//            for (int j = 0; j < curTr.size(); j++) {
//                //这里的dp[j] 使用的时候默认是上一层的，赋值之后变成当前层
//                dp[j] = Math.min(dp[j],dp[j+1]) + curTr.get(j);
//            }
//        }
//        return dp[0];
//    }