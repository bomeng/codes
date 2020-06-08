package solution_1002;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> commonChars(String[] A) {
        int[][] map = new int[A.length][26];
        for (int i = 0; i < A.length; i++) {
            String a = A[i];
            for (char c : a.toCharArray()) {
                map[i][c - 'a']++;
            }
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < A.length; j++) {
                min = Math.min(min, map[j][i]);
                if (min == 0) {
                    break;
                }
            }
            if (min > 0) {
                for (int j = 0; j < min; j++) {
                    list.add(String.valueOf((char) ('a' + i)));
                }
            }
        }
        return list;
    }
}
