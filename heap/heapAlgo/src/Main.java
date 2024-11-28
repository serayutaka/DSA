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

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int[][] points = {{1,3},{-2,2}};
        int k = 1;

//        int[] res = topKFrequent(nums, k);
        int[][] res = kClosest(points, k);

        for (int[] point : res) {
            System.out.println(point[0] + " " + point[1]);
        }
    }
//    public static int[] topKFrequent(int[] nums, int k) {
//        HashMap<Integer, Integer> dict = new HashMap<Integer, Integer>();
//
//        for (int num : nums) {
//            if (!(dict.containsKey(num))) {
//                dict.put(num, 0);
//            }
//            dict.put(num, dict.get(num)+1);
//        }
//
//        Heap heap = new Heap();
//        dict.forEach((key, value) -> {
//            heap.insert(value);
//        });
//
//        ArrayList<Integer> temp_res = new ArrayList<Integer>();
//        for (int i = 0; i < k; i++) {
//            int candidate = heap.delete(0);
//            dict.forEach((key, value) -> {
//                if (value == candidate && !temp_res.contains(key)) temp_res.add(key);
//            });
//        }
//
//        int[] res = new int[k];
//        for (int i = 0; i < k; i++) {
//            res[i] = temp_res.get(i);
//        }
//
//        return res;
//    }

    public static int[][] kClosest(int[][] points, int k) {
        Heap heap = new Heap();
        for (int[] point : points) {
            double p1 = Math.pow(point[0], 2);
            double p2 = Math.pow(point[1], 2);
            double dist = Math.sqrt(p1 + p2);
            heap.insert(dist);
        }

        ArrayList<int[]> temp_res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            double candidate = heap.delete(0);
            for (int[] point : points) {
                double p1 = Math.pow(point[0], 2);
                double p2 = Math.pow(point[1], 2);
                double dist = Math.sqrt(p1 + p2);
                if (candidate == dist && !temp_res.contains(point)) temp_res.add(point);
            }
        }

        int[][] res = new int[temp_res.size()][];
        for (int i = 0; i < temp_res.size(); i++) {
            res[i] = temp_res.get(i);
        }

        return res;
    }
}