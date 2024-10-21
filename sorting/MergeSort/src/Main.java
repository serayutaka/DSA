//TIP
//<b>MergeSort Algorithm</b>
//<li>Time Complexity: <b>O(nlogn)</b></li>
//<li>Space Complexity: <b>O(n)</b>
//<li>Characteristics</li>
//<ul>
//<li>stable</li>
//<li>best for sorting linked list</li>

public class Main {
    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 3};
        MergeSort(arr, 0, arr.length - 1);

        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void MergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            MergeSort(arr, left, mid);
            MergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int left_n = mid - left + 1;
        int right_n = right - mid;

        int[] left_arr = new int[left_n];
        int[] right_arr = new int[right_n];

        System.arraycopy(arr, left, left_arr, 0, left_n);
        System.arraycopy(arr, mid+1, right_arr, 0, right_n);

        int i = 0, j = 0, k = left;
        while (i < left_n && j < right_n) {
            if (left_arr[i] <= right_arr[j]) {
                arr[k] = left_arr[i];
                k += 1;
                i += 1;
            } else {
                arr[k] = right_arr[j];
                k += 1;
                j += 1;
            }
        }

        while (i < left_n) {
            arr[k] = left_arr[i];
            k += 1;
            i += 1;
        }
        while (j < right_n) {
            arr[k] = right_arr[j];
            k += 1;
            j += 1;
        }
    }
}