package solution_1476;

import java.util.Arrays;

public class SubrectangleQueries {
    int[][] rectangles;

    public SubrectangleQueries(int[][] rectangle) {
        rectangles = Arrays.copyOf(rectangle, rectangle.length);
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int row = row1; row <= row2; row++) {
            Arrays.fill(rectangles[row], col1, col2 + 1, newValue);
        }
    }

    public int getValue(int row, int col) {
        return rectangles[row][col];
    }
}