package solution_999;

public class Solution {

    public int numRookCaptures(char[][] board) {
        // find R
        int rx = 0;
        int ry = 0;
        boolean found = false;
        for (int i = 0; i < board.length && !found; i++) {
            for (int j = 0; j < board[i].length && !found; j++) {
                if (board[i][j] == 'R') {
                    rx = i;
                    ry = j;
                    found = true;
                    break;
                }
            }
        }
        int count = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] direction : directions) {
            int row = rx + direction[0];
            int col = ry + direction[1];
            while (row >= 0 && row < board.length && col >= 0 && col < board[row].length) {
                if (board[row][col] == 'B') {
                    break;
                } else if (board[row][col] == 'p') {
                    count++;
                    break;
                }
                row = row + direction[0];
                col = col + direction[1];
            }
        }
        return count;
    }
}
