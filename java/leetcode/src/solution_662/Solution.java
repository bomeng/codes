package solution_662;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Map<TreeNode, Integer> map = new HashMap<>();
        map.put(root, 0);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int width = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int left = 0;
            int right = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int index = map.get(node);
                if (i == 0) {
                    left = index;
                }
                if (i == size - 1) {
                    right = index;
                    width = Math.max(width, right - left + 1);
                }
                if (node.left != null) {
                    map.put(node.left, 2 * index + 1);
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    map.put(node.right, 2 * index + 2);
                    queue.offer(node.right);
                }
            }
        }
        return width;
    }
}
