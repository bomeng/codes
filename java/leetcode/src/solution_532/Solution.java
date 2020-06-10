package solution_532;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int count = 0;
        for (int i : map.keySet()) {
            int j = i + k;
            if (map.containsKey(j) && (j != i || map.get(j) > 1)) {
                count++;
            }
        }
        return count;
    }
}
