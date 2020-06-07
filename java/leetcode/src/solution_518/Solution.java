package solution_518;

public class Solution {

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int c: coins) {
            for (int i = c; i <= amount; i++) {
                dp[i] = dp[i] + dp[i -c];
            }
        }
        return dp[amount];
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.change(5, new int[] {1, 2, 5}));
    }
}
