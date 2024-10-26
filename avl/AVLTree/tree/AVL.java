package tree;

public class AVL extends BST {
    private int height(TreeNode node) {
        return node != null ? node.height : -1;
    }
    private void updateHeight(TreeNode node) {
        int leftChildHeight = node.left == null ? 0 : height(node.left);
        int rightChildHeight = node.right == null ? 0 : height(node.right);
        node.height = Math.max(leftChildHeight, rightChildHeight) + 1;
    }
    private int balanceFactor(TreeNode node) {
        return height(node.right) - height(node.left);
    }

    private TreeNode rotateRight(TreeNode node) {
        TreeNode leftChild = node.left;
        node.left = leftChild.right;
        leftChild.right = node;

        updateHeight(node);
        updateHeight(leftChild);
        return leftChild;
    }
    private TreeNode rotateLeft(TreeNode node) {
        TreeNode rightChild = node.right;
        node.right = rightChild.left;
        rightChild.left = node;

        updateHeight(node);
        updateHeight(rightChild);
        return rightChild;
    }

    private TreeNode re_balance(TreeNode node) {
        int balanceFactor = balanceFactor(node);

        // Left-heavy?
        if (balanceFactor < -1) {
            if (balanceFactor(node.left) <= 0) {
                // Rotate right
                node = rotateRight(node);
            } else {
                // Rotate left-right
                node.left = rotateLeft(node.left);
                node = rotateRight(node);
            }
        }

        // Right-heavy?
        if (balanceFactor > 1) {
            if (balanceFactor(node.right) >= 0) {
                // Rotate left
                node = rotateLeft(node);
            } else {
                // Rotate right-left
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
            }
        }
        return node;
    }

    @Override
    public TreeNode insert(int key) {
        TreeNode node = super.insert(key);
        updateHeight(node);
        return re_balance(node);
    }

    @Override
    public TreeNode delete(int key) {
        TreeNode node = super.delete(key);

        if (node == null) return null;

        updateHeight(node);
        return re_balance(node);
    }
}
