package solution_1405;


import java.util.PriorityQueue;

public class Solution {

    public String longestDiverseString(int a, int b, int c) {
        int[][] arr = new int[3][2];
        arr[0][0] = 0;
        arr[0][1] = a;
        arr[1][0] = 1;
        arr[1][1] = b;
        arr[2][0] = 2;
        arr[2][1] = c;
        PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        for (int[] ints : arr) {
            if (ints[1] > 0) {
                queue.add(ints);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            if (result.length() <= 1) {
                int[] first = queue.poll();
                result.append((char) ('a' + first[0]));
                first[1] = first[1] - 1;
                if (first[1] > 0) {
                    queue.offer(first);
                }
            } else {
                String end = result.substring(result.length() - 2);
                int[] first = queue.poll();
                String newEnd = end + (char) ('a' + first[0]);
                if (newEnd.equals("aaa") || newEnd.equals("bbb") || newEnd.equals("ccc")) {
                    if (!queue.isEmpty()) {
                        int[] second = queue.poll();
                        result.append((char) ('a' + second[0]));
                        second[1] = second[1] - 1;
                        if (second[1] > 0) {
                            queue.offer(second);
                        }
                        queue.offer(first);
                    } else {
                        break;
                    }
                } else {
                    result.append((char) ('a' + first[0]));
                    first[1] = first[1] - 1;
                    if (first[1] > 0) {
                        queue.offer(first);
                    }
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.longestDiverseString(7, 1, 0);
        System.out.println(s);
    }
}
