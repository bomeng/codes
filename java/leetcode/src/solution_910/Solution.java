package solution_910;

import java.util.Arrays;

public class Solution {

    public int smallestRangeII(int[] A, int K) {
        if (A.length == 1) {
            return 0;
        }
        Arrays.sort(A);
        int res = A[A.length - 1] - A[0];
        for (int i = 1; i < A.length; i++) {
            int max = Math.max(A[i - 1] + K, A[A.length - 1] - K);
            int min = Math.min(A[0] + K, A[i] - K);
            res = Math.min(res, max - min);
        }
        return res;
    }
}
