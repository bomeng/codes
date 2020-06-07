package solution_1010;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : time) {
            int j = i % 60;
            int k = (60 - j) % 60;
            if (map.containsKey(k)) {
                count = count + map.get(k);
            }
            map.put(j, map.getOrDefault(j, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numPairsDivisibleBy60(new int[] {60, 60, 60}));
    }
}
