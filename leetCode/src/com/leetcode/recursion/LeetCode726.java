package com.leetcode.recursion;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LeetCode726 {
    public static void main(String[] args) {
        String formula;
        Scanner scanner = new Scanner(System.in);
        formula = scanner.next();
        String a = formula.substring(2);
        System.out.println(a);
        Solution726 solution726 = new Solution726();
        Map<String,Integer> map = new HashMap();
        System.out.println(solution726.clean(formula,map));
    }
}

class Solution726 {
    public String clean(String formula,Map<String,Integer> map) {
        String afterClean = "";
        int begin = 0;
        int end = 0;
        int flag = 0;
        String count = "";
        int countNum = 0;
        for (int i = 0; i < formula.length(); i++) {
            char temp = formula.charAt(i);
            if (temp != '(' ) {
                begin = i;//标记第一组 （ ） 开始位置  包含（
                break;
            }
            afterClean += temp;
        }
        if(!map.containsKey(afterClean)){
            map.put(afterClean,1);
        }
        for(int i = begin; i < formula.length();i++){
            char temp = formula.charAt(i);
            if (temp == '(' ) {
                flag++;
            }
            if(temp == ')'){
                flag--;
                if(flag == 0){
                    end = i;//标记第一组 （ ） 结束位置  包含）
                    i++;
                    while(formula.charAt(i) >='0' && formula.charAt(i) <='9'){
                        count += formula.charAt(i);
                        i++;
                    }
                    countNum = Integer.parseInt(count);
                    break;
                }
            }
        }
        return afterClean;
    }
}
// 去掉所有括号
//  K4(ON(SO3)2)2
/**
 * K4(ON(SO3)2)2    1
 * ON(SO3)2         2
 * SO3              2
 * S2O6             1
 * ONS2O6           1
 * O2N2S4O12        1
 * K4O2N2S4O12      1
 * <p>
 * 合并
 * <p>
 * K4O14N2S4
 * <p>
 * <p>
 * 判断ch是数字，条件是     (ch>='0' && ch<='9')
 * 判断ch是字符，条件是     (ch>='A' && ch<='Z'  ||  ch>='a' && ch<='z')
 *
 * K4N2((OH)2H2(SO3)2)2
 */

