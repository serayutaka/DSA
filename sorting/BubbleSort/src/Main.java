//TIP
//    <b>Bubble Sort Algorithm</b>
//    <li>Time Complexity : <b>O(n<sup>2</sup>)</b> {Worst, Average Case}, <b>O(n)</b> {Best case (already sorted)}</li>
//    <li>Space Complexity : since it in-place algorithm so it require <b>O(1)< additional space</li>
//    <li>Characteristic</li>
//    <ul>
//    <li>Stable</li>
//    <li>Adaptive (can add flag to detect if any swaps were made in a pass)</li>
//    </ul>

public class Main {
    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 3};
        BubbleSort(arr);
        for (int num : arr) {
            System.out.printf(num + " ");
        }
        System.out.println();
    }

    public static void BubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > (arr[j + 1])) {
                    swap(arr, j, j+1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}