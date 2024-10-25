package solutions.pack9_Heap;

public class MyPriorityQueue implements MyQueueInterface {
    MyMinHeap heap = new MyMinHeap();

    @Override
    public void enqueue(int d) {
        if (isFull()) {
            System.out.println(d + " can't enqueue cause heap is full.");
            return;
        }
        heap.insert(d);
    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("can't dequeue cause heap is empty.");
            return -1;
        }
        return heap.remove();
    }

    @Override
    public int front() {
        if (isEmpty()) {
            System.out.println("can't dequeue cause heap is empty.");
            return -1;
        }
        return heap.top();
    }

    @Override
    public boolean isFull() {
        return heap.isFull();
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public String toString() {
        return heap.toString();
    }
}
