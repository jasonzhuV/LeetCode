package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeetCode738 {
    public static void main(String[] args) {
        int N;
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        LeetCode738 leetCode738 = new LeetCode738();
        Solution soulation = leetCode738.new Solution();
        System.out.println(soulation.monotoneIncreasingDigits(N));
    }
    class Solution {
        public int monotoneIncreasingDigits(int N) {
            List<Integer> list = new ArrayList();
            String str = Integer.toString(N);
            int length;
            length = str.length();
            for (int i = 0; i < length; i++) {
                list.add(Integer.parseInt(Character.toString(str.charAt(i))));
            }
            if (length == 1) {
                return N;
            }
            int flagSetZero = -1;
            boolean isUp = true; // 判断数字是否满足单调递增
            for (int i = 0; i < length - 1; i++) {
                if(list.get(i) > list.get(i + 1)) {
                    isUp = false;
                    break;
                }
            }
            if (isUp) {
                return N;
            }
            // 从前往后找
            for (int i = 0; i < length - 1; i++) {
                // 这里考虑是否符合条件
                if (list.get(i) > list.get(i + 1)) {
                    flagSetZero = i + 1;
                    break;
                }
            }
            if (flagSetZero == -1) {
                return N;
            }else {
                //把置0之后的数字-1
                String notZeroStr = "";
                for (int i = 0; i < flagSetZero; i++) {
                    notZeroStr += list.get(i).toString();
                }
                int notZeroInt = Integer.parseInt(notZeroStr);
                int tempN =  (int)(notZeroInt * Math.pow(10,length - flagSetZero) - 1);
                // 递归处理，因为有些数字在处理变化之后，又出现了不满足单调递增的情况
                return monotoneIncreasingDigits(tempN);
            }
        }
    }
    /*
    Solution1 暴力扫描 超时
    输入数据 273070984
     */
    class Solution1 {
        public int monotoneIncreasingDigits(int N) {
            int i;
            for(i = N; i > 0; i--) {
                if (isGoUp(i)) {
                    return i;
                }
            }
            return 0;
        }
        public boolean isGoUp(int X) {
            List<Integer> list = new ArrayList();
            String str = Integer.toString(X);
            int length;
            length = str.length();
            for (int i = 0; i < length; i++) {
                list.add(Integer.parseInt(Character.toString(str.charAt(i))));
            }
            if (length == 1) {
                return true;
            }
            for (int i = 0; i < length - 1; i++) {
                if (list.get(i) > list.get(i+1)) {
                    return false;
                }
            }
            return true;
        }
    }
}
