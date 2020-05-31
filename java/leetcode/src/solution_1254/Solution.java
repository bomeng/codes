package solution_1254;

import java.util.Arrays;

public class Solution {

    public int closedIsland(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    boolean[] result = new boolean[1];
                    result[0] = true;
                    dfs(i, j, grid, result);
                    if (result[0]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j, int[][] grid, boolean[] result) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 0) {
            return;
        }
        if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1) {
            result[0] = false;
        }
        grid[i][j] = 2;
        dfs(i - 1, j, grid, result);
        dfs(i + 1, j, grid, result);
        dfs(i, j + 1, grid, result);
        dfs(i, j - 1, grid, result);
    }

    private void printGrid(int[][] grid) {
        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int s = solution.closedIsland(new int[][] {
                {0, 0, 1, 1, 0, 1, 0, 0, 1, 0},
                {1, 1, 0, 1, 1, 0, 1, 1, 1, 0},
                {1, 0, 1, 1, 1, 0, 0, 1, 1, 0},
                {0, 1, 1, 0, 0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0, 1, 1, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1, 1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 1, 0, 1, 0, 1},
                {1, 1, 1, 0, 1, 1, 0, 1, 1, 0}
        });
        System.out.println(s);
    }
}
