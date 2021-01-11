package com.bytedance;

import java.util.*;

/**
 * ByteDance后端开发笔试题第一题
 */
/*
输入
10 2 5 6 13 11 11 4 10 8 12 5 4 1 8 1 7 12 4 13 6 9 9 9 5 7
6 3 13 8 2 3 7 3 2 2 12 11 10 6 10 1 1 12 3 5 7 11 13 4 8 9
输出
31 19
 */

public class Main {
    //定义初始两人牌数
    static int ByteCount = 26;
    static int DanceCount = 26;
    //两人出的牌
    static List<Integer> compare = new ArrayList();
    //两人的牌
    static List<Integer> Byte = new ArrayList();
    static List<Integer> Dance = new ArrayList();

    static int toCompare;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //初始化两人的牌
        for(int i=0;i<26;i++){
            Byte.add(scanner.nextInt());
        }
        for(int i=0;i<26;i++){
            Dance.add(scanner.nextInt());
        }
        ByteCheck();
    }
    public  static void ByteCheck(){
        if(Byte.size()==0){
            System.out.println("ByteCount:" + ByteCount + "," + "DanceCount:" + DanceCount);
            return;
        }
        toCompare = Byte.get(0);
        Byte.remove(0);
        ByteCount--;
        int flag = -1;
        //在对比列表中遍历出的牌，并记录命中时的下标
        for(int i =0;i<compare.size();i++){
            if(compare.get(i) == toCompare){
                flag = i;
                break;
            }
        }
        if(flag!=-1){
            //如果命中，增加命中人的牌数量，并且在对比列表中去除命中的牌
            ByteCount+=compare.size() + 1 -flag;
            int temp = compare.size();
            for(int j = temp ;j>flag;j--){
                compare.remove(j-1);
            }
            //Byte出过牌，轮到Dance出牌
            DanceCheck();
        }else{
            //未能命中，将出的牌加入到对比列表中
            compare.add(toCompare);
            //Byte出过牌，轮到Dance出牌
            DanceCheck();
        }
    }

    public static void DanceCheck(){
        if(Dance.size() == 0){
            System.out.println("ByteCount:" + ByteCount + "," + "DanceCount:" + DanceCount);
            return;
        }
        toCompare = Dance.get(0);
        Dance.remove(0);
        DanceCount--;
        int flag = -1;
        for(int i =0;i<compare.size();i++){
            if(compare.get(i) == toCompare){
                flag = i;
                break;
            }
        }
        if(flag!=-1){
            DanceCount+=compare.size() + 1 -flag;
            int temp = compare.size();
            for(int j = temp ;j>flag;j--){
                compare.remove(j-1);
            }
            //Dance出过牌，轮到Byte出牌
            ByteCheck();
        }else{
            compare.add(toCompare);
            //Dance出过牌，轮到Byte出牌
            ByteCheck();
        }
    }
}