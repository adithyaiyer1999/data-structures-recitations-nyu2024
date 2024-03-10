package rec_dfs;

import java.util.*;
import rec_dfs.GoodNodesInBinaryTree;

//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode(int val) {
//        this.val = val;
//        this.left = null;
//        this.right = null;
//    }
//}

public class ZigzagLevelOrderTraversalBFS {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelValues = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (leftToRight) {
                    levelValues.add(node.val);
                } else {
                    levelValues.add(0, node.val); // Add to the beginning for reverse order
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(levelValues);
            leftToRight = !leftToRight;
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
//        root.left.left = new TreeNode(7);
//        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        ZigzagLevelOrderTraversalBFS solution = new ZigzagLevelOrderTraversalBFS();
        List<List<Integer>> result = solution.zigzagLevelOrder(root);

        System.out.println("Zigzag Order traversal of binary tree is:");
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
}
