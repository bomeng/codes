package solution_1030;

import java.util.Arrays;

public class Solution {

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] result = new int[R * C][2];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                result[i * C + j] = new int[] {i, j};
            }
        }

        Arrays.sort(result, (a, b) -> Math.abs(a[0] - r0) + Math.abs(a[1] - c0) - Math.abs(b[0] - r0) - Math.abs(b[1] - c0));
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.allCellsDistOrder(2, 3, 1, 2);
    }
}
