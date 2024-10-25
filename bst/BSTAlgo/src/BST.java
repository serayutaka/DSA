package src;

public class BST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        if (root.val > val) return searchBST(root.left, val);
        return searchBST(root.right, val);
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.val > val) {
                if (curr.left == null) {
                    curr.left = new TreeNode(val);
                    break;
                }
                curr = curr.left;
            }
            else if (curr.val < val) {
                if (curr.right == null) {
                    curr.right = new TreeNode(val);
                    break;
                }
                curr = curr.right;
            }
        }
        return root;
    }
    public TreeNode deleteNode(TreeNode root, int val) {
        if (root == null) return null;
        if (val < root.val) root.left = deleteNode(root.left, val);
        else if (val > root.val) root.right = deleteNode(root.right, val);
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
}
