package solution_886;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] assigned = new int[N + 1]; // (0, 1, -1)
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            map.put(i, new HashSet<>());
        }
        for (int[] dislike : dislikes) {
            map.get(dislike[0]).add(dislike[1]);
            map.get(dislike[1]).add(dislike[0]);
        }
        for (int i = 1; i <= N; i++) {
            if (assigned[i] == 0 && !dfs(assigned, map, i, 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[] arr, Map<Integer, Set<Integer>> map, int start, int assigned) {
        if (arr[start] != 0) {
            return arr[start] == assigned;
        }
        arr[start] = assigned;
        for (Integer i : map.get(start)) {
            if (!dfs(arr, map, i, -assigned)) {
                return false;
            }
        }
        return true;
    }
}
