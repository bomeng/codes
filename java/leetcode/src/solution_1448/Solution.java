package solution_1448;

class TreeNode {

    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {

    public int goodNodes(TreeNode root) {
        int[] values = {root.val, 0};
        dfs(root, values);

        return values[1];
    }

    private void dfs(TreeNode node, int[] values) {
        if (node == null) {
            return;
        }
        int current = values[0];
        if (node.val >= values[0]) {
            values[0] = Math.max(values[0], node.val);
            values[1]++;
        }
        dfs(node.left, values);
        dfs(node.right, values);
        values[0] = current;
    }
}
