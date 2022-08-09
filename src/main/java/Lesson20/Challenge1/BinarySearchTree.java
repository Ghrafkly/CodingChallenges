package Lesson20.Challenge1;

public class BinarySearchTree {
    BSTNode root;

    BinarySearchTree() {
        root = null;
    }

    BinarySearchTree(int value) {
        root = new BSTNode(value);
    }

    public void insert(int key) {
        root = insertRec(root, key);
    }

    public BSTNode insertRec(BSTNode root, int key) {
        if (root == null) {
            root = new BSTNode(key);
            return root;
        } else if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    public void inorder() {
        inorderRec(root);
    }

    public void inorderRec(BSTNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.left + " " + root.key + " " + root.right);
            inorderRec(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree(50);

        tree.insert(30);
        tree.insert(40);
        tree.insert(70);
        tree.insert(20);
        tree.insert(60);
        tree.insert(80);
        tree.insert(25);

        tree.inorder();
    }
}
