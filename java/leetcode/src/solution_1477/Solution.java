package solution_1477;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        int sum = 0;
        m.put(0, -1);
        List<int[]> sub = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (m.containsKey(sum - target)) {
                int left = m.get(sum - target);
                sub.add(new int[]{left, i});
            }
            m.put(sum, i);
        }
        if (sub.size() <= 1) {
            return -1;
        }
        Integer leftMin = null;
        Integer rightMin = null;
        for (int l = 0, r = sub.size() - 1; l < r; ) {
            int[] r1 = sub.get(l);
            int[] r2 = sub.get(r);
            if (r1[1] > r2[0]) {
                break;
            }
            int l1 = r1[1] - r1[0];
            int l2 = r2[1] - r2[0];
            if (leftMin == null) {
                leftMin = l1;
                rightMin = l2;
            } else if (l1 < leftMin) {
                leftMin = l1;
            } else if (l2 < rightMin) {
                rightMin = l2;
            }
            if (l1 > l2) {
                l++;
            } else {
                r--;
            }
        }
        return leftMin == null ? -1 : leftMin + rightMin;
    }
}
