package solution_1456;

public class Solution {

    public int maxVowels(String s, int k) {
        int count = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < k; i++) {
            if (isVowel(arr[i])) {
                count++;
            }
        }
        int max = count;
        int start = 0;
        int end = k;
        while (end < arr.length) {
            if (isVowel(arr[end])) {
                count++;
            }
            if (isVowel(arr[start])) {
                count--;
            }
            max = Math.max(max, count);
            start++;
            end++;
        }
        return max;
    }

    private boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxVowels("leetcode", 3));
    }
}
