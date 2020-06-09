package solution_914;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private int gcd(int i, int j) {
        return i == 0 ? j : gcd(j % i, i);
    }

    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : deck) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int gcd = 0;
        for (int value : map.values()) {
            if (gcd == 0) {
                gcd = value;
            } else {
                gcd = gcd(gcd, value);
                if (gcd == 1) {
                    return false;
                }
            }
        }
        return gcd >= 2;
    }
}
