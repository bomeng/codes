package solution_494;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        Map<String, Integer> map = new HashMap<>();
        return count(nums, 0, 0, S, map);
    }

    private int count(int[] nums, int i, int cs, int S, Map<String, Integer> map) {
        String key = i + "," + cs;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (i == nums.length && cs == S) {
            map.put(key, 1);
            return 1;
        }
        if (i == nums.length) {
            map.put(key, 0);
            return 0;
        }
        int value =  count(nums, i + 1, cs + nums[i], S, map) + count(nums, i + 1, cs - nums[i], S, map);
        map.put(key, value);
        return value;
    }
}
