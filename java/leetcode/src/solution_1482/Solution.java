package solution_1482;

public class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * (long) k > bloomDay.length) {
            return -1;
        }
        //get maximum value in arr  = get maximum day
        int r = 0;
        for (int num : bloomDay) {
            r = Math.max(r, num);
        }
        int l = 1;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (helper(bloomDay, mid, m, k)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return helper(bloomDay, l, m, k) ? l : -1;
    }

    //if current day is 5 => compare 5 with each num in arr, and get maximum possible bouquets, compare result with m
    private boolean helper(int[] arr, int day, int m, int k) {
        int count = 0;
        int l = 0, r = 0;
        for (; r < arr.length; r++) {
            if (arr[r] > day) {
                count += (r - l) / k;
                l = r + 1;
            }
        }
        count += (r - l) / k;
        return count >= m;
    }
}
