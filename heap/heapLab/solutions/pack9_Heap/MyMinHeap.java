package solutions.pack9_Heap;

import java.util.ArrayList;

public class MyMinHeap {
    ArrayList<Integer> v = new ArrayList<>();
    int size = 6;

    public boolean isEmpty() {
        return v.isEmpty();
    }
    public boolean isFull() {
        return v.size() == size;
    }

    public int top() {
        return v.getFirst();
    }

    public void insert(int value) {
        v.add(value);
        int curIndex = v.size() - 1;

        while (curIndex != 0) {
            int parentIndex = (curIndex - 1) / 2;
            if (v.get(parentIndex) > v.get(curIndex)) {
                swap(curIndex, parentIndex);
            }
            curIndex = parentIndex;
        }
    }

    public int remove() {
        int lastIndex = v.size() - 1;
        int temp = v.getFirst();
        v.set(0, v.get(lastIndex));
        v.set(lastIndex, temp);
        v.remove(lastIndex);
        heapify(0);
        return temp;
    }
    public void heapify(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;

        if (leftChildIndex < v.size() && v.get(leftChildIndex) < v.get(index)) {
            swap(leftChildIndex, index);
            heapify(leftChildIndex);
        }
        if (rightChildIndex < v.size() && v.get(rightChildIndex) < v.get(index)) {
            swap(rightChildIndex, index);
            heapify(rightChildIndex);
        }
    }

    public void swap(int i, int j) {
        int temp = v.get(i);
        v.set(i, v.get(j));
        v.set(j, temp);
    }

    @Override
    public String toString() {
        return v.toString();
    }
}
