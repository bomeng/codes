package solution_1343;

public class Solution {

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int[] sumArray = new int[arr.length - k + 1];
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum = sum + arr[i];
        }
        sumArray[0] = sum;
        for (int i = k; i < arr.length; i++) {
            sumArray[i - k + 1] = sumArray[i - k] + arr[i] - arr[i - k];

        }
        int count = 0;
        int s = k * threshold;
        for (int i = 0; i < arr.length - k + 1; i++) {
            if (sumArray[i] >= s) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numOfSubarrays(new int[] {2, 2, 2, 2, 5, 5, 5, 8}, 3, 4));
    }
}
