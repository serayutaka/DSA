package solutions.pack10_bst;

import java.util.ArrayList;

public class BST {
    TreeNode root;
    public BST() { root = null; }
    public TreeNode getRoot() { return root; }

    public void insert(int d) {
        TreeNode curr = root;
        if (curr == null) {
            root = new TreeNode(d);
            return;
        }
        while (true) {
            if (curr.data > d) {
                if (curr.left == null) {
                    curr.left = new TreeNode(d);
                    break;
                } else {
                    curr = curr.left;
                }
            } else if (curr.data < d) {
                if (curr.right == null) {
                    curr.right = new TreeNode(d);
                    break;
                } else {
                    curr = curr.right;
                }
            }
        }
    }

    public TreeNode search(int d) {
        return searchBST(root, d);
    }
    private TreeNode searchBST(TreeNode root, int d) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.data == d) return curr;
            if (curr.data > d) return searchBST(curr.left, d);
            return searchBST(curr.right, d);
        }
        return null;
    }

    public void delete(int d) {
        deleteNode(root, d);
        return;
    }
    private TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.data > key) root.left = deleteNode(root.left, key);
        else if (root.data < key) root.right = deleteNode(root.right, key);
        else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            TreeNode curr = root.right;
            while (curr.left != null) {
                curr = curr.left;
            }
            root.data = curr.data;
            root.right = deleteNode(root.right, root.data);
        }
        return root;
    }

    public TreeNode findMin() {
        return findMinBST(root);
    }
    private TreeNode findMinBST(TreeNode curr) {
        if (curr == null) return null;
        if (curr.left == null) return curr;
        return findMinBST(curr.left);
    }

    public TreeNode findMax() {
        return findMaxBST(root);
    }
    private TreeNode findMaxBST(TreeNode curr) {
        if (curr == null) return null;
        if (curr.right == null) return curr;
        return findMaxBST(curr.right);
    }

    public int count() {
        return CountNodeBST(root);
    }
    private int CountNodeBST(TreeNode curr) {
        if (curr == null) return 0;
        return 1 + CountNodeBST(curr.left) + CountNodeBST(curr.right);
    }

    public int height() {
        return heightBST(root);
    }
    private int heightBST(TreeNode curr) {
        if (curr == null) return 0;
        int leftHeight = heightBST(curr.left);
        int rightHeight = heightBST(curr.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int findMedian() {
        ArrayList<Integer> list = new ArrayList<>();
        inorderTraverse(root, list);
        if (list.size() % 2 == 0)  return (list.get(list.size() / 2) + list.get(list.size() / 2 - 1)) / 2;
        return list.get(list.size() / 2);
    }
    private void inorderTraverse(TreeNode curr, ArrayList<Integer> list) {
        if (curr == null) return;
        inorderTraverse(curr.left, list);
        list.add(curr.data);
        inorderTraverse(curr.right, list);
    }

    private static int rank = 1;
    private static boolean found;
    private void inorderTraverseSearch(TreeNode curr, int num) {
        if (curr == null) return;
        inorderTraverseSearch(curr.left, num);
        if (curr.data == num) {
            found = true;
            return;
        }
        if (!found) rank += 1;
        inorderTraverseSearch(curr.right, num);
    }
    public int findRank(int num) {
        inorderTraverseSearch(root, num);
        int res = found ? rank : -1;
        found = false;
        rank = 1;
        return res;
    }

    public void printPreOrder() {
        printPreOrderRecurse(root);
        System.out.println();
    }
    private void printPreOrderRecurse(TreeNode node) {
        if (node == null) return;
        System.out.print(node.data+" ");
        printPreOrderRecurse(node.left);
        printPreOrderRecurse(node.right);
    }

    public void printInOrder() {
        printInOrderRecurse(root);
        System.out.println();
    }
    private void printInOrderRecurse(TreeNode node) {
        if (node == null) return;
        printInOrderRecurse(node.left);
        System.out.print(node.data + " ");
        printInOrderRecurse(node.right);
    }

    public void printPostOrder() {
        printPostOrderRecurse(root);
        System.out.println();
    }
    private void printPostOrderRecurse(TreeNode node) {
        if (node == null) return;
        printPostOrderRecurse(node.left);
        printPostOrderRecurse(node.right);
        System.out.print(node.data + " ");
    }


}
