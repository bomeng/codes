package solution_623;


import java.util.LinkedList;
import java.util.Queue;

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

class Item {

    TreeNode node;
    boolean isLeft;

    public Item(TreeNode node, boolean isLeft) {
        this.node = node;
        this.isLeft = isLeft;
    }
}

public class Solution {

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        Queue<Item> queue = new LinkedList<>();
        queue.offer(new Item(root, true));
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level = level + 1;
            if (level == d) {
                for (int i = 0; i < size; i++) {
                    Item item = queue.poll();
                    TreeNode newNode = new TreeNode(item.node.val);
                    newNode.left = item.node.left;
                    newNode.right = item.node.right;

                    item.node.val = v;
                    if (item.isLeft) {
                        item.node.left = newNode;
                        item.node.right = null;
                    } else {
                        item.node.right = newNode;
                        item.node.left = null;
                    }
                }
            } else {
                for (int i = 0; i < size; i++) {
                    Item item = queue.poll();
                    if (item.node.left != null) {
                        queue.offer(new Item(item.node.left, true));
                    }
                    if (item.node.right != null) {
                        queue.offer(new Item(item.node.right, false));
                    }
                }
            }
        }
        return root;
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
