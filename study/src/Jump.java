public class Jump {

    public static void main(String[] args) {
        for(int i = 1; i < 40; i++){
            System.out.println("if (target == " + i + ") return " + JumpFloor(i) + ";");
        }
    }

    public static int JumpFloor(int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2; i < target; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target - 1];
    }

}
