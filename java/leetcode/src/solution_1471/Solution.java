package solution_1471;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {

    public int[] getStrongest(int[] arr, int k) {
        // find the median
        Arrays.sort(arr);
        int median = arr[(arr.length - 1) / 2];
        return IntStream.of(arr).boxed().sorted((a, b) -> {
            int x = Math.abs(a - median);
            int y = Math.abs(b - median);
            return x != y ? y - x : b - a;
        }).limit(k).mapToInt(i -> i).toArray();
    }
}
