//TIP
//<p>A <b>binary search tree</b> (BST), a special form of a binary tree, satisfies the binary
//search property:</p>
//<p>1. The value in each node must be <b>greater than</b> (or equal to) any values stored in its left subtree.</p>
//<p>2. The value in each node must be <b>less than</b> (or equal to) any values stored in its right subtree.</p>
//<p>BSTs support three main operations: <b>search</b>, <b>insertion</b>, and <b>deletion</b></p>
//<h3>Search</h3>
//<p>According to the property of BST, for each node:</p>
//<ol>
//<li>return the node if the target value is <i><b>equal to</b></i> the value of the node;</li>
//<li>continue searching in the <i><b>left</b></i> subtree if the target value is <i><b>less than</b></i> the value of the node;</li>
//<li>continue searching in the <i><b>right</b></i> subtree if the target value is <i><b>larger than</b></i> the value of the node.</li>
//</ol>
//<h3>Insertion</h3>
//<p>The main idea is to find out a proper leaf position for the target node and then insert the node as a leaf. Therefor, insertion wil begin as a search.</p>
//<br>
//<p>Similar to our search strategy, for each node, we will:</p>
//<ol>
//<li>search the left or right subtrees according to the relation of the value of the node and the value of our target node;</li>
//<li>repeat STEP 1 until reaching an external node;</li>
//<li>add the new node as its left or right child depending on the relation of the value of the node and the value of our target node.</li>
//</ol>
//<h3>Deletion</h3>
//<p>Deletion is more complicated than the two operations we mention before.</p>
//<p>Our solution is to replace the target node with proper child.</p>
//<p>According to the number of its children, we should consider three different cases</p>
//<ol>
//<li>If the target node has <i><b>no child</b></i>, we can simply remove the node.</li>
//<li>If the target node has <i><b>one child</b></i>, we can use its child to replace itself.</li>
//<li>If the target node has <i><b>two child</b></i>, replace the node with its in-order successor or predecessor node and delete that node.</li>
//</ol>

//<br>
//<p>facts that you should know:</p>
//<ul>
//<li><b>inorder traversal</b> in BST will be <b>ascending order</b> and it's the most frequent used traversal method of a BST.</li>

package src;

public class Main {
    // Modified printBST to show null nodes
    public static void printBST(TreeNode root, String prefix, boolean isLeft) {
        if (root == null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + "null");
            return;
        }

        System.out.println(prefix + (isLeft ? "├── " : "└── ") + root.val);

        printBST(root.left, prefix + (isLeft ? "│   " : "    "), true);
        printBST(root.right, prefix + (isLeft ? "│   " : "    "), false);
    }

    public static void main(String[] args) {
        BST bst = new BST();
        TreeNode root = null;

        // Test insertion
        System.out.println("Testing BST insertion:");
        root = new TreeNode(5);  // Create initial root
        bst.insertIntoBST(root, 3);
        bst.insertIntoBST(root, 7);
        bst.insertIntoBST(root, 2);
        bst.insertIntoBST(root, 4);
        bst.insertIntoBST(root, 6);
        bst.insertIntoBST(root, 8);

        System.out.println("BST after insertions:");
        printBST(root, "", false);
        System.out.println();

        // Test search
        System.out.println("Testing BST search:");
        TreeNode found = bst.searchBST(root, 4);
        System.out.println("Search for 4: " + (found != null ? "Found" : "Not found"));
        found = bst.searchBST(root, 9);
        System.out.println("Search for 9: " + (found != null ? "Found" : "Not found"));
        System.out.println();

        // Test deletion
        System.out.println("Testing BST deletion:");
        System.out.println("Deleting node with value 3");
        root = bst.deleteNode(root, 3);
        System.out.println("BST after deleting 3:");
        printBST(root, "", false);
        System.out.println();

        System.out.println("Deleting node with value 5 (root)");
        root = bst.deleteNode(root, 5);
        System.out.println("BST after deleting 5:");
        printBST(root, "", false);
    }
}