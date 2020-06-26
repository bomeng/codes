package solution_988;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public String smallestFromLeaf(TreeNode root) {
        String[] result = new String[1];
        helper(root, new StringBuilder(), result);
        return result[0];
    }

    private void helper(TreeNode node, StringBuilder builder, String[] result) {
        if (node == null) {
            return;
        }
        builder.append((char) (node.val + 'a'));
        if (node.left == null && node.right == null) {  //it's leaf node
            String word = builder.reverse().toString();
            if (result[0] == null || word.compareTo(result[0]) < 0) {
                result[0] = word;
            }
            builder.reverse();
        } else {
            helper(node.left, builder, result);
            helper(node.right, builder, result);
        }
        builder.deleteCharAt(builder.length() - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        String s = solution.smallestFromLeaf(n1);
        System.out.println(s);
    }
}
