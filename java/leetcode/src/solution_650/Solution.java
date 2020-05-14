package solution_650;

public class Solution {
    public int minSteps(int n) {
        int sum = 0, p = 2;
        while (n > 1) {
            while (n % p == 0) {
                sum += p;
                n /= p;
            }
            p++;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minSteps(3));
    }
}
