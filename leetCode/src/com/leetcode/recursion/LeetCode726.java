package com.leetcode.recursion;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * K4(ON(SO3)2)2
 */
public class LeetCode726 {
    public static void main(String[] args) {
//        String formula;
//        Scanner scanner = new Scanner(System.in);
//        formula = scanner.next();
//        String a = formula.substring(2);
//        System.out.println(a);
        Solution726 solution726 = new Solution726();
        solution726.countOfAtoms("K4(ON(SO3)2)2");
    }
}

class Solution726 {
    static Map<String, Integer> map = new HashMap<>();

    public String countOfAtoms(String formula) {
        int flag = 0;
        String toAdd = "";//需要切分添加的字符串
        String countString = "";
        int countNum;
        for (int i = 0; i < formula.length(); i++) {
            if (formula.charAt(i) != '(' && formula.charAt(i) != ')') {
                toAdd += formula.charAt(i);
            }
            if (formula.charAt(i) == '(') {
                if (flag == 0) {
                    System.out.println(toAdd);
                    toAdd = "";//第一次遇到括号，将游标字符置空，前面获得的游标值存入
                }else{
                    toAdd += formula.charAt(i);
                }
                flag++;
            }
            if (formula.charAt(i) == ')') {
                flag--;
                if (flag == 0) {
                    i++;
                    while (formula.charAt(i) >= '0' && formula.charAt(i) <= '9') {
                        countString += formula.charAt(i);
                        i++;
                        if(i >= formula.length()){
                            break;
                        }
                    }
                    countNum = Integer.parseInt(countString);//括号后的倍数
                    System.out.println(toAdd + "," + countNum);

                }else{
                    toAdd += formula.charAt(i);
                }
            }
        }
        return "";
    }

    public String dealWithFormula() {
        return "";
    }
}