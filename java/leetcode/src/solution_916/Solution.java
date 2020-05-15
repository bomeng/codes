package solution_916;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> wordSubsets(String[] A, String[] B) {
        int[] arr = new int[26];
        for (String str : B) {
            int[] temp = new int[26];
            for (Character c : str.toCharArray()) {
                int index = c - 'a';
                temp[index]++;
                if (temp[index] > arr[index]) {
                    arr[index] = temp[index];
                }
            }
        }

        List<String> result = new ArrayList<>();
        for (String str : A) {
            int[] temp = new int[26];
            for (Character c : str.toCharArray()) {
                int index = c - 'a';
                temp[index]++;
            }
            boolean valid = true;
            for (int i = 0; i < 26; i++) {
                if (temp[i] < arr[i]) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                result.add(str);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.wordSubsets(new String[] {"amazon", "apple", "facebook", "google", "leetcode"},
                new String[] {"e", "o"}));
    }
}
