package solution_1353;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int maxEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[1]));

        Set<Integer> attendedDays = new HashSet<>();
        int ans = 0;
        for (int[] event : events) {
            for (int day = event[0]; day <= event[1]; day++) {
                if (!attendedDays.contains(day)) {
                    ans++;
                    attendedDays.add(day);
                    break;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxEvents(new int[][] {
                        {27, 27},
                        {8, 10},
                        {9, 11},
                        {20, 21},
                        {25, 29},
                        {17, 20},
                        {12, 12},
                        {12, 12},
                        {10, 14},
                        {7, 7},
                        {6, 10},
                        {7, 7},
                        {4, 8},
                        {30, 31},
                        {23, 25},
                        {4, 6},
                        {17, 17},
                        {13, 14},
                        {6, 9},
                        {13, 14}
                }
        ));
    }
}
