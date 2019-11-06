package com.methods;

public class BinaryToInt {


    public static void main(String[] args) {
        boolean[] boo = new boolean[4];
        boo[0] = true;
        boo[1] = false;
        boo[2] = true;
        boo[3] = false;
        int a = 2;
        boolean b =true;
        a <<= 1;//需要进行一次位运算再进行计算|运算
        System.out.println(a|=1);
        System.out.println(BinaryToInt(boo));
    }

    public static int BinaryToInt(boolean[] bools) {
        int x = 0;
        for (boolean b : bools) {
            x <<= 1;//x基于2进制左移一位
            x |= (b ? 1 : 0);
        }
        return x;
    }
}
