//TIP
// <b>Counting Sort</b>
// <li>Time Complexity: <b>O(N+K)</b> (where <i>N</i> is the size of the input array and <i>K</i> is the maximum value in the array)</li>
// <li>Space Complexity: <b>O(N+K)</b> (since we have to initialize a new array of size <i>N</i> and a counts array of size <i>K+1</i>)</li>
// <li>Characteristic<li>
// <ul>
// <li>stable</li>
// <li>can be significantly faster than other comparison based sorts on larger collections of integers with a relatively small range of values</li>
// <li>slower when range of <i>K</i> is large compared to <i>N</i> (time complexity will change depends on size of <i>K</i>)


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 3};
        countingSort(arr);
        for (int elem : arr) {
            System.out.printf(elem + " ");
        }
        System.out.println();
    }

    public static void countingSort(int[] arr) {
        int K = Arrays.stream(arr).max().getAsInt();
        int[] counts = new int[K+1];
        for (int elem : arr) {
            counts[elem] += 1;
        }

        //TIP
        // we now overwrite our original counts with the starting index
        // of each element in the final sorted array
        int startingIndex = 0;
        for (int i = 0; i < K+1; i++) {
            int count = counts[i];
            counts[i] = startingIndex;
            startingIndex += count;
        }

        int[] sortedArr = new int[arr.length];
        for (int elem : arr) {
            sortedArr[counts[elem]] = elem;
            //TIP
            // since we have placed an item in index counts[elem], we need to
            // increment counts[elem] index by 1 so the next duplicate element
            // is placed in appropriate index
            counts[elem] += 1;
        }

        //TIP
        // common practice to copy over sorted list into original arr
        // it's fine to just return the sortedArr at this point as well
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sortedArr[i];
        }
    }
}