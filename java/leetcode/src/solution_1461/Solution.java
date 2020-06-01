package solution_1461;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> set = new HashSet<>();
        int target = (int) Math.pow(2, k);
        for (int i = 0, n = s.length() - k; i <= n; i++) {
            set.add(s.substring(i, i + k));
            if (set.size() == target) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hasAllCodes("00110110", 2));
    }
}
