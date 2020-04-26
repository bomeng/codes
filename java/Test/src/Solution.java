import sun.lwawt.macosx.CSystemTray;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0, j = n; i < n / 2; i++, j = j - 2) {
            rotate(matrix, i, i, j);
        }
    }

    public void rotate(int[][] matrix, int row, int col, int n) {
        for (int i = 0; i < n - 1; i++) {
            int temp = matrix[row][col + i];
            matrix[row][col + i] = matrix[row + n - 1 - i][col];
            matrix[row + n - 1 - i][col] = matrix[row + n - 1][ col + n - 1 - i];
            matrix[row + n - 1][ col + n - 1 - i] = matrix[row + i][col + n - 1];
            matrix[row + i][col + n - 1] = temp;
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }

        return new ArrayList<>(map.values());
    }

    public void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        solution.groupAnagrams(strs);
    }
}