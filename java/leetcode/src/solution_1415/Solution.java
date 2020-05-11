package solution_1415;

import com.sun.tools.javac.util.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public String getHappyString(int n, int k) {
        List<String> result = new ArrayList<>();
        helper(result, new char[n], 0, n);
        return k <= result.size() ? result.get(k - 1) : "";
    }

    private void helper(List<String> result, char[] sub, int index, int n) {
        if (index == n) {
            result.add(String.valueOf(sub));
            return;
        }

        for (char j = 'a'; j <= 'c'; j++) {
            if (index == 0 || j != sub[index - 1]) {
                sub[index] = j;
                helper(result, sub, index + 1, n);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.getHappyString(10, 100);
        System.out.println(s.equals("abacbabacb"));
    }
}
