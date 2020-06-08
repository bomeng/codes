package solution_365;

public class Solution {

    public boolean canMeasureWater(int x, int y, int z) {
        int min = Math.min(x, y);
        int max = Math.max(x, y);
        if (z == 0) {
            return true;
        }
        if (min == 0) {
            return max == z;
        }
        if (min + max == z) {
            return true;
        }
        if (max + min < z) {
            return false;
        }

        int con1 = 0;
        int con2 = max;
        while (con1 + con2 > 0) {
            if (con1 + con2 == z) {
                return true;
            }
            int remain = min - con1;
            con1 = Math.min(min, con2);
            con2 = Math.max(0, con2 - remain);
            if (con1 + con2 == z) {
                return true;
            }
            if (con1 == min) {
                con1 = 0;
            } else if (con2 == 0) {
                con2 = max;
            }
        }

        return false;
    }
}
