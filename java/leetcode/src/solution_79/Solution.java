package solution_79;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (verify(board, word, 0, i, j, new HashSet<>())) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean verify(char[][] board, String word, int index, int row, int col, Set<String> set) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[row].length || index >= word.length()) {
            return false;
        }
        if (board[row][col] != word.charAt(index)) {
            return false;
        }
        if (set.contains(row + "," + col)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        set.add(row + "," + col);
        if (verify(board, word, index + 1, row - 1, col, set) ||
                verify(board, word, index + 1, row + 1, col, set) ||
                verify(board, word, index + 1, row, col + 1, set) ||
                verify(board, word, index + 1, row, col - 1, set)) {
            return true;
        }

        set.remove(row + "," + col);
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.exist(new char[][] {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}},
                "ABCESEEEFS"));
    }
}
