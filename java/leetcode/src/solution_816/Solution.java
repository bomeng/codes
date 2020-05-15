package solution_816;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> ambiguousCoordinates(String S) {
        String str = S.substring(1, S.length() - 1);
        List<String> result = new ArrayList<>();
        for (int i = 1; i < str.length(); i++) {
            String a = str.substring(0, i);
            String b = str.substring(i);
            List<String> listA = insertDot(a);
            List<String> listB = insertDot(b);
            for (String itemA : listA) {
                for (String itemB : listB) {
                    result.add("(" + itemA + ", " + itemB + ")");
                }
            }
        }
        return result;
    }

    private List<String> insertDot(String str) {
        String output = null;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (i == 0) {
                output = str;
            } else {
                output = str.substring(0, i) + "." + str.substring(i);
            }
            if (isValid(output)) {
                list.add(output);
            }
        }
        return list;
    }

    private boolean isValid(String str) {
        return !(str.contains(".") && str.endsWith("0") || str.startsWith("0") && str.length() > 1 && !str.startsWith("0."));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.ambiguousCoordinates("(123)"));
    }
}
