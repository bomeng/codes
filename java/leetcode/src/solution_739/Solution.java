package solution_739;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int t = stack.pop();
                result[t] = i - t;
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.dailyTemperatures(new int[] {73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(Arrays.toString(result));
    }
}
