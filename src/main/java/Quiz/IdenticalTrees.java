package Quiz;

public class IdenticalTrees {
    public static boolean isIdentical(BSTNode root1, BSTNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        if (root1.key != root2.key)
            return false;
        return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
    }

    public static void main(String[] args) {
        // 2 identical trees
        BinarySearchTree tree1 = new BinarySearchTree();
        BinarySearchTree tree2 = new BinarySearchTree();

        tree1.setRoot(new BSTNode(50));
        tree2.setRoot(new BSTNode(50));


        tree1.insert(30);
        tree1.insert(40);
        tree1.insert(70);
        tree1.insert(20);
        tree1.insert(60);

        tree2.insert(30);
        tree2.insert(40);
        tree2.insert(70);
        tree2.insert(20);
        tree2.insert(60);

        System.out.println("Are the trees identical? " + isIdentical(tree1.getRoot(), tree2.getRoot()));

        // 2 non-identical trees
        BinarySearchTree tree3 = new BinarySearchTree();
        BinarySearchTree tree4 = new BinarySearchTree();

        tree3.setRoot(new BSTNode(50));
        tree4.setRoot(new BSTNode(50));

        tree3.insert(30);
        tree3.insert(40);
        tree3.insert(70);
        tree3.insert(20);
        tree3.insert(60);

        tree4.insert(30);
        tree4.insert(40);
        tree4.insert(70);
        tree4.insert(20);
        tree4.insert(999);

        System.out.println("Are the trees identical? " + isIdentical(tree3.getRoot(), tree4.getRoot()));
    }
}
