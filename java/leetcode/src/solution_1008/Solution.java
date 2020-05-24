package solution_1008;

class TreeNode {

    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {

    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, 0, preorder.length - 1);
    }

    public TreeNode bstFromPreorder(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[start]);
        int endIndex = Integer.MIN_VALUE;
        int startIndex = Integer.MAX_VALUE;
        for (int i = start + 1; i <= end; i++) {
            if (preorder[i] < preorder[start]) {
                endIndex = i;
            } else {
                startIndex = i;
                break;
            }
        }
        node.left = bstFromPreorder(preorder, start + 1, endIndex);
        node.right = bstFromPreorder(preorder, startIndex, end);

        return node;
    }
}
