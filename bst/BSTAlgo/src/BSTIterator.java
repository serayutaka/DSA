package src;
import java.util.ArrayList;


// Solution for Leetcode-173
public class BSTIterator {
    ArrayList<TreeNode> stack = new ArrayList<TreeNode>();
    public BSTIterator(TreeNode root) {
        addToStack(root);
    }

    public int next() {
        TreeNode res = stack.removeLast();
        TreeNode cur = res.right;
        addToStack(cur);
        return res.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void addToStack(TreeNode cur) {
        while(cur != null) {
            stack.add(cur);
            cur = cur.left;
        }
    }
}
