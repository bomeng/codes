package solution_941;

public class Solution {

    public boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }
        if (A[1] <= A[0]) {
            return false;
        }
        int a = A[1];
        boolean increase = true;
        for (int i = 2; i < A.length; i++) {
            if (A[i] == a) {
                return false;
            } else if (A[i] < a && increase) {
                increase = false;
            } else if (A[i] > a && !increase) {
                return false;
            }
            a = A[i];
        }
        return !increase;
    }
}
