package solution_1022;

class TreeNode {

    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {

    public int sumRootToLeaf(TreeNode root) {
        int[] s = new int[2];
        helper(root, s);

        return s[1];
    }

    private void helper(TreeNode root, int[] s) {
        if (root == null) {
            return;
        }
        s[0] = s[0] << 1 + root.val;
        if (root.left == null && root.right == null) {
            s[1] = s[1] + s[0];
        }
        helper(root.left, s);
        helper(root.right, s);
        s[0] = s[0] >> 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}
