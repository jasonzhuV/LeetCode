package com.leetcode.hash;

import java.util.Scanner;

public class LeetCode389 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        String t = scan.next();
        LeetCode389 leetCode389 = new LeetCode389();
        Solution solution = leetCode389.new Solution();
        System.out.println(solution.findTheDifference(s, t));
    }
    class Solution {
        public char findTheDifference(String s, String t) {
            int[] numS = new int[26];
            int[] numT = new int[26];
            for (int i = 0; i < 26; i++) {
                numS[i] = 0;
                numT[i] = 0;
            }
            char ch;
            char res = '0';
            for (int i = 0; i < s.length(); i++) {
                ch = s.charAt(i);
                numS[ch - 'a']++;
            }
            for (int i = 0; i < t.length(); i++) {
                ch = t.charAt(i);
                numT[ch - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (numS[i] != numT[i]) {
                    res = (char)('a' + i);
                }
            }
            return res;
        }
    }
}
