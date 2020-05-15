package solution_454;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                int key = a + b;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }

        int count = 0;
        for (int c : C) {
            for (int d : D) {
                int key = -(c + d);
                count = count + map.getOrDefault(key, 0);
            }
        }

        return count;
    }
}
