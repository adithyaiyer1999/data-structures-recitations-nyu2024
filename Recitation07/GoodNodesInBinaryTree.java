package rec_dfs;

import java.util.LinkedList;
import java.util.Queue;


// TreeNode class definition
class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int key) {
        val = key;
        left = right = null;
    }
}

public class GoodNodesInBinaryTree {
    // DFS approach
    static int goodNodesDFS(TreeNode root, int maxSoFar) {
        if (root == null)
            return 0;
        
        int count = 0;
        if (root.val >= maxSoFar) {
            count++;
            maxSoFar = root.val;
        }

        count += goodNodesDFS(root.left, maxSoFar);
        count += goodNodesDFS(root.right, maxSoFar);

        return count;
    }


    public static void main(String[] args) {
        // Construct a sample binary tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(5);
        root.right.left = new TreeNode(1);

        // Test DFS
        int dfsCount = goodNodesDFS(root, Integer.MIN_VALUE);
        System.out.println("DFS Good Nodes Count: " + dfsCount);
        
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(2);

        // Test DFS
        int dfsCount2 = goodNodesDFS(root2, Integer.MIN_VALUE);
        System.out.println("DFS Good Nodes Count 2: " + dfsCount2);

    }
}
