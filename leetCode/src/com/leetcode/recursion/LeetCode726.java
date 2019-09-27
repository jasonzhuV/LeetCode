package com.leetcode.recursion;

import java.util.Scanner;

public class LeetCode726 {
    public static void main(String[] args) {
        String formula;
        Scanner scanner = new Scanner(System.in);
        formula = scanner.next();
        for(int i =0;i<formula.length();i++){
            char temp = formula.charAt(i);
            if(!Character.isLowerCase(temp))
            System.out.println(formula.charAt(i));
        }
//        byte[] formulaBytes = formula.getBytes();
//        for(int i =0;i<formulaBytes.length;i++){
//            System.out.println(formulaBytes[i]);
//        }
    }
}
// 去掉所有括号
//  K4(ON(SO3)2)2 K4
//  K4N2((OH)2H2(SO3)2)2

