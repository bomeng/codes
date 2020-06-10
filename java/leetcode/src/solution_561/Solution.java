package solution_561;

import java.util.Arrays;

public class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);

        int min = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            min = min + nums[i];
        }

        return min;
    }
}
