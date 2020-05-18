package solution_438;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] arr = new int[26];
        for (char c: p.toCharArray()) {
            arr[c - 'a']++;
        }

        List<Integer> result = new ArrayList<>();
        char[] sArr = s.toCharArray();
        for (int i = 0; i <= s.length() - p.length(); i++) {
            int[] copyArr = arr.clone();
            boolean isAnagrams = true;
            for (int j = i; j < i + p.length(); j++) {
                int index  = sArr[j] - 'a';
                if (copyArr[index] > 0) {
                    copyArr[index]--;
                } else {
                    isAnagrams = false;
                    break;
                }
            }
            if (isAnagrams) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findAnagrams("abab", "ab"));
    }
}
