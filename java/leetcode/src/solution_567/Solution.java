package solution_567;

public class Solution {

    public boolean checkInclusion(String s1, String s2) {
        int[] s1Array = new int[26];
        for (char c : s1.toCharArray()) {
            s1Array[c - 'a']++;
        }

        int start = 0;
        int end = 0;
        char[] s2Array = s2.toCharArray();
        while (end < s2Array.length) {
            if (s1Array[s2Array[end] - 'a'] > 0) {
                s1Array[s2Array[end] - 'a']--;
                end++;
                if (end - start == s1.length()) {
                    return true;
                }
            } else if (end == start) {
                start++;
                end++;
            } else {
                s1Array[s2Array[start] - 'a']++;
                start++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean s = solution.checkInclusion("ab", "eidbaooo");
        System.out.println(s);
    }
}
