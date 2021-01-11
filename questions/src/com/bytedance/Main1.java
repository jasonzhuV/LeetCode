package com.bytedance;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] Byte = new int[26];
        int[] Dance = new int[26];
        int ByteCount = 26;
        int DanceCount = 26;
        List com = new ArrayList();
        for(int i=0;i<26;i++){
            Byte[i] = scanner.nextInt();
        }
        for(int i=0;i<26;i++){
            Dance[i] = scanner.nextInt();
        }
        int No = 0;
        int No2 = 0;
        ByteCheck(ByteCount,DanceCount,com,Byte,Dance,No,No2);
    }
    public  static boolean ByteCheck(int ByteCount,int DanceCount,List com,int[] Byte,int[] Dance,int No,int No2){
        ByteCount--;
        if(No == 26){
            System.out.println("Byte");
            return false;
        }
        int flag = -1;
        for(int i =0;i<com.size();i++){
            if((int)com.get(i) == Byte[No]){
                flag = i;
                break;
            }
        }
        if(flag!=-1){
            ByteCount+=com.size()-flag+1;
            int temp = com.size();
            for(int j = temp ;j>flag;j--){
                com.remove(j-1);
            }
            return DanceCheck(ByteCount,DanceCount,com,Byte,Dance,No+1,No2);
        }else{
            com.add(Byte[No]);
            return DanceCheck(ByteCount,DanceCount,com,Byte,Dance,No+1,No2);
        }
    }

    public static boolean DanceCheck(int ByteCount,int DanceCount,List com,int[] Byte,int[] Dance,int No,int No2){
        DanceCount--;
        if(No2 == 26){
            System.out.println("Dance");
            return false;
        }
        int flag = -1;
        for(int i =0;i<com.size();i++){
            if((int)com.get(i) == Dance[No2]){
                flag = i;
                break;
            }
        }
        if(flag!=-1){
            DanceCount+=com.size()-flag+1;
            int temp = com.size();
            for(int j = temp ;j>flag;j--){
                com.remove(j-1);
            }
            return ByteCheck(ByteCount,DanceCount,com,Byte,Dance,No,No2+1);
        }else{
            com.add(Dance[No2]);
            return ByteCheck(ByteCount,DanceCount,com,Byte,Dance,No,No2+1);
        }
    }
}