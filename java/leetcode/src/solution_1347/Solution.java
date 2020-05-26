package solution_1347;

public class Solution {

    public int minSteps(String s, String t) {
        int[] arr = new int[26];
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        for (int i = 0; i < sArr.length; i++) {
            arr[sArr[i] - 'a']++;
            arr[tArr[i] - 'a']--;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] > 0) {
                count = count + arr[i];
            }
        }
        return count;
    }
}
