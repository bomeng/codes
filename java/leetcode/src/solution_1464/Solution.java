package solution_1464;

import java.util.Arrays;
import java.util.Random;

public class Solution {

    public int maxProduct(int[] nums) {
        int[] a = select(nums, 2);
        return (a[0] - 1) * (a[1] - 1);
    }

    private int partition(int[] arr, int left, int right, int pivot) {
        int pivotVal = arr[pivot];
        swap(arr, pivot, right);
        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (arr[i] > pivotVal) {
                swap(arr, i, storeIndex);
                storeIndex++;
            }
        }
        swap(arr, right, storeIndex);
        return storeIndex;
    }

    private int[] select(int[] arr, int n) {
        int left = 0;
        int right = arr.length - 1;
        Random rand = new Random();
        while (right >= left) {
            int pivotIndex = partition(arr, left, right, rand.nextInt(right - left + 1) + left);
            if (pivotIndex == n - 1) {
                return Arrays.copyOf(arr, n);
            } else if (pivotIndex < n - 1) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }
        return null;
    }

    private void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
}
