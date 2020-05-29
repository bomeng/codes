package solution_985;

import java.util.Arrays;

public class Solution {

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int evenTotal = 0;
        for (int a : A) {
            if (a % 2 == 0) {
                evenTotal += a;
            }
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int a = A[query[1]];
            int b = query[0];
            int c = a + b;
            if (a % 2 == 0) {
                if (b % 2 == 0) {
                    evenTotal += b;
                } else {
                    evenTotal -= a;
                }
            } else {
                if (b % 2 != 0) {
                    evenTotal += c;
                }
            }
            A[query[1]] = c;
            result[i] = evenTotal;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.sumEvenAfterQueries(
                new int[] {-1, 3, -3, 9, -6, 8, -5},
                new int[][] {{-5, 1}, {10, 2}, {-6, 3}, {3, 2}, {9, 5}, {7, 5}, {8, 0}})));
    }
}
