package solution_1438;

public class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int i = 0;
        int j = 0;
        int length = 0;
        int max_index = 0;
        int min_index = 0;
        while (i < nums.length && j < nums.length) {
            int max = nums[i];
            int min = nums[i];
            max_index = i;
            min_index = i;
            j = i;
            while (j < nums.length) {
                if (nums[j] >= max) {
                    max = nums[j];
                    max_index = j;
                }
                if (nums[j] <= min) {
                    min = nums[j];
                    min_index = j;
                }
                if (Math.abs(max - min) > limit) {
                    i = Math.min(min_index, max_index) + 1;
                    break;
                } else {
                    length = Math.max(length, j - i + 1);
                    j = j + 1;
                }
            }
        }
        return length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestSubarray(new int[] {8, 2, 4, 7}, 4));
    }
}
