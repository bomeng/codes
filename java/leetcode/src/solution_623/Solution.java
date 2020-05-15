package solution_623;


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

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        return addOneRow(root, v, d, true);
    }

    private TreeNode addOneRow(TreeNode root, int v, int d, boolean isLeft) {
        if (d == 1) {
            TreeNode t = new TreeNode(v);
            if (root != null) {
                if (isLeft) {
                    t.left = root;
                } else {
                    t.right = root;
                }

            }
            return t;
        } else if (root != null) {
            root.left = addOneRow(root.left, v, d - 1, true);
            root.right = addOneRow(root.right, v, d - 1, false);
            return root;
        }
        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode n4 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2);
        TreeNode n6 = new TreeNode(6);
        TreeNode n3 = new TreeNode(3);
        TreeNode n1 = new TreeNode(1);
        TreeNode n5 = new TreeNode(5);
        n4.left = n2;
        n4.right = n6;
        n2.left = n3;
        n2.right = n1;
        n6.left = n5;
        System.out.println(solution.addOneRow(n4, 1, 2));
    }
}
