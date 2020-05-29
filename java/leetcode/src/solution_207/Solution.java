package solution_207;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new HashSet<>());
        }
        for (int[] i : prerequisites) {
            map.get(i[1]).add(i[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] explored = new boolean[numCourses];


        for (int i = 0; i < numCourses; i++) {
            if (isCycle(i, map, visited, explored)) {
                return false;
            }
        }
        return true;
    }

    private boolean isCycle(int i, Map<Integer, Set<Integer>> map, boolean[] visited, boolean[] explored) {
        if (explored[i]) {
            return true;
        }
        if (visited[i]) {
            return false;
        }

        visited[i] = true;
        explored[i] = true;
        for (Integer j: map.get(i)) {
            if (isCycle(j, map, visited, explored)) {
                return true;
            }
        }
        explored[i] = false;
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canFinish(4, new int[][] {{2, 0}, {1, 0}, {3, 1}, {3, 2}, {1, 3}}));
        System.out.println(solution.canFinish(8, new int[][]
                {{1, 0}, {2, 6}, {1, 7}, {6, 4}, {7, 0}, {0, 5}}));
    }
}
