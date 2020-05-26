package solution_525;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int findMaxLength(int[] nums) {
        int max = 0;
        if (nums.length == 1 || nums.length == 0) {
            return max;
        }
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                sum += 1;
            } else {
                sum -= 1;
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            } else {
                max = Math.max(max, i - map.get(sum));
            }
        }
        return max;
    }
}
