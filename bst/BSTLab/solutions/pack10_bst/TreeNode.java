package solutions.pack10_bst;

public class TreeNode {
    int data;
    TreeNode left, right, parent;
    public TreeNode(int d) {
        data = d;
    }

    @Override
    public String toString() {
        return (left == null ? "null" : String.valueOf(left.data)) + "<-" + String.valueOf(data) + "->" + (right == null ? "null" : String.valueOf(right.data));
    }
}
