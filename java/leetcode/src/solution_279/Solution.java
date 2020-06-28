package solution_279;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numSquares(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        return numSquares(n, map);
    }

    private int numSquares(int n, Map<Integer, Integer> map) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        double s = Math.sqrt(n);
        if (s == (int) s) {
            map.put(n, 1);
            return 1;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            min = Math.min(min, numSquares(n - i * i, map) + 1);
        }
        map.put(n, min);
        return min;
    }
}
