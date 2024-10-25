package solutions.pack9_Heap;

public class MyHeapSort extends MyMinHeap {
    public String sort() {
        if (isEmpty()) {
            return "";
        }
        int[] res = new int[v.size()];
        int temp_size = v.size();
        for (int i = 0; i < temp_size; i++) {
            res[i] = remove();
        }
        for (int i = 0; i < temp_size; i++) {
            insert(res[i]);
        }
        return v.toString();
    }
}
