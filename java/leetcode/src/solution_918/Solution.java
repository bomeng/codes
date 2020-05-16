package solution_918;

public class Solution {
    private int kadane (int arr[]){
        int curSum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            curSum = curSum + arr[i];
            curSum = Math.max(curSum, arr[i]);
            max = Math.max(max, curSum);
        }
        return max;
    }

    public int maxSubarraySumCircular(int[] A) {
        int max_kadane = kadane(A);
        int max_wrap  =  0;
        for (int i = 0; i < A.length; i++)
        {
            max_wrap += A[i]; // Calculate array-sum
            A[i] = -A[i];  // invert the array (change sign)
        }
        max_wrap = max_wrap + kadane(A);
        return Math.max(max_wrap, max_kadane);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSubarraySumCircular(new int[]{-2, -3, -1}));
        // System.out.println(solution.maxSubarraySumCircular(new int[]{5, -3, 5}));
    }
}
