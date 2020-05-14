package solution_456;

public class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        int min = nums[0];
        int n = nums.length;
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > min) {
                for (int j = i + 1; j < n; j++) {
                    if (nums[j] < nums[i] && nums[j] > min) {
                        return true;
                    }
                }
            }

            min = Math.min(min, nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.find132pattern(new int[]{1, 2, 3, 4}));
        System.out.println(solution.find132pattern(new int[]{3, 1, 4, 2}));
    }
}
