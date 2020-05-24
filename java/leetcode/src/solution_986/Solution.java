package solution_986;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        PriorityQueue<int[]> queueA = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> queueB = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        queueA.addAll(Arrays.asList(A));
        queueB.addAll(Arrays.asList(B));

        List<int[]> list = new ArrayList<>();
        while (!queueA.isEmpty() && !queueB.isEmpty()) {
            if (queueA.peek()[0] < queueB.peek()[0]) {
                int[] a = queueA.poll();
                int[] b = queueB.peek();
                if (a[1] >= b[0]) {
                    if (a[1] <= b[1]) {
                        list.add(new int[] {b[0], a[1]});
                    } else {
                        b = queueB.poll();
                        list.add(new int[] {b[0], b[1]});
                        queueA.offer(new int[] {b[1], a[1]});
                    }
                }
            } else {
                int[] a = queueA.peek();
                int[] b = queueB.poll();
                if (b[1] >= a[0]) {
                    if (b[1] <= a[1]) {
                        list.add(new int[] {a[0], b[1]});
                    } else {
                        a = queueA.poll();
                        list.add(new int[] {a[0], a[1]});
                        queueB.offer(new int[] {a[1], b[1]});
                    }
                }
            }
        }
        return list.toArray(new int[list.size()][2]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] result = solution.intervalIntersection(new int[][] {{4, 6}, {7, 8}, {10, 17}}, new int[][] {{5, 10}});
        System.out.println(Arrays.toString(result));
    }
}
