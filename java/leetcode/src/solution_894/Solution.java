package solution_894;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

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

    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> list = new ArrayList<>();
        if (N % 2 == 0) {
            return list;
        }
        Map<Integer, List<TreeNode>> map = new HashMap<>();
        map.put(1, Arrays.asList(new TreeNode(0)));
        for (int i = 3; i <= N; i = i + 2) {
            List<TreeNode> nodes = new ArrayList<>();
            for (int j = 1; j < i; j = j + 2) {
                List<TreeNode> leftNodes = map.get(j);
                List<TreeNode> rightNodes = map.get(i - 1 - j);
                for (TreeNode leftNode : leftNodes) {
                    for (TreeNode rightNode : rightNodes) {
                        TreeNode node = new TreeNode(0);
                        node.left = leftNode;
                        node.right = rightNode;
                        nodes.add(node);
                    }
                }
            }
            map.put(i, nodes);
        }
        return map.get(N);
    }
}
