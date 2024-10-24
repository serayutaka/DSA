//TIP
// <b>Heap</b>
// <p>In binary heap, both insertion and deletion operations have a time complexity of <b>O(<i>logN</i>)</b>,
// where N is the number of elements in the heap.</p>

//<b>Insertion</b>
//<ul>
//<li>In insertion we insert an element and swap with children if the property of heap is not satisfied.</li>
//<li>In worst case the element has the lowest priority and is moved to the depth of the binary tree.</li>
//<li>The depth of a binary tree is <b><i>log<sub>2</sub>N</i></b>.</li>
//</ul>
//
//<b>Deletion</b>
//<ul>
//<li>In deletion we swap the element to be deleted with the last element and pop(remove) the last element.</li>
//<li>We check all the children of the index which is deleted and if the Heap property is violated swap the elements and recursively check for the child.</li>
//<li>Similar to insertion in worst case we may need to swap all the way to entire depth of the binary heap tree which is <b><i>log<sub>2</sub>N</i></b>.</li>
//</ul>
//
//<b>PS. please note that this heap is a min-heap</b>

public class Main {
    public static void main(String[] args) {
        Heap h1 = new Heap();
        int[] arr = {4, 2, 3, 1, 5, 6, 7, 8, 9};
        int[] arr2 = {1, 2, 1, 6, 3, 4, 3};

        for (int elem : arr) {
            h1.insert(elem);
        }
        for (int i : h1.v) {
            System.out.print(i + " ");
        }
        System.out.println();

        h1.delete(0);
        h1.delete(1);
        for (int i : h1.v) {
            System.out.print(i + " ");
        }

        System.out.println();
    }
}