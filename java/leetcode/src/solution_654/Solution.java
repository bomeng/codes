package solution_654;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int max_index = start;
        int max = nums[start];
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                max_index = i;
            }
        }
        // Create the root
        TreeNode root = new TreeNode(nums[max_index]);
        root.left = constructMaximumBinaryTree(nums, start, max_index - 1);
        root.right = constructMaximumBinaryTree(nums, max_index + 1, end);
        return root;
    }
}
