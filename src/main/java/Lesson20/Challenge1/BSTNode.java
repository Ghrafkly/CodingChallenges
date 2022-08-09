package Lesson20.Challenge1;

public class BSTNode {
    public int key;
    public BSTNode left, right;

    public BSTNode (int item) {
        key = item;
        left = right = null;
    }

    @Override
    public String toString() {
        return "BSTNode{" +
                "key=" + key +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
