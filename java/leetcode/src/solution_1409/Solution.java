package solution_1409;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] processQueries(int[] queries, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            list.add(i);
        }

        int[] result = new int[queries.length];
        int j = 0;
        for (int i: queries) {
            int pos = list.indexOf(i);
            result[j] = pos;
            j = j + 1;
            Integer item = list.remove(pos);
            list.add(0, item);
        }

        return result;
    }
}
