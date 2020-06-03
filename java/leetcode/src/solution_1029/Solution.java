package solution_1029;

import java.util.Arrays;

public class Solution {

    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> (a[1] - a[0]) - (b[1] - b[0]));

        int sum = 0;
        int len = costs.length / 2;
        for (int i = 0; i < costs.length; i++) {
            sum = sum + (i < len ? costs[i][1] : costs[i][0]);
        }
        return sum;
    }
}
