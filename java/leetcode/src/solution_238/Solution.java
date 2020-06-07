package solution_238;

public class Solution {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        output[0] = 1;
        for (int i = 1; i < n; i++) {
            output[i] = nums[i - 1] * output[i - 1];
        }
        int right_product = 1;
        for (int i = n - 1; i >= 0; i--) {
            output[i] *= right_product;
            right_product *= nums[i];
        }
        return output;
    }
}
