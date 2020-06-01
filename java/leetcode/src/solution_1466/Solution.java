package solution_1466;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] connection : connections) {
            list.get(connection[0]).add(connection[1]);
            list.get(connection[1]).add(-connection[0]);
        }

        return dfs(list, new boolean[n], 0);
    }

    private int dfs(List<List<Integer>> list, boolean[] visited, int from) {
        int change = 0;
        visited[from] = true;
        for (int to : list.get(Math.abs(from))) {
            if (!visited[Math.abs(to)]) {
                change += dfs(list, visited, Math.abs(to)) + (to > 0 ? 1 : 0);
            }
        }
        return change;
    }
}
