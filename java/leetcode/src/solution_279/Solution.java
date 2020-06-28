package solution_279;

public class Solution {
    public int numSquares(int n) {
        int[] map = new int[n + 1];
        return numSquares(n, map);
    }

    private int numSquares(int n, int[] map) {
        if (map[n] > 0) {
            return map[n];
        }
        double s = Math.sqrt(n);
        if (s == (int) s) {
            map[n] = 1;
            return 1;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            min = Math.min(min, numSquares(n - i * i, map) + 1);
        }
        map[n] = min;
        return min;
    }
}
