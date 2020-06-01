package solution_1465;

import java.util.Arrays;

public class Solution {

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int hMax = 0;
        Arrays.sort(horizontalCuts);
        int pre = 0;
        for (int cut : horizontalCuts) {
            int len = cut - pre;
            hMax = Math.max(hMax, len);
            pre = cut;
        }
        hMax = Math.max(h - pre, hMax);

        int vMax = 0;
        Arrays.sort(verticalCuts);
        pre = 0;
        for (int cut : verticalCuts) {
            int len = cut - pre;
            vMax = Math.max(vMax, len);
            pre = cut;
        }
        vMax = Math.max(w - pre, vMax);

        return (int)(((long)hMax * vMax) % 1_000_000_007);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int s = solution.maxArea(5, 4, new int[] {3, 1}, new int[] {1});
        System.out.println(s);
    }
}
