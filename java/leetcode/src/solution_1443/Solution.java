package solution_1443;

import java.util.*;

public class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        // build the tree
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge: edges) {
            int a = edge[0];
            int b = edge[1];
            Set<Integer> set = map.getOrDefault(a, new HashSet<>());
            set.add(b);
            map.put(a, set);

            set = map.getOrDefault(b, new HashSet<>());
            set.add(a);
            map.put(b, set);
        }

        return helper(map, hasApple, 0, new HashSet<>());
    }

    private int helper(Map<Integer, Set<Integer>> map, List<Boolean> hasApple, int node, Set<Integer> visited) {
        visited.add(node);

        int result = 0;
        if (map.containsKey(node)) {
            for (int i: map.get(node)) {
                if (visited.contains(i)) {
                    continue;
                }
                result = result + helper(map, hasApple, i, visited);
            }
        }

        if ((result > 0 || hasApple.get(node)) && node != 0) {
            result = result + 2;
        }

        return result;
    }

    public static void main(String[] args) {
    }
}
