package solution_1018;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> result = new ArrayList<>();
        int sum = 0;
        for (int value : A) {
            sum = sum << 1 | value;
            result.add(sum % 5 == 0);
            sum = sum % 5;
        }
        return result;
    }
}
