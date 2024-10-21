//TIP
// <b>QuickSort Algorithm</b>
// <li>Time Complexity: <b>O(nlogn)</b> (Best and Average), <b>O(n^2)</b> (Worst) </li>
// <li>Space Complexity: <b>O(logn)</b>
// <li>Characteristics</li>
// <ul>
// <li>unstable</li>
// <li>Preferred for sorting an array</li>
// </ul>

public class Main {
    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 1};
        QuickSort(arr, 0, arr.length - 1);
        for (int elem : arr) {
            System.out.printf("%d ", elem);
        }
        System.out.println();
    }
    public static void QuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            QuickSort(arr, low, pi - 1);
            QuickSort(arr, pi + 1, high);
        }
    }
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i += 1;
                if (j > i) swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}