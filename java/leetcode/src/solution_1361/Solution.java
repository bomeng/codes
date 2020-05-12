package solution_1361;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        // find the root
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                queue.offer(i);
                break;
            }
            if (rightChild[i] != -1) {
                queue.offer(i);
                break;
            }
        }

        if (queue.size() == 0) {
            return true;
        }

        while (!queue.isEmpty()) {
            Integer item = queue.poll();
            visited.add(item);

            if (leftChild[item] != -1) {
                if (visited.contains(leftChild[item]) || queue.contains(leftChild[item])) {
                    return false;
                }
                queue.offer(leftChild[item]);
            }
            if (rightChild[item] != -1) {
                if (visited.contains(rightChild[item]) || queue.contains(rightChild[item])) {
                    return false;
                }
                queue.offer(rightChild[item]);
            }
        }
        return visited.size() >= n;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.validateBinaryTreeNodes(1, new int[] {-1}, new int[] {-1}));
        System.out.println(solution.validateBinaryTreeNodes(4, new int[] {1, -1, 3, -1}, new int[] {2, -1, -1, -1}));
        System.out.println(solution.validateBinaryTreeNodes(4, new int[] {1, -1, 3, -1}, new int[] {2, 3, -1, -1}));
        System.out.println(solution.validateBinaryTreeNodes(2, new int[] {1, 0}, new int[] {-1, -1}));
        System.out.println(solution.validateBinaryTreeNodes(6, new int[] {1, -1, -1, 4, -1, -1}, new int[] {2, -1, -1, 5, -1, -1}));
        System.out.println(solution.validateBinaryTreeNodes(2, new int[] {-1, 0}, new int[] {-1, -1}));
    }
}
