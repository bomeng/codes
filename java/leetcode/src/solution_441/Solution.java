package solution_441;

public class Solution {

    public int arrangeCoins(int n) {
        long low = 0;
        long high = n;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long s = mid * (mid + 1) / 2;
            if (s <= n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (int) (low - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.arrangeCoins(
                1804289383));
    }
}
