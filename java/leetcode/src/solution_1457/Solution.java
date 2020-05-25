package solution_1457;

class TreeNode {

    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {

    public int pseudoPalindromicPaths(TreeNode root) {
        int[] map = new int[10];
        dfs(root, map);
        return map[0];
    }

    private void dfs(TreeNode root, int[] map) {
        if (root == null) {
            return;
        }
        int value = root.val;
        map[value]++;
        if (root.left == null && root.right == null) {
            if (isPalindrome(map)) {
                map[0]++;
            }
        }
        dfs(root.left, map);
        dfs(root.right, map);
        map[value]--;
    }

    private boolean isPalindrome(int[] map) {
        int count = 0;
        for (int i = 1; i <= 9; i++) {
            if (map[i] % 2 == 1) {
                count++;
            }
        }
        return count <= 1;
    }
}
