package solution_1462;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        boolean[][] connected = new boolean[n][n];
        for (int[] a: prerequisites) {
            connected[a[0]][a[1]] = true;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j ++) {
                for (int k = 0; k < n; k++) {
                    if (connected[j][i] && connected[i][k]) {
                        connected[j][k] = true;
                    }
                }
            }
        }

        List<Boolean> result = new ArrayList<>();
        for (int[] query: queries) {
            result.add(connected[query[0]][query[1]]);
        }
        return result;
    }
}
