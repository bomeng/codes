package solution_863;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        dfs(root, parentMap, null);

        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count = count + 1;
            if (count == K) {
                break;
            }
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                visited.add(node);
                if (node.left != null && !visited.contains(node.left)) {
                    queue.offer(node.left);
                }
                if (node.right != null && !visited.contains(node.right)) {
                    queue.offer(node.right);
                }
                if (parentMap.get(node) != null && !visited.contains(parentMap.get(node))) {
                    queue.offer(parentMap.get(node));
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll().val);
        }
        return result;
    }

    private void dfs(TreeNode node, Map<TreeNode, TreeNode> map, TreeNode parent) {
        if (node == null) {
            return;
        }
        map.put(node, parent);
        dfs(node.left, map, node);
        dfs(node.right, map, node);
    }
}
