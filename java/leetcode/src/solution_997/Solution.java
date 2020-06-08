package solution_997;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int findJudge(int N, int[][] trust) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            set.add(i);
        }
        for (int[] i : trust) {
            set.remove(i[0]);
        }
        if (set.size() != 1) {
            return -1;
        }
        int j = 0;
        for (int i : set) {
            j = i;
        }
        set.clear();
        for (int[] i : trust) {
            if (i[1] == j) {
                set.add(i[0]);
            }
        }
        return set.size() == N - 1 ? j : -1;
    }
}
