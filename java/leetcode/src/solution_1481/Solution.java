package solution_1481;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            return map.get(a) - map.get(b);
        });
        queue.addAll(map.keySet());

        for (int i = 0; i < k; i++) {
            Integer j = queue.poll();
            int count = map.get(j) - 1;
            if (count > 0) {
                map.put(j, count);
                queue.offer(j);
            } else {
                map.remove(j);
            }
        }

        return map.keySet().size();
    }

    public static void main(String[] args) {
        Solution solution  = new Solution();
        int n = solution.findLeastNumOfUniqueInts(new int[] {5, 5, 4}, 1);
        System.out.println(n);
    }
}
