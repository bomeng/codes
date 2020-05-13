package solution_1362;

import java.util.Arrays;

public class Solution {

    public int[] closestDivisors(int num) {
        int target1 = num + 1;
        int target2 = num + 2;

        for (int i = (int) Math.sqrt(target2); i >= 1; i--) {
            int mod = target1 % i;
            if (mod == 0) {
                return new int[] {i, target1 / i};
            }
            if (mod == i - 1) {
                return new int[] {i, target2 / i};
            }
        }
        return null; // will never happen
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.closestDivisors(123)));
    }
}
