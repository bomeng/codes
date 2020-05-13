package solution_402;

import java.util.Stack;

public class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if (len == k) {
            return "0";
        }

        int i = 0;
        Stack<Character> stack = new Stack<>();
        while (i < len) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                stack.pop();
                k = k - 1;
            }
            stack.push(num.charAt(i));
            i = i + 1;
        }
        while (k > 0) {
            stack.pop();
            k = k - 1;
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        while (builder.length() > 1 && builder.charAt(builder.length() - 1) == '0') {
            builder.deleteCharAt(builder.length() - 1);
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeKdigits("1432219", 3));
    }
}
