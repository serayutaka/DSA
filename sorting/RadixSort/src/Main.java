//TIP
//<li>Radix Sort<li>
//<li>Time Complexity: <b>O(W(N+K))</b> (where <i>W</i> be the maximum digit length within the list of integers)</li>
//<li>Space Complexity: <b>O(N+K)</b></li>
//<li>Characteristic</li>
//<ul>
//<li>stable</li>
//<li>sorting in close to linear time (when <i>W</i> is small and set of integers and strings with a reasonable <i>W</i> and <i>K</i>)

public class Main {
    public static void main(String[] args) {
        int[] arr = {256,336,736,443,831,907};
        radixSort(arr);

        for (int elem : arr) {
            System.out.printf(elem + " ");
        }
        System.out.println();
    }


    private static final int NUM_DIGITS = 10;

    public static void countingSort(int[] arr, int placeVal) {
        //TIP
        // Sorts an array of integers where minimum value is 0 and maximum value is NUM_DIGITS
        int[] counts = new int[NUM_DIGITS];

        for (int elem : arr) {
            int current = elem / placeVal;
            counts[current % NUM_DIGITS] += 1;
        }

        //TIP
        // we now overwrite our original counts with the starting index
        // of each digit in our group of digits
        int startingIndex = 0;
        for (int i = 0; i < counts.length; i++) {
            int count = counts[i];
            counts[i] = startingIndex;
            startingIndex += count;
        }

        int[] sortedArray = new int[arr.length];
        for (int elem : arr) {
            int current = elem / placeVal;
            sortedArray[counts[current % NUM_DIGITS]] = elem;

            //TIP
            // since we have placed an item in index counts[current % NUM_DIGITS],
            // we need to increment counts[current % NUM_DIGITS] index by 1 so the
            // next duplicate digit is placed in appropriate index
            counts[current % NUM_DIGITS] += 1;
        }

        //TIP
        // common practice to copy over sorted list into original arr
        // it's fine to just return the sortedArray at this point as well
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sortedArray[i];
        }
    }

    public static void radixSort(int[] arr) {
        int maxElem = Integer.MIN_VALUE;
        for (int elem : arr) {
            if (elem > maxElem) {
                maxElem = elem;
            }
        }

        int placeVal = 1;
        while (maxElem / placeVal > 0) {
            countingSort(arr, placeVal);
            placeVal *= 10;
        }
    }
}