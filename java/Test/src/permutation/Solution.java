package permutation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
 * Given a Long number N, write a function that calculates the highest number lower than N obtained permuting only one digit of N.
 * If no permutation exists to return a lower value, return N.
 * Example:
 * N = 153
 * permuteToPrevious(N) = 135
 * N = 12345
 * permuteToPrevious(N) = 12345
 *
 * Please note:
 *   Use Long as type. Digits can repeat
 */

class Data {

    static final List<Long> exampleData = new ArrayList<>();

    static {
        exampleData.add(9L);
        exampleData.add(153L);
        exampleData.add(12345L);
        exampleData.add(92145112L);
        exampleData.add(54321L);
        exampleData.add(295468L);
        /*
         * Example output for this data:
            135
            12345
            92142115
            54312
            294568
         */
    }
}

/*
 * Coderpad uses a static Solution.main method as its entry point.
 * See https://coderpad.io/languages#java for available libraries.
 */
class Solution {

    public static void main(final String[] args) {
        Solution s = new Solution();
       int[] b= s.solution(new int[] {1, 2, 3, 4, 5}, 2);
       for (int i : b) {
           System.out.print(i + " ");
       }
    }

    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        int len = A.length;
        int k = K % len;
        int[] temp = new int[k];
        System.arraycopy(A, 0, temp, 0, k);
        System.arraycopy(A, k, A, 0, len - k);
        System.out.println();
        System.arraycopy(temp, 0, A, len - k, k);
        return A;
    }

    private static Long permuteToPrevious(Long input) {
        char[] arr = String.valueOf(input).toCharArray();

        for (int left = arr.length - 2; left >= 0; left--) {
            for (int right = arr.length - 1; right >= left + 1; right--) {
                if (arr[left] > arr[right]) {
                    char temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                    return Long.parseLong(String.valueOf(arr));
                }
            }
        }
        return input;
    }
}
