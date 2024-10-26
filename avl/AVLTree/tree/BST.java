package tree;

public class BST {
    private TreeNode root;
    public BST() { root = null; }
    public TreeNode getRoot() { return root; }

    public TreeNode insert(int key) {
        TreeNode curr = root;
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }
        else {
            while (curr != null) {
                if (key < curr.val) {
                    if (curr.left == null) {
                        curr.left = new TreeNode(key);
                        break;
                    } else curr = curr.left;
                }
                else if (key > curr.val) {
                    if (curr.right == null) {
                        curr.right = new TreeNode(key);
                        break;
                    } else curr = curr.right;
                }
            }
        }
        return curr;
    }

    public boolean search(int key) {
        return searchBST(root, key);
    }
    private boolean searchBST(TreeNode curr, int key) {
        if (curr == null) return false;
        if (curr.val == key) return true;
        else if (key < curr.val) return searchBST(curr.left, key);
        return searchBST(curr.right, key);
    }

    public TreeNode delete(int key) {
        return deleteNode(root, key);
    }
    private TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key < root.val) root.left = deleteNode(root.left, key);
        else if (key > root.val) root.right = deleteNode(root.right, key);
        else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            TreeNode curr = root.right;
            while (curr.left != null) {
                curr = curr.left;
            }
            root.val = curr.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    public void printInOrder() {
        printInOrder(root);
        System.out.println();
    }
    private void printInOrder(TreeNode curr) {
        if (curr == null) return;
        printInOrder(curr.left);
        System.out.print(curr.val + " ");
        printInOrder(curr.right);
    }
}
