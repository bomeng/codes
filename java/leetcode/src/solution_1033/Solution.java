package solution_1033;

public class Solution {

    public int[] numMovesStones(int a, int b, int c) {
        int low = Math.min(a, Math.min(b, c));
        int high = Math.max(a, Math.max(b, c));
        int mid = a + b + c - low - high;
        int min = low + 1 == mid && mid + 1 == high ? 0 : mid - low <= 2 || high - mid <= 2 ? 1 : 2;
        int max = mid - low - 1 + high - mid - 1;
        return new int[] {min, max};
    }
}
