package solution_1447;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> simplifiedFractions(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                int k = gcd(i, j);
                if (k == 1) {
                    list.add(j + "/" + i);
                }
            }
        }
        return list;
    }

    private int gcd(int i, int j) {
        if (j == 0) {
            return i;
        }
        return gcd(j, i % j);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.simplifiedFractions(2));
    }
}
