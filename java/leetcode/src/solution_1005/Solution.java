package solution_1005;

import java.util.PriorityQueue;

public class Solution {

    public int largestSumAfterKNegations(int[] A, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(A.length, (a, b) -> a - b);
        int sum = 0;
        for (int a : A) {
            sum = sum + a;
            queue.offer(a);
        }
        for (int i = 0; i < K; i++) {
            int j = queue.poll();
            sum = sum - j - j;
            queue.offer(-j);
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestSumAfterKNegations(new int[] {3, -1, 0, 2}, 3));
    }
}
