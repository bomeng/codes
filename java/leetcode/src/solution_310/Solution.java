package solution_310;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) { // for [] case
            List<Integer> res = new ArrayList<>();
            res.add(0);
            return res;
        }

        // build parent / children map
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            Set<Integer> set = map.getOrDefault(a, new HashSet<>());
            set.add(b);
            map.put(a, set);
            set = map.getOrDefault(b, new HashSet<>());
            set.add(a);
            map.put(b, set);
        }

        // find the leaves and remove them iteratively
        Set<Integer> leaves = new HashSet<>();
        for (Integer key : map.keySet()) {
            if (map.get(key).size() == 1) {
                leaves.add(key);
            }
        }

        int remaining = n;
        while (remaining > 2) {
            remaining = remaining - leaves.size();
            Set<Integer> newLeaves = new HashSet<>();
            for (Integer leaf : leaves) {
                int parent = map.get(leaf).stream().findAny().get();
                map.get(parent).remove(leaf);
                if (map.get(parent).size() == 1) {
                    newLeaves.add(parent);
                }
            }
            leaves = newLeaves;
        }
        return new ArrayList<>(leaves);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMinHeightTrees(4, new int[][] {{1, 0}, {1, 2}, {1, 3}}));
        System.out.println(solution.findMinHeightTrees(1, new int[][] {}));
    }
}
