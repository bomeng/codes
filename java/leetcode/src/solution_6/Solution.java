package solution_6;

public class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        int[][] directions = {{1, 0}, {-1, 1}};
        StringBuilder[] list = new StringBuilder[numRows];
        int row = 0;
        int col = 0;
        char[] arr = s.toCharArray();
        int direction = 0;
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (list[row] == null) {
                list[row] = new StringBuilder();
            }
            list[row].append(c);
            row = row + directions[direction][0];
            col = col + directions[direction][1];
            if (row == numRows - 1) {
                direction = 1;
            } else if (row == 0) {
                direction = 0;
            }
        }
        for (int i = 1; i < numRows; i++) {
            if (list[i] != null) {
                list[0].append(list[i]);
            } else {
                break;
            }
        }
        return list[0].toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convert("PAYPALISHIRING", 4));
    }
}
