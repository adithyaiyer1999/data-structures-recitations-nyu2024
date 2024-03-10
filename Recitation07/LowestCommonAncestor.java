package rec_dfs;

import java.util.*;

import rec_dfs.GoodNodesInBinaryTree;

public class LowestCommonAncestor {

    // Helper function to find the path from root to a target node
    private boolean findPath(TreeNode root, List<Integer> path, int target) {
        if (root == null)
            return false;

        path.add(root.val);

        if (root.val == target)
            return true;

        if ((root.left != null && findPath(root.left, path, target)) ||
            (root.right != null && findPath(root.right, path, target)))
            return true;

        path.remove(path.size() - 1);
        return false;
    }

    // Main function to find the LCA
    public int findLCA(TreeNode root, int n1, int n2) {
        List<Integer> path1 = new ArrayList<>();
        List<Integer> path2 = new ArrayList<>();

        if (!findPath(root, path1, n1) || !findPath(root, path2, n2))
            return -1;

        int i;
        for (i = 0; i < path1.size() && i < path2.size(); i++) {
            if (!path1.get(i).equals(path2.get(i)))
                break;
        }

        return path1.get(i - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        LowestCommonAncestor lcaFinder = new LowestCommonAncestor();
        System.out.println("LCA (4, 5) = " + lcaFinder.findLCA(root, 4, 5));
        System.out.println("LCA (4, 6) = " + lcaFinder.findLCA(root, 4, 6));
        System.out.println("LCA (3, 4) = " + lcaFinder.findLCA(root, 3, 4));
        System.out.println("LCA (2, 4) = " + lcaFinder.findLCA(root, 2, 4));
    }
}
