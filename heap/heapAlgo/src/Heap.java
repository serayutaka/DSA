import java.util.ArrayList;

public class Heap {
    ArrayList<Double> v = new ArrayList<>();

    int getSize() { return v.size(); }

    void insert(double value) {
        v.add(value);
        int curIndex = v.size() - 1;

        while (curIndex != 0) {
            int parentIndex = (curIndex - 1) / 2;

            if (v.get(parentIndex) > value) {
                swap(parentIndex, curIndex);
            }

            curIndex = parentIndex;
        }
    }

    double delete(int index) {
        int lastIndex = v.size() - 1;
        double temp = v.get(index);
        v.set(index, v.get(lastIndex));
        v.set(lastIndex, temp);
        v.remove(lastIndex);
        heapify(index);
        return temp;
    }
    void heapify(int index) {
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

    void swap(int i, int j) {
        double temp = v.get(i);
        v.set(i, v.get(j));
        v.set(j, temp);
    }

    @Override
    public String toString() {
        return v.toString();
    }
}
