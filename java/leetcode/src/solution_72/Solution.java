package solution_72;

public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        char[] word1Arr = word1.toCharArray();
        char[] word2Arr = word2.toCharArray();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int x = dp[i - 1][j] + 1; // deletion
                int y = dp[i][j - 1] + 1; // insertion
                int z = dp[i - 1][j - 1]; // substitution
                if (word1Arr[i - 1] != word2Arr[j - 1]) {
                    z = z + 1;
                }
                dp[i][j] = Math.min(Math.min(x, y), z);
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int s = solution.minDistance("INTENTION", "EXECUTION");
        System.out.println(s);
    }
}
