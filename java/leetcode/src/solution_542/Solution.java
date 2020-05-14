package solution_542;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                } else {
                    matrix[i][j] = -1;
                }
            }
        }
        int value = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] item = queue.poll();
                int x = item[0];
                int y = item[1];
                if (x - 1 >= 0 && matrix[x - 1][y] == -1) {
                    matrix[x - 1][y] = value;
                    queue.offer(new int[] {x - 1, y});
                }
                if (x + 1 < matrix.length && matrix[x + 1][y] == -1) {
                    matrix[x + 1][y] = value;
                    queue.offer(new int[] {x + 1, y});
                }
                if (y - 1 >= 0 && matrix[x][y - 1] == -1) {
                    matrix[x][y - 1] = value;
                    queue.offer(new int[] {x, y - 1});
                }
                if (y + 1 < matrix[x].length && matrix[x][y + 1] == -1) {
                    matrix[x][y + 1] = value;
                    queue.offer(new int[] {x, y + 1});
                }
            }
            value = value + 1;
        }
        return matrix;
    }
}
