package com.bytedance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    static int temp =0;
    public static void main(String[] args) {
        List list = new ArrayList();
        Test test = new Test();
        Scanner scanner = new Scanner(System.in);
        for(int i = 0;i<5;i++){
            list.add(scanner.nextInt());
        }
        System.out.println(list);
        System.out.println(list.size());
        list.remove(0);
        System.out.println(list);
        System.out.println(list.size());
        //test.check();
        //test.deelWithTemp();
        //System.out.println(temp);
        //test.check2();
    }

    private void check(){
        temp = 100;
    }
    public void check2(){
        //觉得是引用数据类型和基本数据类型有区别
        String[] drMessage = new String[1];
        int[] temps = new int[1];
        int temp = 6;
        temps[0] = 0;
        System.out.println(temps[0]);
        deelNotStatic(drMessage,temp,temps);
        System.out.println(drMessage[0]);
        System.out.println(temp);
        System.out.println(temps[0]);
    }
    private void deelWithTemp(){
        temp += 15;
    }
    private void deelNotStatic(String[] drMessage,int temp,int[] temps){
        drMessage[0] = "123";
        temp = 30;
        temps[0] = 521;
    }
}
