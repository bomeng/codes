package solution_275;

public class Solution {
    public int hIndex(int[] citations) {
        int length = citations.length;

        int low = 0, high = length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (length - mid > citations[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }

        return length - low;
    }
}
