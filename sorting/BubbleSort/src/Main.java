/*
    Bubble Sort Algorithm
    - Time Complexity : O(n^2) {Worst, Average Case}, O(n) {Best case (already sorted)}
    - Space Complexity : since it in-place algorithm so it require O(1) additional space
    - Characteristic
        - Stable
        - Adaptive (can add flag to detect if any swaps were made in a pass)
 */

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