package solution_792;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int numMatchingSubseq(String S, String[] words) {
        int count = 0;
        char[] arrS = S.toCharArray();
        Map<String, Boolean> map = new HashMap<>();
        for (String word : words) {
            boolean value;
            if (map.containsKey(word)) {
                value = map.get(word);
            } else {
                value = isSub(arrS, word.toCharArray(), arrS.length, word.length());
                map.put(word, value);
            }
            if (value) {
                count++;
            }
        }
        return count;
    }

    private boolean isSub(char[] arrS, char[] wordArr, int s, int w) {
        if (w == 0) {
            return true;
        }
        if (s < w) {
            return false;
        }
        if (arrS[s - 1] == wordArr[w - 1]) {
            return isSub(arrS, wordArr, s - 1, w - 1);
        } else {
            return isSub(arrS, wordArr, s - 1, w);
        }
    }
}
