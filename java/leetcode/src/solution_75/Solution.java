package solution_75;

public class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid = low;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low = low + 1;
                mid = mid + 1;
            } else if (nums[mid] == 1) {
                mid = mid + 1;
            } else {
                swap(nums, mid, high);
                high = high - 1;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
