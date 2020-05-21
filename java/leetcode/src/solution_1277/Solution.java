package solution_1277;

import java.util.Objects;

class Point {

    int row, col;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return row == point.row &&
                col == point.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}

public class Solution {

    public int countSquares(int[][] matrix) {
        int sum = 0;
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                if (matrix[i - 1][j - 1] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    sum = sum + dp[i][j];
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int s = solution.countSquares(new int[][] {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        });
        System.out.println(s);
    }
}
