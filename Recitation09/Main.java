package avltree;
// Note : You will have a quiz next recitation class
public class Main {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        // Insert some nodes
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(5);
        tree.insert(15);
        tree.insert(25);
        tree.insert(35);

        // Print the tree
        printTree(tree.getRoot(), 0);
        System.out.println();

        // Find a node
        AVLTree.Node node = tree.find(25);
        if (node != null) {
            System.out.println("Found node with key: " + node.key);
        } else {
            System.out.println("Node not found");
        }

        // Delete a node
        tree.delete(20);
        System.out.println("After deleting node with key 20:");
        printTree(tree.getRoot(), 0);
        System.out.println();

        // Get the height of the tree
        System.out.println("Height of the tree: " + tree.height());
    }

    private static void printTree(AVLTree.Node root, int level) {
        if (root != null) {
            printTree(root.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println(root.key);
            printTree(root.left, level + 1);
        }
    }
}