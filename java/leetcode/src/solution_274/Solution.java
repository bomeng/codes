package solution_274;

import java.util.Arrays;

public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        int i = 0;
        while (i < citations.length && citations.length - i > citations[i]) {
            i++;
        }

        return citations.length - i;
    }
}
