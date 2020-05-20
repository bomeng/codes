package solution_1091;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid.length == 0 || grid[0][0] == 1) {
            return -1;
        }
        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});
        int count = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];
                if (row == grid.length - 1 && col == grid[0].length - 1) {
                    return count;
                }
                for (int[] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];
                    if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == 0) {
                        grid[newRow][newCol] = 1;
                        queue.offer(new int[] {newRow, newCol});
                    }
                }
            }
            count++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.shortestPathBinaryMatrix(new int[][] {{0, 1}, {1, 0}}));
    }
}
