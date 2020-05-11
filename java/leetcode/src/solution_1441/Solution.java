package solution_1441;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> buildArray(int[] target, int n) {
        int i = 0;
        int j = 1;
        List<String> list = new ArrayList<>();
        while (i < target.length) {
            if (j == target[i]) {
                list.add("Push");
                j = j + 1;
                i = i + 1;
            } else {
                list.add("Push");
                list.add("Pop");
                j = j + 1;
            }
        }
        return list;
    }
}
