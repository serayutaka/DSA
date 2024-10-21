//TIP
// <b>Selection Sort</b>
// <li>Time Complexity: <b>O(n^2)</b> for every case</li>
// <li>Space Complexity: <b>O(1)</b>
// <li>Characteristic</li>
// <ul>
// <li>unstable i.e. does not preserve the order of duplicate elements</li>
// <li>is best when swapping is a costly operation</li>
// </ul>

public class Main {
    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 3};
        SelectionSort(arr);
        for (int num : arr) {
            System.out.printf("%d ", num);
        }
        System.out.println();
    }

    public static void SelectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}