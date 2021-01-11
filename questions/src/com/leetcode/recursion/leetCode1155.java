package com.leetcode.recursion;

import java.util.HashMap;
import java.util.Scanner;

public class leetCode1155 {
	/*
	 * 输入：d = 30, f = 30, target = 500
	 * 输出：222616187
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int faces = scanner.nextInt();
		int target = scanner.nextInt();
		leetCode1155 lc1155 = new leetCode1155();
		System.out.println("zpw  :" + lc1155.numRollsToTarget(num, faces, target));
		System.out.println("right:" + lc1155.numRollsToTarget1(num, faces, target));
	}

	public int numRollsToTarget(int d, int f, int target) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		return dfs(d, f, target,map);
	}
	/*
	 * 递归，拿map记录中间值
	 */
	public int dfs(int d, int f, int target,HashMap<String,Integer> map) {
		if (d * f < target) {
			return 0;
		}
		if (d == 1) {
			if (target <= f && target > 0) {
				return 1;
			} else {
				return 0;
			}
		}
		String key = d + "-" + target;
		if (map.containsKey(key)) {
			return (Integer) map.get(key);
		}
		int sum = 0;
		for (int time = 1; time <= f; time++) {
			sum += dfs(d - 1, f, target - time,map);
			sum = sum%1000000007;//要在此处取余 在return之前取余会越界
		}
		map.put(key, sum);
		return sum;
	}
	/*
	 * 动态规划
	 * 参考方法
	 */
	public int numRollsToTarget1(int d, int f, int target) {
		int[][] dp = new int[31][1001];

		dp[0][0] = 1;
		int mod = (int) 1000000007;
		// dp[i][j]代表掷i个骰子时和为j的方法数
		for (int i = 1; i <= d; i++) {
			for (int k = 1; k <= f; k++) {
				for (int j = k; j <= f * d; j++) {
					dp[i][j] += dp[i - 1][j - k];
					dp[i][j] %= mod;
				}
			}
		}
		return dp[d][target];
	}
}
