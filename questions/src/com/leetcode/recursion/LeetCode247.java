package com.leetcode.recursion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class LeetCode247 {
    public static void main(String[] args) {
        LeetCode247 leetCode247 = new LeetCode247();
        Solution solution = leetCode247.new Solution();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(solution.findStrobogrammatic(n));
    }

    class Solution {
        public List<String> findStrobogrammatic(int n) {
            List<String> list = new ArrayList<>();
            list = check(list,n);
            if(n == 1){
                return list;
            }
            Iterator<String> iterator = list.iterator();
            while(iterator.hasNext()){
                if(iterator.next().startsWith("0")){
                    iterator.remove();
                }
            }
            return list;
        }
        public List<String> check(List<String> list,int n){
            if(n == 1){
                List<String> list1 = new ArrayList<>();
                list1.add("0");
                list1.add("1");
                list1.add("8");
                return list1;
            }
            if(n == 2){
                List<String> list2 = new ArrayList<>();
                list2.add("00");
                list2.add("11");
                list2.add("69");
                list2.add("88");
                list2.add("96");
                return list2;
            }
            List<String> listSearchTemp = new ArrayList<>();//用于获取上次的list
            List<String> listReturnTemp = new ArrayList<>();//用于返回本次的list
            listSearchTemp = check(list,n-2);
            Iterator<String> iterator = listSearchTemp.iterator();
            String temp;
            while(iterator.hasNext()){
                temp = iterator.next();
                listReturnTemp.add("0" + temp + "0");
                listReturnTemp.add("1" + temp + "1");
                listReturnTemp.add("6" + temp + "9");
                listReturnTemp.add("8" + temp + "8");
                listReturnTemp.add("9" + temp + "6");
            }
            return listReturnTemp;
        }
    }
}

