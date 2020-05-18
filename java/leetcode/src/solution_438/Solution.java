package solution_438;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        int[] pArray = new int[26];
        for (char c : p.toCharArray()) {
            pArray[c - 'a']++;
        }

        List<Integer> result = new ArrayList<>();
        char[] sArray = s.toCharArray();
        int start = 0;
        int end = 0;
        while (end < sArray.length) {
            if (pArray[sArray[end] - 'a'] > 0) {
                pArray[sArray[end] - 'a']--;
                end++;
                if (end - start == p.length()) {
                    result.add(start);
                }
            } else if (end == start) {
                start++;
                end++;
            } else {
                pArray[sArray[start] - 'a']++;
                start++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findAnagrams("abab", "ab"));
    }
}
