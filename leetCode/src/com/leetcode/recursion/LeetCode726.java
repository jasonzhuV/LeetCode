package com.leetcode.recursion;

import java.util.*;

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
        solution726.countOfAtoms("K4(ON(H2O)3)2(MgO)4");
    }
}

class Solution726 {
    static Map<String, Integer> map = new HashMap<>();
    List<String> listWithoutSign = new ArrayList<>();

    public String countOfAtoms(String formula) {
        map.put(formula,1);
        listWithoutSign.add(formula);
        dealWithFormula();
        return "";
    }

    /**
     * 递归处理后
     * map中存储去除括号的表达式（拆分后）
     */
    public void dealWithFormula() {
        Iterator<String> iterator = listWithoutSign.iterator();
        List<String> keyListTemp = new ArrayList<>();
        String isWithSign;
        boolean isWithSignFlag = false;
        while(iterator.hasNext()){
            isWithSign = iterator.next();
            if(isWithSign.contains("(") || isWithSign.contains(")")){
                isWithSignFlag = true;
            }
            keyListTemp.add(isWithSign);
        }
        if(!isWithSignFlag){
            System.out.println(listWithoutSign);
            return;
        }
        for(int k = 0;k<keyListTemp.size();k++){
            String formula = keyListTemp.get(k);
            if(formula.contains("(") || formula.contains(")")){
                listWithoutSign.remove(formula);
                int flag = 0;
                String toAdd = "";//需要切分添加的字符串
                String countString = "";
                int countNum;
                for (int i = 0; i < formula.length(); i++) {
                    if (formula.charAt(i) != '(' && formula.charAt(i) != ')') {
                        toAdd += formula.charAt(i);
                    }
                    if (formula.charAt(i) == '(') {
                        if (flag == 0 && toAdd != null && !"".equals(toAdd)) {
                            if(!listWithoutSign.contains(toAdd)){
                                listWithoutSign.add(toAdd);
                            }else{
                                listWithoutSign.remove(toAdd);
                                listWithoutSign.add(toAdd+toAdd);
                            }
                            toAdd = "";//第一次遇到括号，将游标字符置空，前面获得的游标值存入
                        }
                        if(flag != 0){
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
                                if(i == formula.length()-1){
                                    break;
                                }else{
                                    if(!(formula.charAt(i+1) >= '0' && formula.charAt(i+1) <= '9')){
                                        break;
                                    }
                                }
                                i++;
                            }
                            countNum = Integer.parseInt(countString);//括号后的倍数
                            countString = "";
                            String toAddAfterCount = "";
                            if(!listWithoutSign.contains(toAdd)){
                                for(int num = 0;num < countNum;num++){
                                    toAddAfterCount += toAdd;
                                }
                                listWithoutSign.add(toAddAfterCount);
                            }else{
                                toAddAfterCount = toAdd;
                                for(int num = 0;num < countNum;num++){
                                    toAddAfterCount += toAdd;
                                }
                                listWithoutSign.add(toAddAfterCount);
                            }
                            toAdd = "";
                        }else{
                            toAdd += formula.charAt(i);
                        }
                    }
                }
            }
        }
        dealWithFormula();
    }
}