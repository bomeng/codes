package solution_343;

public class Solution {

    public int integerBreak(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        double ans = 0;
        if (n % 3 == 0) {
            ans = (int) Math.pow(3, n / 3);
        } else if (n % 3 == 1) {
            ans = 4 * Math.pow(3, n / 3 - 1);
        } else {
            ans = 2 * Math.pow(3, n / 3);
        }
        return (int)ans;
    }
}
