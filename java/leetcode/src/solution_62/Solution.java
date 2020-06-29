package solution_62;

import java.util.Arrays;

public class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int s = solution.uniquePaths(7, 3);
        System.out.println(s);
    }
}
