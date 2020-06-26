package solution_129;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public int sumNumbers(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        int[] values = new int[2]; // value[0] is current sum, value[1] is the total
        helper(root, values);
        return values[1];
    }

    private void helper(TreeNode root, int[] values) {
        if (root == null) {
            return;
        }
        int value = values[0] * 10 + root.val;
        if (root.left == null && root.right == null) {
            values[1] = values[1] + value;
            return;
        }
        values[0] = value;
        helper(root.left, values);
        values[0] = value;
        helper(root.right, values);
        values[0] = values[0] / 10;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode n4 = new TreeNode(4);
        TreeNode n9 = new TreeNode(9);
        TreeNode n0 = new TreeNode(0);
        TreeNode n5 = new TreeNode(5);
        TreeNode n1 = new TreeNode(1);
        n4.left = n9;
        n4.right = n0;
        n9.left = n5;
        n9.right = n1;
        int s = solution.sumNumbers(n4);
        System.out.println(s);
    }
}
