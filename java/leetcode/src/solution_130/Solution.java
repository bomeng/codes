package solution_130;

public class Solution {
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            int j = 0;
            while (j < board[i].length) {
                if (board[i][j] == 'O') {
                    expand(i, j, board);
                }
                if (i == 0 || i == board.length - 1) {
                    j = j + 1;
                } else {
                    j = j + board[i].length - 1;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'V') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void expand(int i, int j, char[][] board) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length) {
            return;
        }
        if (board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'V';
        expand(i + 1, j, board);
        expand(i - 1, j, board);
        expand(i, j + 1, board);
        expand(i, j - 1, board);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve(new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}});
    }
}
