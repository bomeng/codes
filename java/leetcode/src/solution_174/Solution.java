package solution_174;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        Map<String, Integer> map = new HashMap<>();
        return mhr(dungeon, 0, 0, map);
    }

    int mhr(int[][] arr, int i, int j, Map<String, Integer> map) {
        String key = i + "," + j;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (i == arr.length - 1 && j == arr[0].length - 1) {
            int value = arr[i][j] > 0 ? 1 : Math.abs(arr[i][j]) + 1;
            map.put(key, value);
            return value;
        }
        if (i == arr.length || j == arr[0].length) {
            int value = Integer.MAX_VALUE;
            map.put(key, value);
            return value;
        }
        int value = Math.max(1, Math.min(mhr(arr, i + 1, j, map), mhr(arr, i, j + 1, map)) - arr[i][j]);
        map.put(key, value);
        return value;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.calculateMinimumHP(new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}});
    }
}
