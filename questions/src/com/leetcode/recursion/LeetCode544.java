package com.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeetCode544 {
    public static void main(String[] args) {
        LeetCode544 leetCode544 = new LeetCode544();
        Solution solution = leetCode544.new Solution();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(solution.findContestMatch(n));
    }


    class Solution {
        public String findContestMatch(int n) {
            List<String> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                list.add(Integer.toString(i));
            }
            return check(list).get(0);

        }

        public List<String> check(List<String> list) {
            int size = list.size();
            if(size == 1){
                return list;
            }
            List<String> listTemp = new ArrayList<>();
            int half = (size + 1) / 2;
            for (int i = 0; i < half; i++) {
                String temp = "(" + list.get(i) + "," + list.get(size - i - 1) + ")";
                listTemp.add(temp);
            }
            return check(listTemp);
        }
    }

}

