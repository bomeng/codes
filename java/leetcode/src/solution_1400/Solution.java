package solution_1400;

public class Solution {
    public boolean canConstruct(String s, int k) {
        char[] charArray = s.toCharArray();
        if (charArray.length < k) {
            return false;
        }

        int[] arr = new int[26];
        for (char c: charArray) {
            int index = c - 'a';
            arr[index] += 1;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] % 2 == 1) {
                count++;
                if (count > k) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canConstruct("annabelle", 2));
    }
}
