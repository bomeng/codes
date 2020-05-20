package solution_1091;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid.length == 0 || grid[0][0] == 1) {
            return -1;
        }
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
                if (row - 1 >= 0 && col - 1 >= 0 && grid[row - 1][col - 1] == 0) {
                    grid[row - 1][col - 1] = 1;
                    queue.offer(new int[] {row - 1, col - 1});
                }
                if (row - 1 >= 0 && grid[row - 1][col] == 0) {
                    grid[row - 1][col] = 1;
                    queue.offer(new int[] {row - 1, col});
                }
                if (row - 1 >= 0 && col + 1 < grid[0].length && grid[row - 1][col + 1] == 0) {
                    grid[row - 1][col + 1] = 1;
                    queue.offer(new int[] {row - 1, col + 1});
                }
                if (col + 1 < grid[0].length && grid[row][col + 1] == 0) {
                    grid[row][col + 1] = 1;
                    queue.offer(new int[] {row, col + 1});
                }
                if (row + 1 < grid.length && col + 1 < grid[0].length && grid[row + 1][col + 1] == 0) {
                    grid[row + 1][col + 1] = 1;
                    queue.offer(new int[] {row + 1, col + 1});
                }
                if (row + 1 < grid.length && grid[row + 1][col] == 0) {
                    grid[row + 1][col] = 1;
                    queue.offer(new int[] {row + 1, col});
                }
                if (row + 1 < grid.length && col - 1 >= 0 && grid[row + 1][col - 1] == 0) {
                    grid[row + 1][col - 1] = 1;
                    queue.offer(new int[] {row + 1, col - 1});
                }
                if (col - 1 >= 0 && grid[row][col - 1] == 0) {
                    grid[row][col - 1] = 1;
                    queue.offer(new int[] {row, col - 1});
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
