package solution_230;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {

    public int kthSmallest(TreeNode root, int k) {
        int[] result = new int[2];
        dfs(root, k, result);
        return result[1];
    }

    private void dfs(TreeNode node, int k, int[] result) {
        if (node == null) {
            return;
        }
        dfs(node.left, k, result);
        result[0] = result[0] + 1;
        if (result[0] == k) {
            result[1] = node.val;
            return;
        }
        dfs(node.right, k, result);
    }
}
