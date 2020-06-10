package solution_665;

public class Solution {

    public boolean checkPossibility(int[] nums) {
        int idx = -1;
        boolean findBreakPoint = false;

        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] < nums[i - 1]) {
                if (findBreakPoint) {
                    return false;
                }
                findBreakPoint = true;
                idx = i;
            }
        }

        if (!findBreakPoint) {
            return true;
        }
        int left = nums[idx - 1], right = Integer.MAX_VALUE;
        if (idx < nums.length - 1) {
            right = nums[idx + 1];
        }

        return right >= left || idx == 1 || nums[idx - 2] <= nums[idx];
    }
}
