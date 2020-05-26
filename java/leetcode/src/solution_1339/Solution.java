package solution_1339;

import java.util.HashMap;
import java.util.Map;

class TreeNode {

    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {

    public int maxProduct(TreeNode root) {
        Map<TreeNode, Long> sumMap = new HashMap<>();
        long sum = sum(root, sumMap);
        long[] product = new long[1];
        dfs(root, sum, product, sumMap);
        return (int) (product[0] % 1_000_000_007);
    }

    public void dfs(TreeNode root, long sum, long[] product, Map<TreeNode, Long> sumMap) {
        if (root == null) {
            return;
        }
        long a = root.val + sum(root.left, sumMap) + sum(root.right, sumMap);
        long b = sum - a;
        product[0] = Math.max(product[0], a * b);
        dfs(root.left, sum, product, sumMap);
        dfs(root.right, sum, product, sumMap);
    }

    public long sum(TreeNode root, Map<TreeNode, Long> sumMap) {
        if (root == null) {
            return 0;
        }
        if (sumMap.containsKey(root)) {
            return sumMap.get(root);
        }
        long value = root.val + sum(root.left, sumMap) + sum(root.right, sumMap);
        sumMap.put(root, value);
        return value;
    }
}
