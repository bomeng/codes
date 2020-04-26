import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class Solution56 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null) {
            return null;
        }
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        Stack<int[]> stack = new Stack<>();
        for (int[] interval: intervals) {
            if (stack.isEmpty()) {
                stack.push(interval);
            } else {
                int[] pre = stack.peek();
                if (pre[1] < interval[0]) {
                    stack.push(interval);
                } else if (pre[1] < interval[1]) {
                    pre = stack.pop();
                    pre[1] = interval[1];
                    stack.push(pre);
                }
            }
        }

        return stack.toArray(new int[stack.size()][2]);
    }


    public static void main(String[] args) {
        Solution56 solution56 = new Solution56();
        int[][] result = solution56.merge(new int[][] {{2,6},{8,10},{15,18}, {1,3}});
        for (int[] interval: result) {
            System.out.println(interval[0] + " " + interval[1]);
        }
    }
}
