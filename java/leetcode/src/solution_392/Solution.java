package solution_392;

public class Solution {

    public boolean isSubsequence(String s, String t) {
        return isSubsequence(s.toCharArray(), t.toCharArray(), s.length(), t.length());
    }

    public boolean isSubsequence(char[] sArr, char[] tArr, int s, int t) {
        if (s == 0) {
            return true;
        }
        if (t < s) {
            return false;
        }
        if (sArr[s - 1] == tArr[t - 1]) {
            return isSubsequence(sArr, tArr, s - 1, t - 1);
        } else {
            return isSubsequence(sArr, tArr, s, t - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isSubsequence("b", "c"));
    }
}
