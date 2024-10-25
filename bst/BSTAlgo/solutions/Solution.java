package solutions;
import src.*;

// solution for Leetcode-98
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    private boolean validate(TreeNode node, Double left, Double right) {
        if (node == null) return true;
        if (!(node.val < right && node.val > left)) return false;
        double val = node.val;
        return validate(node.left, left, val) && validate(node.right, val, right);
    }
}
