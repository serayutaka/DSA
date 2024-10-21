//TIP
// <b>Insertion Sort</b>
// <li>Time Complexity: <b>O(n^2)</b> (Average), <b>O(n)</b> (Best), <b>O(n^2)</b> (Worst)</li>
// <li>Space Complexity: <b>O(1)</b></li>
// <li>Characteristics</li>
// <ul>
// <li>Efficient for small or nearly sorted data sets but less efficient for large or unsorted dataset</li>
// <li>It's stable sorting algorithm</li>
public class Main {
    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 1};
        InsertionSort(arr);
        for (int elem : arr) {
            System.out.printf("%d ", elem);
        }
        System.out.println();
    }

    public static void InsertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}