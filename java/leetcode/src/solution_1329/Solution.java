package solution_1329;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public int[][] diagonalSort(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            int x = i;
            int y = 0;
            list.clear();
            while (x <= row - 1 && y <= col - 1) {
                list.add(mat[x][y]);
                x++;
                y++;
            }
            Collections.sort(list);
            x = i;
            y = 0;
            for (int j : list) {
                mat[x][y] = j;
                x++;
                y++;
            }
        }
        for (int i = 1; i < col; i++) {
            int x = 0;
            int y = i;
            list.clear();
            while (x <= row - 1 && y <= col - 1) {
                list.add(mat[x][y]);
                x++;
                y++;
            }
            Collections.sort(list);
            x = 0;
            y = i;
            for (int j : list) {
                mat[x][y] = j;
                x++;
                y++;
            }
        }
        return mat;
    }
}
