package solution_1162;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int maxDistance(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    count++;
                }
            }
        }
        if (count == 0 || count == grid.length * grid[0].length) {
            return -1;
        }

        int distance = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] j = queue.poll();
                int row = j[0];
                int col = j[1];
                grid[row][col] = 2;
                if (row - 1 >= 0 && grid[row - 1][col] == 0) {
                    grid[row - 1][col] = 1;
                    queue.offer(new int[]{row - 1, col});
                }
                if (row + 1 < grid.length && grid[row + 1][col] == 0) {
                    grid[row + 1][col] = 1;
                    queue.offer(new int[]{row + 1, col});
                }
                if (col - 1 >= 0 && grid[row][col - 1] == 0) {
                    grid[row][col - 1] = 1;
                    queue.offer(new int[]{row, col - 1});
                }
                if (col + 1 < grid[row].length && grid[row][col + 1] == 0) {
                    grid[row][col + 1] = 1;
                    queue.offer(new int[]{row, col + 1});
                }
            }
            distance = distance + 1;
        }
        return distance;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxDistance(new int[][]{{1, 0, 1}, {0, 0, 0}, {1, 0, 1}}));
    }
}
