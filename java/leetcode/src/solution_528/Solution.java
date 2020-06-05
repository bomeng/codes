package solution_528;

import java.util.Random;

public class Solution {

    int[] weights;

    public Solution(int[] w) {
        weights = new int[w.length];
        weights[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            weights[i] = w[i] + weights[i - 1];
        }

    }
    //weights is the prefix sum array of w


    public int pickIndex() {
        int sum = weights[weights.length - 1];
        Random rand = new Random();
        int p = rand.nextInt(sum);
        //this generates a random number from 1 to sum
        int l = 0, r = weights.length - 1;
        int index = -1;
        //binary search to find the upper bound of p in prefix sum array
        while (l <= r) {
            int m = (l + r) / 2;
            if (p < weights[m]) {
                index = m;
                r = m - 1;

            } else {
                l = m + 1;
            }

        }
        return index;

    }
}
