package solution_1338;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Solution {

    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Entry<Integer, Integer>> list = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());

        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            count = count + list.get(i).getValue();
            if (count + count >= arr.length) {
                return i + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minSetSize(new int[] {3, 3, 3, 3, 5, 5, 5, 2, 2, 7}));
    }
}
