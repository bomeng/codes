package solution_1021;

public class Solution {

    public String removeOuterParentheses(String S) {
        int bal = 0;
        int ind = 0;
        StringBuilder result = new StringBuilder();
        char[] arr = S.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                bal += 1;
            } else {
                bal -= 1;
            }
            if (bal == 0) {
                result.append(S.substring(ind + 1, i));
                ind = i + 1;
            }
        }
        return result.toString();
    }
}
