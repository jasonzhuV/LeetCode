package com.methods;

import java.util.Scanner;

public class LCS {
    public static void main(String[] args) {
        String aStr;
        String bStr;
        Scanner scanner = new Scanner(System.in);
        aStr = scanner.nextLine();
        bStr = scanner.nextLine();
        int a = aStr.length();
        int b = bStr.length();
        int[][] dp = new int[a + 1][b + 1];
        for(int i = 0; i <= a; i++){
            dp[i][0] = 0;
        }
        for(int i = 0; i <= b; i++){
            dp[0][i] = 0;
        }
        String out = "";
        for(int i = 1; i <= a; i++){
            for(int j = 1; j <= b; j++){
                if(aStr.charAt(i - 1) == bStr.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    out += aStr.charAt(i - 1);
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[a][b]);
        System.out.println(out);
    }
}
