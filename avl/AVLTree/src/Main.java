import tree.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Example output:");
//        task1();
        testAVL();
    }
    public static void task1() {
        System.out.println("--- task 1 ---");
        int data[] = { 15, 20, 10, 18, 16, 12, 8, 25, 19, 30 };

        BST bst = new BST();
        for (int i=0; i<data.length; i++)
            bst.insert(data[i]);

        bst.printInOrder();
        System.out.println(bst.search(20));
        System.out.println(bst.search(25));
        System.out.println(bst.search(12));
        System.out.println(bst.search(1));
        bst.delete(12);
        bst.delete(25);
        bst.delete(100);
        System.out.println(bst.search(12));
        System.out.println(bst.search(20));
    }

    public static void testAVL() {
        System.out.println("Testing AVL Tree Operations");
        System.out.println("==========================");

        AVL avl = new AVL();

        // Test 1: Insert elements that cause right-heavy situation
        System.out.println("Test 1: Right-heavy insertions (10, 20, 30)");
        avl.insert(10);
        avl.insert(20);
        avl.insert(30);
        System.out.print("After right-heavy insertions: ");
        avl.printInOrder();

        // Test 2: Insert elements that cause left-heavy situation
        System.out.println("\nTest 2: Left-heavy insertions (5, 3)");
        avl.insert(5);
        avl.insert(3);
        System.out.print("After left-heavy insertions: ");
        avl.printInOrder();

        // Test 3: Insert element that causes left-right rotation
        System.out.println("\nTest 3: Insert element causing left-right rotation (7)");
        avl.insert(7);
        System.out.print("After left-right rotation: ");
        avl.printInOrder();

        // Test 4: Search operations
        System.out.println("\nTest 4: Search operations");
        System.out.println("Search for 7: " + avl.search(7));  // should return true
        System.out.println("Search for 15: " + avl.search(15)); // should return false

        // Test 5: Delete operations
        System.out.println("\nTest 5: Delete operations");
        System.out.println("Deleting 20...");
        avl.delete(20);
        System.out.print("After deletion: ");
        avl.printInOrder();

        System.out.println("\nDeleting 3...");
        avl.delete(3);
        System.out.print("After deletion: ");
        avl.printInOrder();
    }
}
